package com.example.sampleapp.controller;

import com.example.sampleapp.dto.BaseResponse;
import com.example.sampleapp.dto.Employee;
import com.example.sampleapp.service.EmployeeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<List<Employee>> getAllEmpDetails(@RequestHeader @Validated HttpHeaders headers){
                return ResponseEntity.ok(employeeDataService.getAllEmpDetails());
    }

    @PutMapping(UPDATE_INF0)
    public ResponseEntity<BaseResponse> updateEmpDetails(@RequestHeader @Validated HttpHeaders headers
            ,@PathVariable int id
            ,@RequestBody @Validated Employee emp){
        return ResponseEntity.ok(employeeDataService.updateEmpDetails(id,emp));
    }

    @GetMapping(GET_INF0_BY_ID)
    public ResponseEntity<BaseResponse> getEmpDetailsById(@RequestHeader @Validated HttpHeaders headers,@PathVariable int id){
        return ResponseEntity.ok(employeeDataService.getDetailsById(id));
    }
}
