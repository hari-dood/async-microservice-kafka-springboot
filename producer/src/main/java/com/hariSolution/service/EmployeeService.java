package com.hariSolution.service;


import com.hariSolution.mapper.EmployeeMapper;
import com.hariSolution.model.Employee;
import com.hariSolution.model.EmployeeRequest;

import com.hariSolution.producer.EmployeeDetails;

import com.hariSolution.producer.MessageProducer;
import com.hariSolution.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper employeeMapper;
    private final MessageProducer messageProducer;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper employeeMapper, MessageProducer messageProducer) {
        this.repository = repository;
        this.employeeMapper = employeeMapper;
        this.messageProducer = messageProducer;
    }

    public Employee  createEmployeeRecord(EmployeeRequest request){

        Employee employee=this.employeeMapper.toEmployee(request);

        this.repository.save(employee);

        System.out.println(employee);

        EmployeeDetails details=this.employeeMapper.toEmployeeDetails(employee);

        this.messageProducer.sendMessage(details);

        System.out.println(details);

        return employee;

    }

}
