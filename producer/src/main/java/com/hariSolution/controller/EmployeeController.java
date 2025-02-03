package com.hariSolution.controller;

import com.hariSolution.model.Employee;
import com.hariSolution.model.EmployeeRequest;
import com.hariSolution.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployeeRecord(@RequestBody  EmployeeRequest request){
        Employee employee=  this.employeeService.createEmployeeRecord(request);

        return ResponseEntity.ok(employee);

    }

}
