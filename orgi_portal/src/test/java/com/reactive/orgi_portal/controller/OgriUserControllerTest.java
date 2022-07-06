/*package com.reactive.orgi_portal.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reactive.orgi_portal.model.OgriUser;
import com.reactive.orgi_portal.service.OgriUserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = {"ogriUser-events"}, partitions = 3)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
        "spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})


public class OgriUserControllerTest {
    @Autowired
    WebTestClient webTestClient;
    @Autowired
    OgriUserService ogriUserService;

    @BeforeAll
    public static void startTesting() {
        System.out.println("hey i am form startTesting");
    }


    @DisplayName("saveOgriUserTest")
    @Disabled
    @Test
    public void saveOgriUser() throws Exception {
        System.out.println("started" + "vipul");

        OgriUser ogriUser = new OgriUser();
        ogriUser.setAadharCardNumber(22222);
        ogriUser.setUserId("test");

        System.out.println("hey i am form getAllEmployeeTest");
        Mono<ObjectNode> response = (Mono<ObjectNode>) webTestClient.post().uri("/api/v1/ogri-process/saveOgriUser")
                .bodyValue(ogriUser)
                .exchange().expectBody();

        Assertions.assertNotNull(response, "mongo is working fine <<===!>>");
    }


}
*/