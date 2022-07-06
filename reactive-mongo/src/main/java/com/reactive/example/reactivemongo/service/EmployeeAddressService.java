package com.reactive.example.reactivemongo.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.example.reactivemongo.model.EmployeeAddress;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface EmployeeAddressService {

    Mono<ObjectNode> saveEmployeeAddress(EmployeeAddress employeeAddress);
}
