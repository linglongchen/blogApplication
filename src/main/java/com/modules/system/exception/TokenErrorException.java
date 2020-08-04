package com.modules.system.exception;

import com.modules.common.generator.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;

/**
 * @author v_vllchen
 */
@RestControllerAdvice
public class TokenErrorException extends RuntimeException{

    @ExceptionHandler(value = { SignatureException.class })
    @ResponseBody
    public Result<?> tokenException(SignatureException e) {
        return Result.error(e.getMessage());
    }
}
