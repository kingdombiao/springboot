package com.biao.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class BiaoSpringApplicationRunListener implements SpringApplicationRunListener {

    public BiaoSpringApplicationRunListener(SpringApplication application, String[] args){

    }

    @Override
    public void starting() {
        System.out.println("*****BiaoSpringApplicationRunListener.starting() 执行****");

    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("*****BiaoSpringApplicationRunListener.environmentPrepared() 执行****");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("*****BiaoSpringApplicationRunListener.contextPrepared() 执行****");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("*****BiaoSpringApplicationRunListener.contextLoaded() 执行****");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("*****BiaoSpringApplicationRunListener.environmentPrepared() 执行****");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("*****BiaoSpringApplicationRunListener.running() 执行****");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("*****BiaoSpringApplicationRunListener.failed() 执行****");
    }
}
