package com.reactive.orgi_portal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.orgi_portal.model.OgriUser;
import com.reactive.orgi_portal.repository.OrgiUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OgriUserServiceImpl implements OgriUserService {
    private final OrgiUserRepository orgiUserRepository;
    private final WebClient webClient;
    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    OgriUserServiceImpl(OrgiUserRepository orgiUserRepository, WebClient webClient) {
        this.orgiUserRepository = orgiUserRepository;
        this.webClient = webClient;

    }

    @Override
    public Mono<ObjectNode> saveOgriUser(OgriUser ogriUser) {
        log.info("start calling of saveOgriUser from OgriUserServiceImpl");
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("ok", "500");
        objectNode.put("save", "Failed");
        return orgiUserRepository.save(ogriUser)
                .doOnSuccess(user -> {
                    log.info("after save saveOgriUser -->{}", user);
                    Integer key = 123;
                    String value = "";
                    try {

                        value = objectMapper.writeValueAsString(ogriUser);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    // for synchronous call use this
                    // kafkaTemplate.sendDefault(key, value).get();
                    // this is without topic value it will take from properties file
                    //  kafkaTemplate.sendDefault(key, value);
                 /*   ProducerRecord<Integer, String> producerRecord = buildProducerRecord(key, value, "ogriUser-events");
                    ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(producerRecord);
                    String finalValue = value;
                    listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
                        @Override
                        public void onFailure(Throwable ex) {
                            handleFailure(key, finalValue, ex);
                        }

                        @Override
                        public void onSuccess(SendResult<Integer, String> result) {
                            log.info("kafka send message" + result.getRecordMetadata().partition());
                            handleSuccess(key, finalValue, result);
                        }
                    }); */
                    objectNode.put("ok", "200");
                    objectNode.put("save", "Success");
                }).log()
                .then(Mono.defer(() -> Mono.just(objectNode)));
    }

    @Override
    public Mono<Long> deleteOgriUser(Integer acn) {
        log.info("start calling of saveOgriUser from OgriUserServiceImpl");
        Mono<Long> response = orgiUserRepository.deleteByAadharCardNumber(acn);
        response.flatMap(value -> {
            log.info("Is user deleted yes?No:{}", value);
            return Mono.just(value);
        }).doOnNext(obj -> {
            log.info("doOnNext->{}", obj);
        }).subscribe();
        return response;
    }

    // @CircuitBreaker(name = "service2", fallbackMethod = "getAllOgriUserFallBack")
    @SuppressWarnings("unchecked")
    @Override
    public Flux<OgriUser> getAllOgriUser() {
        log.info("start calling of getAllOgriUser from OgriUserServiceImpl -->");
      /*  return HystrixCommands
                .from(orgiUserRepository.findAll().timeout(Duration.ofMillis(1)))
                .fallback(getAllOgriUserFallBack())
                .groupName("OgriUser")
                .commandName("getAllOgriUserDb")
                .toFlux(); */
        return orgiUserRepository.findAll().delayElements(Duration.ofSeconds(1));
               // .timeout(Duration.ofMillis(1)).onErrorResume(this::getAllOgriUserFallBack);
    }

    @Override
    public Mono<Long> getAllOgriUserCount() {
        log.info("start calling of getAllOgriUserCount from OgriUserServiceImpl -->");
        Mono<Long> response = orgiUserRepository.findAll().count();
        response.flatMap(size -> {
            log.info("Size of OgriUsers :{}", size);
            return Mono.just(size);
        }).doOnNext(obj -> {
            log.info("doOnNext->{}", obj);
        }).subscribe();
        return response;
    }

    @Override
    public Mono<String> userIdByAcn(Integer acn) {
        log.info("start calling of userIdByAcn from OgriUserServiceImpl , acn ->{}", acn);
        return orgiUserRepository.userIdByAadharCardNumber(acn).
                flatMap(userId -> {
                    JsonNodeFactory dd = JsonNodeFactory.instance;
                    ObjectMapper om = new ObjectMapper();
                    JsonNode jsonNode = null;
                    try {
                        jsonNode = om.readValue(userId, JsonNode.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    log.info("userId--->{}", jsonNode.get("userId").asText());
                    return Mono.just(jsonNode.get("userId").asText());
                });
    }

    //@CircuitBreaker(name = "service1", fallbackMethod = "employeeDetailsFallBack")
    @Override
    public Flux<Object> employeeDetails() {
//REACTIVE_APP
        String url = "http://" + "localhost:8084" + "/reactive/employee/all";
//        return HystrixCommands
//                .from(webClient.get().uri(url).retrieve().bodyToFlux(Object.class)
//                        .timeout(Duration.ofDays(1)))
//                .fallback(Flux.just(employeeDetailsFallBack()))
//                .groupName("OgriUser")
//                .commandName("employeeDetailsDb")
//                .toFlux();
        return webClient.get().uri(url).retrieve().bodyToFlux(Object.class).onErrorResume(this::employeeDetailsFallBack);

    }

    public Flux<Object> employeeDetailsFallBack(Throwable th) {
        log.info("Inside employeeDetailsFallback-->" + th);
        return Flux.just(Object.class);
    }

    public Flux getAllOgriUserFallBack(Throwable th) {
        log.info("Inside getAllOgriUserFallBack-->" + th);
        return Flux.empty();
    }

    private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {


        List<Header> recordHeaders = new ArrayList<>();
        recordHeaders.add(new RecordHeader("event-source", "scanner".getBytes()));

        return new ProducerRecord<>(topic, null, key, value, recordHeaders);
    }

    private void handleFailure(Integer key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }

    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
    }
}
