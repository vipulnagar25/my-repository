package com.reactive.example.reactivemongo.service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.example.reactivemongo.model.EmployeeAddress;
import com.reactive.example.reactivemongo.repository.EmployeeAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EmployeeAddressServiceImpl  implements  EmployeeAddressService{
  private  final EmployeeAddressRepository employeeAddressRepository;
  private final  MongoTemplate mongoTemplate;

    @Autowired
    EmployeeAddressServiceImpl(EmployeeAddressRepository employeeAddressRepository, MongoTemplate mongoTemplate) {
        this.employeeAddressRepository = employeeAddressRepository;
        this.mongoTemplate = mongoTemplate;

    }

    @Override
    public Mono<ObjectNode> saveEmployeeAddress(EmployeeAddress employeeAddress) {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("ok", "500");
        objectNode.put("save", "Failed");
        return employeeAddressRepository.save(employeeAddress)
             .doOnSuccess(address -> {
                    objectNode.put("ok", "200");
                    objectNode.put("save", "Success");
                }).log()
                .then(Mono.defer(() -> Mono.just(objectNode)));
    }
}
