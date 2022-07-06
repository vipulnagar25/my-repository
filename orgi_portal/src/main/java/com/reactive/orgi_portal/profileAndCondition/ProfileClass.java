package com.reactive.orgi_portal.profileAndCondition;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


//@Profile("prod")
@Component
public class ProfileClass {
    ProfileClass() {
        System.out.println("i am form  ProfileClass constructor");
    }

    public String testProfileClass() {
        return "hello";
    }
}
