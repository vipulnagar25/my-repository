package com.reactive.orgi_portal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@ToString
@JsonInclude(NON_NULL)
public class OgriUser implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;
    @NotEmpty(message = "User id should not be empty")
    String userId;
    @Min(value = 3, message = "Please enter valid user name")
    String userName;
    @Min(value = 3, message = "Please enter valid  last name")
    String lastName;
    @Min(value = 5, message = "Please enter valid country name")
    String country;
    @Min(value = 2, message = "Please enter valid state name")
    String state;
    @Min(value = 3, message = "please enter valid district name")
    String district;
    @Min(value = 5, message = "PinCode should not be less than 5")
    @Max(value = 5, message = "PinCode should not be greater than 5")
    Integer pinCode;
    @Min(value = 10, message = "Aadhar Number should not be less than 10")
    @Max(value = 10, message = "Aadhar Number should not be greater than 10")
    Integer aadharCardNumber;
}
