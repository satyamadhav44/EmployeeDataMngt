package com.example.sampleapp.exception;

import com.example.sampleapp.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionClass {

    @ExceptionHandler(CustomExceptionHandler.class)
    public ResponseEntity<BaseResponse> handleCustomerException(CustomExceptionHandler ex){
        BaseResponse baseResponse = new BaseResponse(ex.getMessage(),ex.getErrorCode());
        return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
