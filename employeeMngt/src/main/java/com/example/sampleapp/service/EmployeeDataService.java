package com.example.sampleapp.service;

import com.example.sampleapp.dto.BaseResponse;
import com.example.sampleapp.dto.Employee;
import com.example.sampleapp.exception.CustomExceptionHandler;
import com.example.sampleapp.repository.EmployeeRepo;
import com.mongodb.MongoWriteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeDataService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public BaseResponse postEmployeeData(Employee emp){
        try {
            employeeRepo.insert(emp);
        }catch (MongoWriteException ex){
            System.out.println("exception occurred");
            throw new CustomExceptionHandler(ex.getError().getMessage(),String.valueOf(ex.getError().getCode()));
        }catch (Exception ex){
            throw new CustomExceptionHandler(ex.getMessage(),"500");
        }
        return BaseResponse.builder().message("employee is inserted : "+emp.getName()).statusCode("200").build();
    }

    public List<Employee> getEmpDetails(){
        return employeeRepo.findAll();


    }
}
