package com.webflux.example.webfluxjpa;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PersonRouter {

    @Bean
    public RouterFunction<ServerResponse> personRoute(PersonHandler personHandler) {
        return route(GET("/person"), personHandler::listPeople)
                .andRoute(POST("/person").and(accept(MediaType.APPLICATION_JSON)), personHandler::createPerson);
    }

}
