package com.jay.cloud.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author raito
 * @date 2022/09/09
 */
@Data
public class Account {

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
