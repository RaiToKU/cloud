package com.jay.cloud.loadbalancer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author raito
 * @date 2022/09/05
 */
@RestController
@RequestMapping("/biz")
public class BizController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.biz-service}")
    private String bizServiceUrl;

    @PostMapping("/create")
    public String create() {
        return restTemplate.getForObject(bizServiceUrl + "biz/create", String.class);
    }

    @GetMapping("/{id}")
    public String getDataById(@PathVariable Long id) {
        ResponseEntity<String> forObject = restTemplate.getForEntity(bizServiceUrl + "biz/{1}", String.class, id);
        return forObject.getBody();
    }

    @GetMapping("/getUserByIds")
    public String getByIds(@RequestParam List<Long> ids) {
        return restTemplate.getForObject(bizServiceUrl + "getUserByIds?ids={1}", String.class, ids);
    }

    @GetMapping("/getByUsername")
    public String getByName(@RequestParam String name) {
        return restTemplate.getForObject(bizServiceUrl + "getByUsername?ids={1}", String.class, name);
    }

    @PostMapping("/update")
    public String update() {
        return restTemplate.postForObject(bizServiceUrl + "update", null, String.class);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return restTemplate.postForObject(bizServiceUrl + "delete/{1}", null, String.class, id);
    }

}
