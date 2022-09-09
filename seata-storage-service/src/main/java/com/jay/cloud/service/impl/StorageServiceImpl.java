package com.jay.cloud.service.impl;

import com.jay.cloud.dao.StorageDAO;
import com.jay.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author raito
 * @date 2022/09/09
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDAO storageDAO;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDAO.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}
