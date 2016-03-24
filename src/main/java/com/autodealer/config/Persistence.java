package com.autodealer.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by user on 23.03.2016.
 */

@Configuration
@ComponentScan({
        "com.autodealer.config",
        "com.autodealer.model",
        "com.autodealer.repository",
        "com.autodealer.service"
})
@EnableTransactionManagement
@PropertySource(value = { "classpath:/dbProp/hibernate_Spring_MySQL.properties" })
public class Persistence {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        hikariConfig.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
        hikariConfig.setUsername(environment.getRequiredProperty("jdbc.username"));
        hikariConfig.setPassword(environment.getRequiredProperty("jdbc.password"));
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.autodealer");
        sessionFactory.setHibernateProperties(additionalProperties());

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }

}
