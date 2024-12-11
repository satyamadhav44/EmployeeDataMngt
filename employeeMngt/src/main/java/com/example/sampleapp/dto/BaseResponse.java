package com.example.sampleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class BaseResponse {
    private String message;
    private String statusCode;
    private String error;

   public BaseResponse(String message,String statusCode){
        this.error=message;
        this.statusCode=statusCode;
    }
}

