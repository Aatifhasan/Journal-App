package com.project.journalApp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info().title("Journal App API")
                        .description("API documentation for the Journal App")
                )
                .servers(List.of(new Server().url("http://localhost:8080/journal").description("Local server"),
                        new Server().url("http://localhost:8081").description("Production server")))
                .tags(Arrays.asList(
                        new Tag().name("Public API's").description("Endpoints accessible to all users")
                )).addSecurityItem(new SecurityRequirement().addList("bearerToken"))
                .components(new Components().addSecuritySchemes(
                        "bearerToken",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")
                ));


    }
}
