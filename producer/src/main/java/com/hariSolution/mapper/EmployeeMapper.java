package com.hariSolution.mapper;

import com.hariSolution.model.Employee;
import com.hariSolution.model.EmployeeRequest;
import com.hariSolution.producer.EmployeeDetails;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEmployee(EmployeeRequest request) {
        if (request == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setEmployeeName(request.getEmployeeName());
        employee.setDepartment(request.getDepartment());
        employee.setSalary(request.getSalary());
        employee.setExperience(request.getExperience());
        employee.setDateOfBirth(request.getDateOfBirth());
        return employee;
    }

    public EmployeeDetails toEmployeeDetails(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployeeName(employee.getEmployeeName());
        employeeDetails.setDepartment(employee.getDepartment());
        employeeDetails.setSalary(employee.getSalary());
        employeeDetails.setExperience(employee.getExperience());
        employeeDetails.setDateOfBirth(employee.getDateOfBirth());

        return employeeDetails;
    }
}
