package com.example.sampleapp.constants;

import lombok.Getter;

@Getter
public enum ErrorEnum {

    NO_SUCH_ELEMEMT("No such record found in repo ","404"),
    EMP_DATA_INSERTED("New employee data saved successfully ","200"),
    EMP_DATA_UPDATED("Employee data updated successfully","201");
    private final String message;
    private final String code;

    ErrorEnum(String message,String erroCode){
        this.message = message;
        this.code = erroCode;
    }

}
