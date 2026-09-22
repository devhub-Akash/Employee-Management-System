package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return "Employee Created Successfully";
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable String empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PutMapping("/update/{empId}")
    public Employee updateEmployee(@RequestBody Employee employee,
                                   @PathVariable String empId) {
        return employeeService.updateEmployee(employee, empId);
    }

    @DeleteMapping("delete/{empId}")
    public String deleteEmployeeById(@PathVariable String empId) {
        employeeService.deleteEmployeeById(empId);
        return "Employee Deleted Successfully";
    }

}
