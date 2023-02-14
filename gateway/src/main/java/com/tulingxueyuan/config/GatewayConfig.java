package com.tulingxueyuan.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.spring.webflux.callback.BlockRequestHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @author:gaojinjun
 * @date: 2023022023/2/12下午5:20
 **/
@Configuration
public class GatewayConfig {
//    @PostConstruct
//    public void init() {
//        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
//            @Override
//            public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable throwable) {
//                System.out.println(throwable.toString());
//                return ServerResponse.status(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(BodyInserters.fromValue("降级了!"));
//
//            }
//        };
//    GatewayCallbackManager.setBlockHandler(blockRequestHandler);
//    }
}
