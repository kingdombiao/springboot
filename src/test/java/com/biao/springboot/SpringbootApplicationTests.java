package com.biao.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * SpringBoot 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void applicationContext(){
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);

    }

    @Test
    public void testDataSource() throws SQLException {

        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    @Test
    public void testSemaphore() throws InterruptedException {
        Semaphore semaphore=new Semaphore(3);
        semaphore.acquire();
        System.out.println("get success");
        semaphore.release();

    }



}
