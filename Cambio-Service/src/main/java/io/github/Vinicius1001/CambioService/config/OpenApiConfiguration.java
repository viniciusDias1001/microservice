package io.github.Vinicius1001.CambioService.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info = @Info(title = "Cambio-Service",
        description = "Documentation of Cambio-Service",
        version = "V1"))
public class OpenApiConfiguration {


    @Bean
    public OpenAPI customOpenAPi(){
        return new OpenAPI().components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info().title("Cambio-Service").version("V1").description("Create por Vinicius Dias")
                        .contact(new Contact().name("Pedro Vinicius Barros Rocha Dias").email("pedrorochadias1001@gmail.com").url("https://github.com/viniciusDias1001"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
