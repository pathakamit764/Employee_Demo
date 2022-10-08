package com.example.Employee.Demo.service;

import com.example.Employee.Demo.entity.Employee;

import java.util.List;

public interface EmployeeService {


    public Employee getEmployeeById(int id) ;

    List<Employee> getAllEmployee();

    public Employee addEmployee(Employee employee) ;
    public String deleteEmployee(Integer id);
   public String updateEmployee(Employee c);
}
