package com.tulingxueyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tulingxueyuan.mapper")
public class SpringbootOrderMybatisSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootOrderMybatisSeataApplication.class, args);
    }

}
