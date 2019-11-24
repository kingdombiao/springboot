package com.biao.springboot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class BiaoApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("****BiaoApplicationContextInitializer.initialize() 执行****"+applicationContext);
    }
}
