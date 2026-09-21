package com.example.CrudApp.service;

import com.example.CrudApp.entity.Employee;
import com.example.CrudApp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    };

    public Employee getEmployeeById(String empId) {
        return employeeRepository.findById(empId).get();
    }

    public Employee createEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getEmpId())) {
            throw new RuntimeException("Employee with id " + employee.getEmpId() + " already exists.");
        }
       return employeeRepository.save(employee);
   }

   public Employee updateEmployee(Employee employee, String  empId) {
        Employee exist = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        exist.setEmpName(employee.getEmpName());
        exist.setDeptName(employee.getDeptName());
        exist.setSalary(employee.getSalary());

        return employeeRepository.save(exist);
   }

   public void deleteEmployeeById(String empId) {
        if(!employeeRepository.existsById(empId)) {
            throw new RuntimeException("employee not found");
        }
        employeeRepository.deleteById(empId);
   }

}
