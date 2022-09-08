package com.jay.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author raito
 * @date 2022/09/07
 */
@RestController
@RequestMapping("/breaker")
public class CircleBreakerController {

    private Logger LOGGER = LoggerFactory.getLogger(CircleBreakerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.biz-service}")
    private String bizServiceUrl;

    @RequestMapping("/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handleFallback")
    public String fallback(@PathVariable Long id) {
        return restTemplate.getForObject(bizServiceUrl + "/biz/{1}", String.class, id);
    }

    @RequestMapping("/fallbackException/{id}")
    @SentinelResource(value = "fallbackException", fallback = "handleFallback2", exceptionsToIgnore = {NullPointerException.class})
    public String fallbackException(@PathVariable Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(bizServiceUrl + "/biz/{1}", String.class, id);
    }

    public String handleFallback(Long id) {
        return "服务降级返回";
    }

    public String handleFallback2(@PathVariable Long id, Throwable e) {
        LOGGER.error("handleFallback2 id:{},throwable class:{}", id, e.getClass());
        return "服务降级返回2";
    }
}
