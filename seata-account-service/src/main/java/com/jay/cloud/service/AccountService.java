package com.jay.cloud.service;

import java.math.BigDecimal;

/**
 * @author raito
 * @date 2022/09/09
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}
