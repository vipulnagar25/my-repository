package com.reactive.example.reactivemongo.service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.example.reactivemongo.model.Employee;
import com.reactive.example.reactivemongo.model.EmployeeEvent;
import com.reactive.example.reactivemongo.repository.EmployeeRepository;
import com.reactive.example.reactivemongo.response.EmployeeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository, MongoTemplate mongoTemplate) {
        this.employeeRepository = employeeRepository;
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Flux<EmployeeResponse> getAllEmployee() {
        log.info( "start calling of  getAllEmployee()-->");
        return this.getAllEmployeeByAggregation();
    }

    @Override
    public Mono<EmployeeResponse> getEmployeeByEmpCode(String empCode) {
        return this.getEmployeeByEmpCodeByAggregation(empCode);

    }

    @Override
    public Flux<EmployeeEvent> getEmployeeEventByEmpCode(String id) {
        return employeeRepository.findByEmpCode(id).flatMapMany(employee -> {
            Flux<Long> interval = Flux.interval(Duration.ofSeconds(0));
            Flux<EmployeeEvent> employeeEventFlux =
                    Flux.fromStream(Stream.generate(() -> new EmployeeEvent(employee, new Date())));
            return Flux.zip(interval, employeeEventFlux).map(Tuple2::getT2);
        });
    }

    @Override
    public Mono<ObjectNode> saveEmployee(Employee employee) {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("ok", "500");
        objectNode.put("save", "Failed");
        return employeeRepository.save(employee).doOnSuccess(empObject -> {
            objectNode.put("ok", "200");
            objectNode.put("save", "Success");
        }).doOnError(err -> {
            System.err.println("error occur");
        }).doOnSuccess(successResult -> {
        }).then(Mono.defer(() -> Mono.just(objectNode)));


    }


    @Override
    public Mono<Long> deleteEmployeeByEmpCode(String empCode) {
        return employeeRepository.deleteByEmpCode(empCode).flatMap(deleteObj -> Mono.just(deleteObj));

    }


    public Flux<EmployeeResponse> getAllEmployeeByAggregation() {
        log.info("start calling getAllEmployeeByAggregation-->");
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("employeeAddress")
                .localField("empCode")
                .foreignField("empCode")
                .as("employeeAddress");
        //  kind of intersection
        //  UnwindOperation unwindOperation = Aggregation.unwind("$employeeAddress");
        /*AggregationOptions aggregationOptions=   AggregationOptions.builder().allowDiskUse(true).cursorBatchSize(1000)
                .allowDiskUse(true).cursorBatchSize(1).build();
        aggregationOptions.getCursor();*/
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        log.info("final aggregation {}", aggregation.toString());
        List<EmployeeResponse> results = mongoTemplate.aggregate(aggregation, "employee", EmployeeResponse.class).getMappedResults();

        log.info("results{} , resultsize{}", results.get(0), results.size());
        return Flux.fromIterable(results);
    }

    public Mono<EmployeeResponse> getEmployeeByEmpCodeByAggregation(String empCode) {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("employeeAddress")
                .localField("empCode")
                .foreignField("empCode")
                .as("employeeAddress");
        UnwindOperation unwindOperation = Aggregation.unwind("$employeeAddress");
        MatchOperation matchOperation = Aggregation.match(Criteria.where("empCode").is(empCode));
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation, matchOperation, unwindOperation);
        List<EmployeeResponse> results = mongoTemplate.aggregate(aggregation, "employee", EmployeeResponse.class).getMappedResults();
        return Mono.justOrEmpty(results.stream().findAny());
    }

    @Override
    public Flux<Object> getCountByAttribute(String attributeName) {
        //  MatchOperation matchOperation = Aggregation.match(Criteria.where("empCode").is("emp-020"));
        GroupOperation groupOperation = Aggregation
                .group(attributeName).count().as("total");
        SortOperation sortOperation = sort(Sort.Direction.DESC, attributeName);
        Aggregation aggregation = Aggregation.newAggregation(groupOperation, sortOperation);
        List<Object> results = mongoTemplate.aggregate(aggregation, "employee", Object.class).getMappedResults();
        System.out.println("size of count Attribute-->" + results.size());
        return Flux.fromIterable(results);

    }

    public Mono<Object> getSumOrAvgOrMaxOrMin(String value) {
        GroupOperation groupOperation = Aggregation.group("empName");
        if ("MAX".equalsIgnoreCase(value)) {
            groupOperation = Aggregation.group().max("empSalary").as("max");
        } else if ("MIN".equalsIgnoreCase(value)) {
            groupOperation = Aggregation.group().min("empSalary").as("min");
        } else if ("AVG".equalsIgnoreCase(value)) {
            groupOperation = Aggregation.group().avg("empSalary").as("avg");
        } else if ("SUM".equalsIgnoreCase(value)) {
            groupOperation = Aggregation.group().sum("empSalary").as("sum");
        }
        Aggregation aggregation = Aggregation.newAggregation(groupOperation);
        List<Object> results = mongoTemplate.aggregate(aggregation, "employee", Object.class).getMappedResults();
        System.out.println("size of getSumOrAvgOrMaxOrMin-->" + value + "===>>" + results.size());
        return Mono.justOrEmpty(results.stream().findAny());
    }

    @Override
    public Mono<Employee> updateEmployeeByEmpCode( String empCode) {
        return employeeRepository.findByEmpCode(empCode)
                .map(this::updateObject)
                .flatMap(employeeRepository::save);
    }


    private Employee updateObject(Employee oldObject) {
        oldObject.setEmpCategory("SuperHigh");
        return oldObject;
    }

    @Override
    public Mono<Employee> getYoungestEmployee() {
        MatchOperation matchOperation = Aggregation.match(Criteria.where("age").exists(true));
        SortOperation sortOperation = Aggregation.sort(Sort.Direction.ASC, "age");
        LimitOperation limitOperation = Aggregation.limit(1);
        Aggregation aggregation = Aggregation.newAggregation(matchOperation, sortOperation, limitOperation);
        List<Employee> results = mongoTemplate.aggregate(aggregation, "employee", Employee.class).getMappedResults();
        System.out.println(results + "result");
        Mono<Employee> byJava = employeeRepository.findAll().filter(ee -> ee.getAge() != null).reduce((em1, em2) -> em1.getAge() < em2.getAge() ? em1 : em2);
        System.out.println("byJava" + byJava);
        byJava.subscribe(ee -> {
            System.out.println(ee + "got it");
        });
        return Mono.justOrEmpty(results.stream().findAny());
    }

    @Override
    public Flux<Employee> getAllByPagination(int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by("empCode"));
        Query query = new Query();
        query.with(paging);
        List<Employee> allUser = mongoTemplate.find(query, Employee.class);
        return Flux.fromIterable(allUser);
    }
}

