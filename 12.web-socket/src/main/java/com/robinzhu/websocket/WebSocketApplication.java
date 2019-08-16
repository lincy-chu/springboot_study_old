package com.robinzhu.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
@EnableWebSocket
public class WebSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }

    /**
     * 会自动注册使用@ServerEndpoint注解声明的websocket endpoint，要注意如果使用独立的servlet容器，而不是直接使用springboot的内置容器，就不要注入ServerEndpointExporter，因为它将有容器自己提供和管理
     * @return
     *
     * 可以使用http://coolaf.com/tool/chattest进行测试
     * 更多相关请见: https://blog.lqdev.cn/2018/08/14/springboot/chapter-nineteen/
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
