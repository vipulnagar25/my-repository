package com.reactive.example.reactivemongo.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.example.reactivemongo.model.CreateEmployeeRequestBody;
import com.reactive.example.reactivemongo.model.Employee;
import com.reactive.example.reactivemongo.model.EmployeeEvent;
import com.reactive.example.reactivemongo.response.EmployeeResponse;
import com.reactive.example.reactivemongo.service.EmployeeAddressService;
import com.reactive.example.reactivemongo.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController
@EnableEurekaClient
@RequestMapping("/reactive/employee")
public class EmployeeController {

    @Autowired(required = true)
    EmployeeServiceImpl employeeService;

    @Autowired(required = true)
    EmployeeAddressService employeeAddressService;


    @GetMapping("/all")
    public Flux<EmployeeResponse> getAll() {
        return employeeService.getAllEmployee();

    }

    @GetMapping("{empCode}")
    public Mono<EmployeeResponse> getByEmpCode(@PathVariable final String empCode) {

        return employeeService.getEmployeeByEmpCode(empCode);

    }

    @GetMapping("{empCode}/events")
    public Flux<EmployeeEvent> getEvents(@PathVariable final String empCode) {

        return employeeService.getEmployeeEventByEmpCode(empCode);

    }

    @PostMapping
    public Mono<ObjectNode> saveEmployee(@RequestBody @Valid CreateEmployeeRequestBody employeeData) {
        Employee employee = Employee.builder().empCode(employeeData.getEmpCode())
                .empName(employeeData.getEmpName())
                .empGender(employeeData.getEmpGender())
                .empContractType(employeeData.getEmpContractType())
                .empCategory(employeeData.getEmpCategory())
                .empHasB1(employeeData.getEmpHasB1())
                .empMobileNumber(employeeData.getEmpMobileNumber())
                .empSalary(employeeData.getEmpSalary())
                .build();
        return employeeService.saveEmployee(employee)
                .flatMap(object -> employeeAddressService.saveEmployeeAddress(employeeData.getEmployeeAddress()))
                .doOnSubscribe(rrw -> System.out.println(rrw));
    }

    @GetMapping("/count/{attributeName}")
    public Flux<Object> getCountByAttribute(@PathVariable final String attributeName) {

        return employeeService.getCountByAttribute(attributeName);

    }

    @GetMapping("/getSumOrAvgOrMaxOrMin/{value}")
    public Mono<Object> getSumOrAvgOrMax(@PathVariable final String value) {

        return employeeService.getSumOrAvgOrMaxOrMin(value);

    }

    @DeleteMapping("/deleteEmployeeByEmpCode/{empCode}")
    public Mono<Long> deleteEmployeeByEmpCode(@PathVariable final String empCode) {
        return employeeService.deleteEmployeeByEmpCode(empCode);

    }

    @PutMapping("/updateEmployeeByEmpCode/{empCode}")
    public Mono<Employee> updateEmployeeByEmpCode(@PathVariable(required = false) final String empCode) {
        return employeeService.updateEmployeeByEmpCode(empCode);

    }

    @GetMapping("youngEmployee")
    public Mono<Employee> getYoungestEmployee() {
        return employeeService.getYoungestEmployee();
    }

    @GetMapping("all/{pageNumber}/{pageSize}")
    public Flux<Employee> getAllByPagination(@PathVariable(required = true) final int pageNumber, @PathVariable(required = true) final int pageSize) {
        return employeeService.getAllByPagination(pageNumber, pageSize);

    }


}
