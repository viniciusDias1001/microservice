package io.github.viniciusDias1001.BookService.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "Book Service API",version = "v1",description = "Create Vinicius Dias")
)
public class OpenApiConfiguration {


    @Bean
    public OpenAPI customOpenAPi(){
        return new OpenAPI().components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info().title("Book Service").version("V1").description("Create por Vinicius Dias")
                .contact(new Contact().name("Pedro Vinicius Barros Rocha Dias").email("pedrorochadias1001@gmail.com").url("https://github.com/viniciusDias1001"))
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}
