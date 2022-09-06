package com.jay.cloud.controller;

import com.jay.cloud.service.BizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author raito
 * @date 2022/09/06
 */
@RestController
@RequestMapping("/biz")
public class BizFeignController {

    @Autowired
    private BizService bizService;

    @PostMapping("/create")
    public String create() {
        return bizService.create();
    }

    @GetMapping("/{id}")
    public String getDataById(@PathVariable Long id) {
        return bizService.getDataById(id);
    }

    @GetMapping("/getUserByIds")
    public String getByIds(@RequestParam List<Long> ids) {
        return bizService.getByIds(ids);
    }

    @GetMapping("/getByUsername")
    public String getByName(@RequestParam String name) {
        return bizService.getByName(name);
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
