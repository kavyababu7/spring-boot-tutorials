package com.kb.sample.multidatasourcedemo.readingdb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.kb.sample.multidatasourcedemo.readingdb.repository",
        entityManagerFactoryRef = "readingEntityManagerFactory",
        transactionManagerRef = "readingTransactionManager"
)
public class ReadingDataSourceJPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean readingEntityManagerFactory(
      @Qualifier("readingDataSource") DataSource dataSource,
      EntityManagerFactoryBuilder builder) {
        return builder
          .dataSource(dataSource)
          .packages("com.kb.sample.multidatasourcedemo.readingdb.model")
          .build();
    }

    @Bean
    public PlatformTransactionManager readingTransactionManager(
      @Qualifier("readingEntityManagerFactory") LocalContainerEntityManagerFactoryBean readingEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(readingEntityManagerFactory.getObject()));
    }
}