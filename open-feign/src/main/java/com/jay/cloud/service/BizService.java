package com.jay.cloud.service;

import com.jay.cloud.service.fallback.BizFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author raito
 * @date 2022/09/06
 */
@Component
@FeignClient(value = "biz-service", fallbackFactory = BizFallbackService.class)
public interface BizService {

    @PostMapping("/biz/create")
    String create();

    @GetMapping("/biz/{id}")
    String getDataById(@PathVariable Long id);

    @GetMapping("/biz/getUserByIds")
    String getByIds(@RequestParam List<Long> ids);

    @GetMapping("/biz/getByUsername")
    String getByName(@RequestParam String name);

    @PostMapping("/biz/update")
    String update();

    @PostMapping("/biz/delete/{id}")
    String delete(@PathVariable Long id);

}
