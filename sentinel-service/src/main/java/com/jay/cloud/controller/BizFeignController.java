package com.jay.cloud.controller;

import com.jay.cloud.service.BizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raito
 * @date 2022/09/07
 */
@RestController
@RequestMapping("/biz")
public class BizFeignController {

    @Qualifier("com.jay.cloud.service.BizService")
    @Autowired
    private BizService bizService;

    @GetMapping("/{id}")
    public String getDataById(@PathVariable Long id) {
        return bizService.getDataById(id);
    }

    @GetMapping("/getByUsername")
    public String getByUsername(@RequestParam String username) {
        return bizService.getByUsername(username);
    }

    @PostMapping("/create")
    public String create() {
        return bizService.create();
    }

    @PostMapping("/update")
    public String update() {
        return bizService.update();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return bizService.delete(id);
    }

}
