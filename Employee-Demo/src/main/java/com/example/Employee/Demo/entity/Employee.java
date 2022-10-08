package com.example.Employee.Demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {



    @Id
    @GeneratedValue
    private int id;

    private String empname;

    private String dept;

    private String salary;

}
