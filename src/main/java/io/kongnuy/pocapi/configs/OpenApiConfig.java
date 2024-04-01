package io.kongnuy.pocapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openAPI() {
    Contact contact = new Contact();
    contact.setEmail("contact@kongnuy.io");
    contact.setName("Kongnuy IO Administrators");
    contact.setUrl("https://kongnuy.io");

    Info info = new Info()
        .title("Optivac POC API")
        .version("0.0.1")
        .contact(contact)
        .termsOfService("https://kongnuy.io")
        .description("This POC Api is to demonstrate that the needs express by Optivac client is possible to do");

    ExternalDocumentation externalDocumentation = new ExternalDocumentation()
        .description("SpringShop Wiki Documentation")
        .url("https://springshop.wiki.github.org/docs");

    return new OpenAPI().info(info).externalDocs(externalDocumentation);
  }
}
