package com.reactive.orgi_portal.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OgriUserResponse {

    String userId;
    String userName;
    String lastName;
    String country;
    String state;
    String district;
    Integer pinCode;
    Integer aadharCardNumber;


}
