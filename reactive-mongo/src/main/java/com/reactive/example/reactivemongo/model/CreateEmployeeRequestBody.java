package com.reactive.example.reactivemongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class CreateEmployeeRequestBody {
    //@NotEmpty(message = "EmpCode should not be empty!!@")
    private String empCode;
    private String empName;
    private Long empSalary;
    private String empContractType;
    private String empCategory;
    private Boolean empHasB1;
    private String empGender;
    private Integer empMobileNumber;
    private Integer age;
    private EmployeeAddress employeeAddress;
}
