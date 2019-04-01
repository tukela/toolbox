//package com.hl.kit.core.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author: honglei
// * @Date: 2019/3/28 15:36
// * @Version: 1.0
// * @See:
// * @Description:
// */
//
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(new MyHandler(), "/myHandler")
//                .addInterceptors(new HttpSessionHandshakeInterceptor());
//    }
//
//    @Bean
//    public WebSocketHandler myHandler() {
//        return new MyHandler();
//    }
//
//}
