package com.hariSolution.mapper;
import com.hariSolution.employee.Employee;
import com.hariSolution.consumer.EmployeeDetails;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public Employee toEmployee(EmployeeDetails employeeDetails){
        if (employeeDetails == null){
            return null;
        }

        Employee employee=new Employee();
        employee.setEmployeeName(employeeDetails.getEmployeeName());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        employee.setExperience(employeeDetails.getExperience());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());

        return employee;


    }
}
