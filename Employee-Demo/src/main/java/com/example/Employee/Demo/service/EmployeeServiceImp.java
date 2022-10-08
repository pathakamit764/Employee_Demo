package com.example.Employee.Demo.service;

import com.example.Employee.Demo.entity.Employee;
import com.example.Employee.Demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImp implements EmployeeService  {

    @Autowired
    private EmployeeRepository employeeRepository;




    @Override
    public Employee addEmployee(Employee employee){
        if(employee!=null)
        {
            employeeRepository.save(employee);
            log.debug("employee added {}",employee);
        }

        return  employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        log.info("get all employee");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee=employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }


    @Override
    public String deleteEmployee(Integer id) {
        log.info("Start delete");
       var isRemoved= employeeRepository.findById(id);
        if(isRemoved.isPresent()){
            employeeRepository.deleteById(id);
            log.debug("deleted successfully {}",isRemoved.get());
        }
        return "deleted successfully";
    }

    public String updateEmployee(Employee employee){

        Optional<Employee> employee1=employeeRepository.findById(employee.getId());
            Employee emp= null;
            if(!employee1.isPresent()){
                log.debug("employee not found");
            }else{
                emp=employee1.get();
                emp.setId(employee.getId());
               emp.setEmpname(employee.getEmpname());
               emp.setDept(employee.getDept());
               emp.setSalary(employee.getSalary());

                employeeRepository.save(emp);
                log.debug("updated successfully {}",emp);

            }
        return emp + "\n updated successfully";
    }
}
