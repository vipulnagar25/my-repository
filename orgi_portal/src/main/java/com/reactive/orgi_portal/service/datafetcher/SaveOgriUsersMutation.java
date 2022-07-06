package com.reactive.orgi_portal.service.datafetcher;

//import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.reactive.orgi_portal.model.OgriUser;
import com.reactive.orgi_portal.repository.OrgiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaveOgriUsersMutation
        // implements GraphQLMutationResolver
{
    @Autowired
    OrgiUserRepository orgiUserRepository;

    public OgriUser createUser(OgriUser ogriUser) {

        return orgiUserRepository.save(ogriUser).block();
    }

}
