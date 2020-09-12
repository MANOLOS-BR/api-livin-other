package com.manoloscorp.livinother.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.manoloscorp.livinother.shared.ConfigConstants.*;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
            .paths(regex(DEFAULT_INCLUDE_PATTERN))
            .build()
            .forCodeGeneration(true)
            .apiInfo(metaData())
            .securitySchemes(Arrays.asList(apiKey()))
            .securityContexts(Arrays.asList(securityContext()));
  }

  private ApiInfo metaData() {
    return new ApiInfo(
            "Livin Other API",
            "Description of API.",
            "API 1.0.0",
            "Terms of service",
            new Contact("Manolos Corp", "www.manoloscorp.com", "contact@manoloscorp.com"),
            "License of API",
            "API license URL",
            Collections.emptyList());
  }

  private ApiKey apiKey() {
    return new ApiKey(AUTHORIZATION_HEADER, AUTHORIZATION_HEADER, HEADER);
  }

  private SecurityContext securityContext() {
    return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.any())
            .build();
  }

  private List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope(AUTHORIZATION_SCOPE, AUTHORIZATION_EVERYTHING);
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Arrays.asList(new SecurityReference(AUTHORIZATION_HEADER, authorizationScopes));
  }

}
