package com.reactive.orgi_portal.service.datafetcher;

import com.reactive.orgi_portal.model.OgriUser;
import com.reactive.orgi_portal.repository.OrgiUserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.util.List;

@Component
public class AllOgriUsersDataFetcher implements DataFetcher<List<OgriUser>> {
    @Autowired
    OrgiUserRepository orgiUserRepository;

    @Override
    public List<OgriUser> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Flux<OgriUser> allUser = orgiUserRepository.findAll();

        System.out.println("allUserList" + allUser.collectList().block());
        return allUser.collectList().block();
    }
}
