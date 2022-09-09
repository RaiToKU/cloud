package com.jay.cloud.service.impl;

import com.jay.cloud.dao.AccountDAO;
import com.jay.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author raito
 * @date 2022/09/09
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //        try {
        //            Thread.sleep(30*1000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        accountDAO.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
