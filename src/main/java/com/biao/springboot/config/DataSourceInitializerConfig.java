package com.biao.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

//@Configuration
public class DataSourceInitializerConfig {

    //@Qualifier("dataSource")
    //@Autowired
    private DataSource dataSource;

    public DataSourceInitializer dataSourceInitializer(){
        ClassPathResource classPathResource=new ClassPathResource("schema-all.sql");

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(
                new ResourceDatabasePopulator(true, true, "utf-8", classPathResource));

        dataSourceInitializer.setEnabled(true);
        return dataSourceInitializer;
    }
}
