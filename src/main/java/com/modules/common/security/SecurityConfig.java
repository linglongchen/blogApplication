package com.modules.common.security;

import com.modules.common.jwt.JwtProperties;
import com.modules.common.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.annotation.Resource;

/**
 * Security 核心配置类
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private JwtProperties jwtProperties;



    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                //跨域预检请求
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                //登录URL
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                //其它身份需要认证
                .anyRequest().permitAll()
                .and()
                .addFilter(new AuthenticationFilter(authenticationManager(),jwtUtils))
                .addFilter(new AuthentizationFilter(authenticationManager(),jwtUtils,jwtProperties))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //退出登录器
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManager()throws Exception{
        return super.authenticationManager();
    }


}

