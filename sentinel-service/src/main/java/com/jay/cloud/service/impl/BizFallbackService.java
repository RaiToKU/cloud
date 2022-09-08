package com.jay.cloud.service.impl;

import com.jay.cloud.service.BizService;
import org.springframework.stereotype.Component;

/**
 * @author raito
 * @date 2022/09/07
 */
@Component
public class BizFallbackService implements BizService {
    @Override
    public String create() {
        return "服务降级处理create";
    }

    @Override
    public String getDataById(Long id) {
        return "服务降级处理getDataById";
    }

    @Override
    public String getByUsername(String username) {
        return "服务降级处理getByUsername";
    }

    @Override
    public String update() {
        return "服务降级处理update";
    }

    @Override
    public String delete(Long id) {
        return "服务降级处理delete";
    }
}
