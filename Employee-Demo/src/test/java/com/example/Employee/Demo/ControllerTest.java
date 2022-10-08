package com.example.Employee.Demo;

import com.example.Employee.Demo.controller.EmployeeController;
import com.example.Employee.Demo.entity.Employee;
import com.example.Employee.Demo.service.EmployeeServiceImp;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(classes= {ControllerTest.class})
public class ControllerTest {

    @Mock
    private EmployeeServiceImp employeeServiceImp;

    @Mock
    EmployeeController employeeController;

    List<Employee> myemployee;
    Employee employee;

    void test_getAllEmployee (){
         myemployee = new ArrayList<Employee>();
        myemployee.add(new Employee(1,"Amit","Developer","678982689"));

        when(employeeServiceImp.getAllEmployees()).thenReturn(myemployee);
        ResponseEntity<List<Employee>> res=employeeController.getAllEmployee();
    }
}
