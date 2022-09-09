package com.jay.cloud.dao;

import com.jay.cloud.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author raito
 * @date 2022/09/09
 */
@Repository
public interface OrderDAO {

    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
