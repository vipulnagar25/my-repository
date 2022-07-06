package com.reactive.example.reactivemongo.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
@Builder
@JsonPropertyOrder({ "empCode", "empName","empGender","empCategory","empContractType","empMobileNumber","empHasB1","empSalary","age"})
public class Employee {
    private String id;
    private String empCode;
    private String empName;
    private Long empSalary;
    private String empContractType;
    private String empCategory;
    private Boolean empHasB1;
    private String empGender;
    private Integer empMobileNumber;
    private Integer age;


}
