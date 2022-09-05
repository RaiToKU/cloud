package com.jay.cloud.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author raito
 * @date 2022/09/02
 */
@RestController
@RequestMapping("/biz")
public class BizController {

    @PostMapping("/create")
    public String create() {
        return "操作成功";
    }

    @GetMapping("/{id}")
    public String getDataById(@PathVariable Long id) {
        System.out.println("获取数据" + id);
        return "获取信息";
    }

    @GetMapping("/getUserByIds")
    public String getByIds(@RequestParam List<Long> ids) {
        return "根据ids获取用户信息，用户列表为" + ids;
    }

    @GetMapping("/getByUsername")
    public String getByName(@RequestParam String name) {
        return "获取信息" + name;
    }

    @PostMapping("/update")
    public String update() {
        return "操作成功";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "操作成功";
    }

}
