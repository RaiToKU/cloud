package com.jay.cloud.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author raito
 * @date 2022/09/07
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @SentinelRestTemplate
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
