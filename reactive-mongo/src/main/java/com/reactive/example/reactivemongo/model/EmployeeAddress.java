package com.reactive.example.reactivemongo.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
@Builder
public class EmployeeAddress {
    private String empCode;
    private Integer empPinCode;
    private String empStreet;
    private String empCity;
    private String empState;
    private String empCountry;

}
