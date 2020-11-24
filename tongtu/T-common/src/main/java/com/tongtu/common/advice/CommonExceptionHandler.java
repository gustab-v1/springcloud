package com.tongtu.common.advice;

import com.tongtu.common.exception.TException;
import com.tongtu.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(TException.class)
    public ResponseEntity<ExceptionResult> handlerException(TException exception){
        return ResponseEntity.status(exception.getExceptionEnum().getCode()).body(new ExceptionResult(exception.getExceptionEnum()));
    }
}
