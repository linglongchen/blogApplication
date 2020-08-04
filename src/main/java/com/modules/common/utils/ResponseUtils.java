package com.modules.common.utils;

import com.alibaba.fastjson.JSON;
import com.modules.common.generator.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
public class ResponseUtils {

    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(ResponseUtils.class);


    /**
     * 使用response输出JSON
     *
     * @param response
     * @param result
     */
    public static void out(ServletResponse response, Result result) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(result));
        } catch (Exception e) {
            logger.error(e + "输出JSON出错");
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

}
