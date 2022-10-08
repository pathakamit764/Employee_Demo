package com.example.Employee.Demo.controller;

import com.example.Employee.Demo.entity.Employee;
import com.example.Employee.Demo.repository.EmployeeRepository;
import com.example.Employee.Demo.service.EmployeeServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployee(){

        List<Employee> employees = employeeServiceImp.getAllEmployee();
        log.info("starting of get mapping");

        if(!employees.isEmpty()){
            log.debug("employees are {}" +employees);
            return new ResponseEntity<>(employees , HttpStatus.OK);
        }
        else{
            log.debug("no employees found");
            return new ResponseEntity<>(employees , HttpStatus.NO_CONTENT);
        }

    }
    @GetMapping("/Employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id)

    {
        log.info("starting  of get mapping");
        Employee employee=employeeServiceImp.getEmployeeById(id);

        if(employee.getId()!=0) {
            log.debug("employee is {}"
                    + employee);
            return new  ResponseEntity<>(employee,HttpStatus.OK);
        }

        else {
            log.debug(" no employee found ");
            return new  ResponseEntity<>(employee,HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/addEmployees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        if(employee!=null)
        {

            employee.setId(employee.getId());
            employeeServiceImp.addEmployee(employee);
            log.info("added employee");
            return new ResponseEntity<>(employee,HttpStatus.CREATED);

        }
        else
        {
            log.debug("Please fill fields");
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path="/employee/{id}")
    public ResponseEntity<String> deleteEmployee( @PathVariable int id)  {

        Employee employee=employeeServiceImp.getEmployeeById(id);
        if(employee.getId()==id)

        {

                employeeServiceImp.deleteEmployee(id);
                return ResponseEntity.ok(" deleted operation Successfully ");


        }

        log.info("id not found");
        return ResponseEntity.ok(" Id not found");

    }
    @PutMapping("/updateEmployee/{id}")
    public String updateCustomer(@PathVariable int id ,@RequestBody Employee employee) {

        String emp=employeeServiceImp.updateEmployee(employee);
        return emp;
    }





}
