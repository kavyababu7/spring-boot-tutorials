package com.kb.sample.multidatasourcedemo.readingdb;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ReadingDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.first")
    public DataSourceProperties readingDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource readingDataSource() {
        return readingDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}