package com.tulingxueyuan.order.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author:gaojinjun
 * @date: 2023022023/2/10下午4:42
 **/

@FeignClient(name="stock-service",path="/stock",fallback=StockFeignServiceFallback.class)
public interface StockFeignService {
    //声明需要调用的rest接口对应的方法
    @RequestMapping("/reduct2")
    public String reduct2();
}



//@RestController
//@RequestMapping("/stock")
//public class StockController {
//    @RequestMapping("/reduct")
//    public String reduct(){
//        System.out.println("加上了nacos，库存扣减成功");
//        return "stock-service:nacos 扣减库存 分布式!!!";
//    }
//}
