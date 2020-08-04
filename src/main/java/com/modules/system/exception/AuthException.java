package com.modules.system.exception;

import com.modules.common.generator.utils.Result;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author v_vllchen
 */
@RestControllerAdvice
public class AuthException extends RuntimeException{


    public AuthException(HttpServletResponse response){
    }


    @ResponseBody
    public Result<?> AuthException(HttpServletResponse response){
        return new Result().data(response);
    }
}
