package com.wbip.indicators.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wbip.indicators.ws"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .genericModelSubstitutes(Optional.class, ResponseEntity.class);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("REST API - Economic Indicators of Poverty")
                .description("REST API - Economic Indicators of Poverty from World Bank")
                .version("0.0.1-SNAPSHOT")
                .build();
    }

}
