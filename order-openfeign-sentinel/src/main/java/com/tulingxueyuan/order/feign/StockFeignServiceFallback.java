package com.tulingxueyuan.order.feign;

import org.springframework.stereotype.Component;

/**
 * @author:gaojinjun
 * @date: 2023022023/2/11下午5:15
 **/
@Component
public class StockFeignServiceFallback implements StockFeignService{
    @Override
    public String reduct2(){
        return "/stock-service/stock/reduct2 降级了";
    }
}
