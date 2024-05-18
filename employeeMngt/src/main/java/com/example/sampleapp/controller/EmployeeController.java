package com.example.sampleapp.controller;

import com.example.sampleapp.dto.BaseResponse;
import com.example.sampleapp.dto.Employee;
import com.example.sampleapp.service.EmployeeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.sampleapp.constants.Constants.GET_INF0;
import static com.example.sampleapp.constants.Constants.ROOT;

@RestController
@RequestMapping(ROOT)
public class EmployeeController {

    @Autowired
    private EmployeeDataService employeeDataService;

    @GetMapping(GET_INF0)
    public ResponseEntity<BaseResponse> getEmployeeDetails(@RequestHeader @Validated HttpHeaders headers , @RequestBody @Validated Employee emp){
        BaseResponse baseResponse= employeeDataService.getEmployeeData(emp);
       return ResponseEntity.ok(baseResponse);
    }
}
