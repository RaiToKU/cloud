package com.jay.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raito
 * @date 2022/09/07
 */
@RestController
@RequestMapping("/rate-limit")
public class RateLimitController {

    /**
     * 按资源名称限流，需要指定限流处理逻辑
     */
    @GetMapping("/by-resource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public String byResource() {
        System.out.println(System.currentTimeMillis());
        return "按资源名称限流";
    }

    /**
     * 按URL限流，有默认的限流处理逻辑
     */
    @GetMapping("/by-url")
    @SentinelResource(value = "by-url", blockHandler = "handleException")
    public String byUrl() {
        System.out.println(System.currentTimeMillis());
        return "按url限流";
    }

    public String handleException(BlockException exception) {
        System.out.println(System.currentTimeMillis());
        return "错误异常" + exception.getClass().getCanonicalName();
    }

}
