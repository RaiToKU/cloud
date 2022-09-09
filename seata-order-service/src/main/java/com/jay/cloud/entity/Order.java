package com.jay.cloud.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author raito
 * @date 2022/09/09
 */
@Data
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;

}
