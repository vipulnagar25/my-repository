package com.reactive.orgi_portal.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.orgi_portal.OgriApiPath;
import com.reactive.orgi_portal.model.OgriUser;
import com.reactive.orgi_portal.service.GraphqlOgriUserService;
import com.reactive.orgi_portal.service.OgriUserService;
import graphql.ExecutionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j

@RestController
@RequestMapping(OgriApiPath.OGRI_PROCESS_PATH)

public class OgriUserController {
    @Autowired
    OgriUserService ogriUserService;
    @Autowired
    GraphqlOgriUserService graphQLService;

  //@Autowired
    com.reactive.orgi_portal.profileAndCondition.ConditionClass conditionClass;

    @PostMapping(value = OgriApiPath.SAVE_OGRI_USER, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<ObjectNode> saveOgriUser(@RequestBody OgriUser ogriUser) {


        log.info("OgriUserController start calling of saveOgriUser obj-->{}", ogriUser);
        return ogriUserService.saveOgriUser(ogriUser);
    }

    @DeleteMapping(value = OgriApiPath.DELETE_USER + "/{acn}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Long> deleteOgriUser(@PathVariable final Integer acn) {
        log.info("OgriUserController start calling of deleteOgriUser acn-->{}", acn);
        return ogriUserService.deleteOgriUser(acn);
    }

    @GetMapping(value = OgriApiPath.ALL_USERS, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
   // @CircuitBreaker(name = "ogriservice" ,fallbackMethod = "getDummyUser")
    public Flux<OgriUser> getAllOgriUser() {
        log.info("OgriUserController start calling of getAllOgriUser-->");

        return ogriUserService.getAllOgriUser();
    }

    public Flux<OgriUser> getDummyUser() {
        log.info("OgriUserController start calling of getAllOgriUser-->");

        return ogriUserService.getAllOgriUser();
    }

    @GetMapping(value = OgriApiPath.TOTAL_COUNT, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Long> getAllOgriUserCount() {
        log.info("OgriUserController start calling of getAllOgriUserCount -->");
        return ogriUserService.getAllOgriUserCount();
    }

    @GetMapping(value = OgriApiPath.USER_ID_BY_ACN + "/{acn}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<String> getUserIdByAcn(@PathVariable final Integer acn) {
        log.info("OgriUserController start calling of  userIdByAcn-->{}", acn);
        return ogriUserService.userIdByAcn(acn);
    }


    @GetMapping(value = OgriApiPath.GET_FORM_ANOTHER_SERVICE, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Object> getEmployeeDetails() {
        log.info("OgriUserController start calling of  employeeDetails->");
        return ogriUserService.employeeDetails();
    }

    @PostMapping(value = OgriApiPath.GRAPHQL_ALL_USERS, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Object graphqlGetAllOgriUser(@RequestBody String query) {
        log.info("OgriUserController start calling of graphqlGetAllOgriUser-->");
        ExecutionResult result = graphQLService.getGraphQL().execute(query);
        result.getData();
        return result;
    }

    @PostMapping(value = OgriApiPath.GRAPHQL_SAVE_OGRI_USER, produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Object graphqlSaveOgriUser(@RequestBody OgriUser ogriUser) {
        log.info("OgriUserController start calling of saveOgriUser obj-->{}", ogriUser);
        return null;
    }

    @GetMapping(value = OgriApiPath.TESTING)
    public Object testing() {
        if (conditionClass == null) {
            System.out.println("it is null");
        } else {
            System.out.println("it is not null");
            System.out.println(conditionClass.testConditionClass());
        }

        return new Object();
    }
    @PutMapping(value ="testingTh"+ "/{acn}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Long> deleteOgriUser1(@PathVariable final Integer acn) {
        log.info("OgriUserController start calling of deleteOgriUser acn-->{}", acn);
        return ogriUserService.deleteOgriUser(acn);
    }
}