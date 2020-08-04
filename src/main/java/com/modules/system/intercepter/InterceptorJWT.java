package com.modules.system.intercepter;

import com.modules.common.annotation.IgnoreSecurity;
import com.modules.common.jwt.JwtProperties;
import com.modules.common.jwt.JwtUtils;
import com.modules.common.utils.RedisUtils;
import com.modules.common.utils.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求api服务器时，对accessToken进行拦截判断，有效则可以反问接口，否则返回错误
 *
 * @author
 */
@Component
public class InterceptorJWT extends HandlerInterceptorAdapter {

    @Autowired
    private RedisUtils redisUtils;
    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private JwtProperties jwtProperties;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        // 若目标方法忽略了安全性检查，则直接调用目标方法
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            //如果方法上有@IgnoreSecurity注解，则不需要进行token验证
            IgnoreSecurity ignoreSecurity = ((HandlerMethod) handler).getMethodAnnotation(IgnoreSecurity.class);
            if (ignoreSecurity != null) {
                return true;
            }
        }else {
            String token = request.getParameter(jwtProperties.header);
            if (StringUtils.isNotEmpty(token)) {
                Claims claims = jwtUtils.getTokenClaim(token);
                Long userId = (Long) claims.get("userId");
                String redisToken = redisUtils.getToken(userId);
                token = request.getParameter(jwtProperties.header);
                if (!redisToken.equals(token)) {
                    throw new SignatureException(jwtProperties.header + "失效，请重新登录。");
                }
                if (claims == null || jwtUtils.isTokenExpired(claims.getExpiration())) {
                    throw new SignatureException(jwtProperties.header + "失效，请重新登录。");
                }
                /** 设置 identityId 用户身份ID */
                request.setAttribute("identityId", claims.getSubject());
            }else {
                throw new SignatureException(jwtProperties.header + "失效，请重新登录。");
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        super.afterCompletion(request, response, handler, ex);
    }


    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request,
                                               HttpServletResponse response, Object handler) throws Exception {

        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
