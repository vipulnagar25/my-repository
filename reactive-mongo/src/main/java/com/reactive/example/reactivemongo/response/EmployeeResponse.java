package com.reactive.example.reactivemongo.response;

import com.reactive.example.reactivemongo.model.EmployeeAddress;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
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
