package com.jay.cloud.controller;

import com.jay.cloud.entity.Order;
import com.jay.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raito
 * @date 2022/09/09
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public String create(Order order) {
        orderService.create(order);
        return "订单创建成功!";
    }
}
