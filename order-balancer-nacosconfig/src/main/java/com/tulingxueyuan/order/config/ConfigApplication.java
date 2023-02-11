package com.tulingxueyuan.order.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author:gaojinjun
 * @date: 2023022023/2/10下午10:41
 **/
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("username :"+userName+"; age: "+userAge);

        String name = applicationContext.getEnvironment().getProperty("spring.application.name");
        String age = applicationContext.getEnvironment().getProperty("server.port");
        System.err.println("username :"+name+"; age: "+age);
    }
}
