package com.example.Employee.Demo.repository;

import com.example.Employee.Demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {
}
