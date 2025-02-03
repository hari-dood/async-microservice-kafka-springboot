package com.hariSolution.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "employee_details")
@Component
public class Employee {

    @Id
    private String id;
    private String employeeName;
    private String department;
    private String salary;
    private String dateOfBirth;
    private String experience;
}
