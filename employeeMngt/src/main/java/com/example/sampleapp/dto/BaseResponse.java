package com.example.sampleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BaseResponse {
    private Object data;
    private String statusCode;
    private String error;

   public BaseResponse(String message,String statusCode){
        this.error=message;
        this.statusCode=statusCode;
    }
}

