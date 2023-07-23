package com.emannuel.organizecafe.organizecafe.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Emannuel Morais",
                        email = "emanuelmorais2015@gmail.com",
                        url = " https://github.com/DevEmannuelMorais"
                ),
                description = "OpenApi documentation do meu cafe da manha usando Spring Boot",
                title = "OpenApi especificações - DevEmannuelMorais",
                version = "1.0",
                license = @License(
                        name = "README Coffee",
                        url = "https://github.com/DevEmannuelMorais/desafio-unidac-emannuel/blob/main/README.md"
                ),termsOfService = "Termos de Seviço"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(description = "Prod ENV",
                        url = "https://github.com/DevEmannuelMorais/academia-digital")
        }
)
public class OpenApiConfig {
}
