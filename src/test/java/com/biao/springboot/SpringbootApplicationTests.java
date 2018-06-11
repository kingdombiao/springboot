package com.biao.springboot;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.biao.springboot.bean.Person;
import com.biao.springboot.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void applicationContext(){
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);

    }


    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
