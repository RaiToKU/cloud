package com.jay.cloud.controller;

import com.jay.cloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raito
 * @date 2022/09/09
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/decrease")
    public String decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return "扣减库存成功！";
    }
}
