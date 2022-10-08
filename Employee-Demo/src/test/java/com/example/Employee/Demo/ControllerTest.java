package com.example.Employee.Demo;

import com.example.Employee.Demo.controller.EmployeeController;
import com.example.Employee.Demo.entity.Employee;
import com.example.Employee.Demo.service.EmployeeServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes= {ControllerTest.class})
public class ControllerTest {

    @Mock
    private EmployeeServiceImp employeeServiceImp;

    @Mock
    EmployeeController employeeController;

    List<Employee> myemployee;
    Employee employee;

    @Test
    void test_getAllEmployee (){
         myemployee = new ArrayList<Employee>();
        myemployee.add(new Employee(1,"Amit","Developer","678982689"));

        when(employeeServiceImp.getAllEmployee()).thenReturn(myemployee);
        ResponseEntity<List<Employee>> res=employeeController.getAllEmployee();
        assertEquals(1,res.getBody().size());
    }
    @Test
    void test_getCustomerByID()
    {
        employee=new Employee(1,"Amit","Developer","678982689");
        int id=1;
        when(employeeServiceImp.getEmployeeById(id)).thenReturn(employee);
        ResponseEntity<Employee> res=employeeController.getEmployeeById(id);

        assertEquals(id,res.getBody().getId());
    }

    @Test

    void test_addCustomer()  {
        employee=new Employee(2,"Alok","Tester","6789826");
//        customer.setCustid(service.getSequenceNumberForCustomer(Customer.SEQUENCE_NAME));
        employee.setId(employee.getId());
        when(employeeServiceImp.addEmployee(employee));
        Employee res=employeeServiceImp.addEmployee(employee);


        assertEquals(employee,res.equals(employee));
    }
}
