package com.reactive.example.reactivemongo;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
/*import org.springframework.web.reactive.config.EnableWebFlux;*/

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableConfigurationProperties
@Configuration
@ComponentScan(basePackages = {"com.reactive"})
//@EnableWebFlux
@EnableSwagger2
//EnableSwagger2WebFlux

public class ReactiveMongoApplication implements ApplicationRunner {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                select()

                .apis(basePackage("com.reactive.example"))
                .paths(regex("/" + ".*")).build()
                .apiInfo(new ApiInfoBuilder()
                        .title("Reactive  REST API")
                        .description("This API allows to perform all operations related reactive java")
                        .version("2.0")
                        .build());
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("Hello World from Application Runner");
    }
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ReactiveMongoApplication.class);
        //  app.setWebApplicationType(WebApplicationType.SERVLET);
        System.out.println("ReactiveMongoApplication---->");
        app.run(args);
    }
    @Bean
    @LoadBalanced
    public WebClient webClient() {
        return WebClient.create();
    }

}
