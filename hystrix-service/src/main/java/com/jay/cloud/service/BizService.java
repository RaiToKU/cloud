package com.jay.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * @author raito
 * @date 2022/09/06
 */
@Component
public class BizService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.biz-service}")
    private String bizServiceUrl;

    @HystrixCommand(fallbackMethod = "getDefaultDataById")
    public String getDataById(Long id) {
        String url = bizServiceUrl + "/biz/" + id;
        System.out.println("调用接口：" + url);
        return restTemplate.getForObject(url, String.class);
    }

    public String getDefaultDataById(@PathVariable Long id) {
        return "服务降级";
    }

}
