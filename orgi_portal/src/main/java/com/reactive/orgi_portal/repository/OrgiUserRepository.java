package com.reactive.orgi_portal.repository;

import com.reactive.orgi_portal.model.OgriUser;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface OrgiUserRepository extends ReactiveMongoRepository<OgriUser, String> {
    Mono<Long> deleteByAadharCardNumber(Integer acn);

    @Query(value = "{ 'aadharCardNumber' : ?0}", fields = "{ 'userId' : 1}")
    Mono<String> userIdByAadharCardNumber(Integer acn);

}
