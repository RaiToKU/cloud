package com.jay.cloud.loadbalancer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author raito
 * @date 2022/09/05
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    @Primary
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
