package com.example.sampleapp.service;

import com.example.sampleapp.dto.BaseResponse;
import com.example.sampleapp.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeDataService {

    public BaseResponse getEmployeeData(Employee emp){

        return BaseResponse.builder().message("Success").statusCode("200").build();
    }
}
