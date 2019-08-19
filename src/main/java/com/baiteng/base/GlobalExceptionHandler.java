package com.baiteng.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({CoreException.class, Exception.class})
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        log.error("handle exception: ", ex);
        if (!(ex instanceof CoreException)) {
            return new ResponseEntity(Result.newFailResult("5000", "服务器发生异常"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CoreException core = (CoreException) ex;
        String responseMessage = core.getMessage();
        if (responseMessage == null) {
            try {
                responseMessage = this.messageSource.getMessage(core.getCode(), core.getArgs(),
                        Locale.getDefault());
            } catch (NoSuchMessageException arg5) {
                responseMessage = "服务器发生异常";
            }
        }

        return new ResponseEntity(Result.newFailResult(core.getCode(), responseMessage), HttpStatus.OK);
    }
}