package com.bandas.Bandas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API Bandas",
                description = "Esta API provee una lista de bandas de música, con sus albumes y canciones",
                version = "0.9.5",
                contact = @Contact(
                        name = "Sebastián Patitucci",
                        url = "https://sebastianpatitucci.netlify.app/",
                        email = "patitucciivo@gmail.com"
                )
        )
)
public class SwaggerConfig {
}
