package com.reactive.example.reactivemongo.repository;

import com.reactive.example.reactivemongo.model.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee,String> {
    Mono<Employee> findByEmpCode(String empCode);
    Mono<Long> deleteByEmpCode(String empCode);
}
