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

import static com.example.sampleapp.constants.ErrorEnum.*;

@Service
@Slf4j
public class EmployeeDataService {

    @Autowired
    private EmployeeRepo employeeRepo;

    private String errCd="500";
    public BaseResponse postEmployeeData(Employee emp){
        try {
            employeeRepo.insert(emp);
        }catch (MongoWriteException ex){
            throw new CustomExceptionHandler(ex.getError().getMessage(),String.valueOf(ex.getError().getCode()));
        }catch (Exception ex){
            throw new CustomExceptionHandler(ex.getMessage(),errCd);
        }
        return BaseResponse.builder().data(EMP_DATA_INSERTED.getMessage()).statusCode(EMP_DATA_INSERTED.getCode()).build();
    }

    public List<Employee> getAllEmpDetails(){
        return employeeRepo.findAll();
    }

    public BaseResponse updateEmpDetails(int id,Employee empl){
        Employee emp = employeeRepo.findById(id).orElseThrow(()-> new CustomExceptionHandler(NO_SUCH_ELEMEMT.getMessage(), NO_SUCH_ELEMEMT.getCode()));
        emp.setDept(empl.getDept());
        emp.setName(empl.getName());
        employeeRepo.save(emp);
        return BaseResponse.builder().data(EMP_DATA_UPDATED.getMessage()).statusCode(EMP_DATA_UPDATED.getCode()).build();
    }
    public BaseResponse getDetailsById(int id){
        Employee emp = employeeRepo.findById(id).orElseThrow(()-> new CustomExceptionHandler(NO_SUCH_ELEMEMT.getMessage(), NO_SUCH_ELEMEMT.getCode()));
        return BaseResponse.builder().data(emp).statusCode(EMP_DATA_INSERTED.getCode()).build();
    }
}
