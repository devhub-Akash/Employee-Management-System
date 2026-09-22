package com.example.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private String empId;

    @Column(nullable = false)
    private String empName;

    @Column(nullable = false)
    private String deptName;

    @Column(nullable = true)
    private double salary;

}
