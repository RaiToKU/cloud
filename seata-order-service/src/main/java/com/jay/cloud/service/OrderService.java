package com.jay.cloud.service;

import com.jay.cloud.entity.Order;

/**
 * @author raito
 * @date 2022/09/09
 */
public interface OrderService {


    /**
     * 创建订单
     */
    void create(Order order);

}
