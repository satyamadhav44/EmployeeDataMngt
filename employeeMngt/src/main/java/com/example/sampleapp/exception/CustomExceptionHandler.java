package com.example.sampleapp.exception;

import lombok.Getter;

@Getter
public class CustomExceptionHandler extends RuntimeException{
  private String errorCode;
    public CustomExceptionHandler(String message,String code){
        super(message);
        this.errorCode=code;
    }

}
