package com.jay.cloud.service;

import com.jay.cloud.service.impl.BizFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author raito
 * @date 2022/09/07
 */
@FeignClient(value = "nacos-biz-service", fallback = BizFallbackService.class)
public interface BizService {

    @PostMapping("/biz/create")
    String create();

    @GetMapping("/biz/{id}")
    String getDataById(@PathVariable Long id);

    @GetMapping("/biz/getByUsername")
    String getByUsername(@RequestParam String username);

    @PostMapping("/biz/update")
    String update();

    @PostMapping("/biz/delete/{id}")
    String delete(@PathVariable Long id);
}
