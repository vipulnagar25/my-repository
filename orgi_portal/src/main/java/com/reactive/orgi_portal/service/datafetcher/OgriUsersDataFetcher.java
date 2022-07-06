package com.reactive.orgi_portal.service.datafetcher;

import com.reactive.orgi_portal.model.OgriUser;
import com.reactive.orgi_portal.repository.OrgiUserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class OgriUsersDataFetcher implements DataFetcher<OgriUser> {
    @Autowired
    OrgiUserRepository orgiUserRepository;

    @Override
    public OgriUser get(DataFetchingEnvironment dataFetchingEnvironment) {
        String id = dataFetchingEnvironment.getArgument("id");
        Mono<OgriUser> response = orgiUserRepository.findById(id);

        System.out.println("ogriUser" + response.block());
        return response.block();
    }
}
