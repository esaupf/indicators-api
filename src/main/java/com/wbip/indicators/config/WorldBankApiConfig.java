package com.wbip.indicators.config;

import com.wbip.indicators.component.client.WorldBankApiClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorldBankApiConfig {

    @Bean
    public WorldBankApiClient worldBankApiClient(@Value(value = "${external.api.worldbank}") String baseUrl) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(WorldBankApiClient.class, baseUrl);
    }



}
