package com.reactive.orgi_portal;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;


@SpringBootApplication
@EnableSwagger2


//@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.reactive"})
@EnableKafka
@Configuration
public class OrgiPortalApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(OrgiPortalApplication.class, args);
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(Mono.class, Flux.class, Publisher.class)
                .select()

                .apis(basePackage("com.reactive"))
                .paths(regex("/" + ".*")).build()
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .apiInfo(new ApiInfoBuilder()
                        .title("Reactive  REST API")
                        .description("This API allows to buy and sell product for farmer")
                        .version("2.0")

                        .build());
    }

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json",
                    "application/xml", "application/stream+json"));

    @Bean
    @LoadBalanced
    public WebClient webClient() {
        return WebClient.create();
    }

//    @Bean
//    @ConditionalOnProperty(name = "actionbean.enabled", havingValue = "true")
//    @Conditional(value = ConditionAction.class)
//    ConditionClass getBean() {
//        return new ConditionClass();
//    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner run method-->");
        Stream.of(applicationContext.getEnvironment().getActiveProfiles()).forEach(e -> {
            System.out.println(e.toString());

        });
    }
}
