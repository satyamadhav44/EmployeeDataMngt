package com.example.sampleapp.repository;

import com.example.sampleapp.dto.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee,Integer> {
}
