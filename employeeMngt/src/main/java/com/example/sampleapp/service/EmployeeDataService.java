package com.example.sampleapp.service;

import com.example.sampleapp.dto.BaseResponse;
import com.example.sampleapp.dto.Employee;
import com.example.sampleapp.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeDataService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public BaseResponse postEmployeeData(Employee emp){
        employeeRepo.insert(emp);
        return BaseResponse.builder().message("employee is inserted : "+emp.getName()).statusCode("200").build();
    }

    public List<Employee> getEmpDetails(){
        return employeeRepo.findAll();
    }
}
