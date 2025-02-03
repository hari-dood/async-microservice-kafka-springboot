package com.hariSolution.consumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDetails {
    private String employeeName;
    private String department;
    private String salary;
    private String dateOfBirth;
    private String experience;
}
