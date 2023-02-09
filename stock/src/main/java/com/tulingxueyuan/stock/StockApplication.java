package com.tulingxueyuan.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:gaojinjun
 * @date: 2023022023/2/7下午2:10
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class StockApplication {
    public static void main(String[] args) {

        SpringApplication.run(StockApplication.class,args);
    }
}
