package com.example.sampleapp.controller;

import com.example.sampleapp.dto.BaseResponse;
import com.example.sampleapp.dto.Employee;
import com.example.sampleapp.service.EmployeeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.sampleapp.constants.Constants.*;

@RestController
@RequestMapping(ROOT)
public class EmployeeController {

    @Autowired
    private EmployeeDataService employeeDataService;

    @PostMapping(POST_INF0)
    public ResponseEntity<BaseResponse> postEmployeeDetails(@RequestHeader @Validated HttpHeaders headers , @RequestBody @Validated Employee emp){
        BaseResponse baseResponse= employeeDataService.postEmployeeData(emp);
       return ResponseEntity.ok(baseResponse);
    }

    @GetMapping(GET_INF0)
    public ResponseEntity<List<Employee>> getEmpDetails(@RequestHeader @Validated HttpHeaders headers){
                return ResponseEntity.ok(employeeDataService.getEmpDetails());
    }
}
