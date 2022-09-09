package com.jay.cloud.service;

/**
 * @author raito
 * @date 2022/09/09
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);

}
