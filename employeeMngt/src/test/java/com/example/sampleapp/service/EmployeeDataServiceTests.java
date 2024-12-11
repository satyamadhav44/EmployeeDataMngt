package com.example.sampleapp.service;

import com.example.sampleapp.dto.BaseResponse;
import com.example.sampleapp.dto.Employee;
import com.example.sampleapp.repository.EmployeeRepo;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeDataServiceTests {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeDataService employeeDataService;

    @Test
    public void EmployeeServie_AddEmployee_ReturnsEmployee(){
        //arrange
        Employee employee =  Employee.builder().id(1L).name("Satya").dept("IT").build();
        //Act
        when(employeeRepo.insert(mock(Employee.class))).thenReturn(employee);
        BaseResponse response = employeeDataService.postEmployeeData(employee);
        Assert.assertEquals("200",response.getStatusCode());


    }

}
