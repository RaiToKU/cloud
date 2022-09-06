package com.jay.cloud.service.fallback;

import com.jay.cloud.service.BizService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author raito
 * @date 2022/09/06
 */
@Component
public class BizFallbackService implements FallbackFactory<BizService> {
    @Override
    public BizService create(Throwable cause) {
        return new BizService() {
            @Override
            public String create() {
                return "降级服务";
            }

            @Override
            public String getDataById(Long id) {
                return "降级服务";
            }

            @Override
            public String getByIds(List<Long> ids) {
                return "降级服务";
            }

            @Override
            public String getByName(String name) {
                return "降级服务";
            }

            @Override
            public String update() {
                return "降级服务";
            }

            @Override
            public String delete(Long id) {
                return "降级服务";
            }
        };
    }
}
