package com.reactive.example.reactivemongo.repository;

import com.reactive.example.reactivemongo.model.EmployeeAddress;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAddressRepository  extends ReactiveMongoRepository<EmployeeAddress,String> {
}
