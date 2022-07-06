package com.reactive.orgi_portal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.orgi_portal.model.OgriUser;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface OgriUserService   {
    Mono<ObjectNode> saveOgriUser(OgriUser ogriUser) ;

    Mono<Long> deleteOgriUser(Integer acn);

    Flux<OgriUser> getAllOgriUser();

    Mono<Long> getAllOgriUserCount();

    Mono<String> userIdByAcn(Integer acn);

    Flux<Object> employeeDetails();
}
