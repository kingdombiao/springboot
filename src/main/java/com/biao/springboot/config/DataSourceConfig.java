package com.biao.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * druid数据源配置类
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }


    /**
     * 配置Druid的监控
     * 1、 配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean startViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParam=new HashMap<>();
        initParam.put("loginUsername","admin");
        initParam.put("loginPassword","admin");
        initParam.put("allow",""); //默认允许所有访问
        initParam.put("deny","192.168.1.106");

        registrationBean.setInitParameters(initParam);
        return registrationBean;

    }

    //2、 配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());

        Map<String,String> initParam=new HashMap<>();
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        filterRegistrationBean.setInitParameters(initParam);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return filterRegistrationBean;
    }
}
