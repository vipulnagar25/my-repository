package com.reactive.example.reactivemongo.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.example.reactivemongo.model.Employee;
import com.reactive.example.reactivemongo.model.EmployeeEvent;
import com.reactive.example.reactivemongo.response.EmployeeResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface EmployeeService {

    Flux<EmployeeResponse> getAllEmployee();

    Mono<EmployeeResponse> getEmployeeByEmpCode(String empCode);

    Flux<EmployeeEvent> getEmployeeEventByEmpCode(String empCode);

    Mono<ObjectNode> saveEmployee(Employee employee);

    Mono<Long> deleteEmployeeByEmpCode(String empCode);

    Flux<Object> getCountByAttribute(String attributeName);

    Mono<Object> getSumOrAvgOrMaxOrMin(String value);

    Mono<Employee> updateEmployeeByEmpCode(String empCode);

    Mono<Employee> getYoungestEmployee();

    Flux<Employee> getAllByPagination(int pageNumber,int pageSize);
}
