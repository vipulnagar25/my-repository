package com.resilience;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/resilience-Service")
public class ResilienceServiceApplication {
    public static int intValue=0;
    @GetMapping("/getStatus")
    @CircuitBreaker(name = "resilience-Service", fallbackMethod = "getFaultValue")
    //@Retry(name = USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
    public String getValue(String id) {
        System.out.println(++intValue+"id"+null);
        System.out.println(id.toString());
        return "checkValue";
    }

    public String getFaultValue(Exception e) {
        System.out.println("from call back");
        return "testValue";
    }
    @GetMapping("/getRetryStatus")

    @Retry(name = "resilience-Service",fallbackMethod = "getRetryFaultValue")
    public String getRetryValue(String id) {
        System.out.println(++intValue+"id"+null);
        System.out.println(id.toString());
        return "checkRetryValue";
    }

    public String getRetryFaultValue(Exception e) {
        System.out.println("getRetryFaultValue");
        return "getRetryFaultValue";
    }

    public static void main(String[] args) {
        SpringApplication.run(ResilienceServiceApplication.class, args);
    }

}
