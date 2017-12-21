package com.feign.client.com.feign.client.config;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoServiceClientConfig {


    public static final int CONNECT_TIMEOUT_MILLIS = 12000;
    public static final int READ_TIMEOUT_MILLIS = 12000;

    @Bean
    public Request.Options options() {
        return new Request.Options(CONNECT_TIMEOUT_MILLIS, READ_TIMEOUT_MILLIS);
    }
}


