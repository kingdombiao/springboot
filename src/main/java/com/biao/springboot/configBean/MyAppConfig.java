package com.biao.springboot.configBean;

import com.biao.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
