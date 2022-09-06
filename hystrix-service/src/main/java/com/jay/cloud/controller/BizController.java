package com.jay.cloud.controller;

import com.jay.cloud.service.BizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raito
 * @date 2022/09/06
 */
@RestController
public class BizController {

    @Autowired
    private BizService bizService;

    @GetMapping("/testFallback/{id}")
    public String testFallbackApi(@PathVariable Long id){
        return bizService.getDataById(id);
    }

}
