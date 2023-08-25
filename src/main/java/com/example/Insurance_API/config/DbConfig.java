package com.example.Insurance_API.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import javax.sql.DataSource;
import java.util.HashMap;


/*@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",transactionManagerRef = "transactionManager",
        basePackages = {
                "com.example.Insurance_API.repository" })*/
public class DbConfig {

    @Bean(name = "Db")
    @ConfigurationProperties(prefix = "spring.db.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                                  @Qualifier("Db") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none");//update none
        properties.put("hibernate.dialect","org.hibernate.dialect.Oracle12cDialect");
        properties.put("jpa.database-platform","org.hibernate.dialect.Oracle12cDialect");

        return builder.dataSource(dataSource).properties(properties)
                .packages("com.example.Insurance_API.model").build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory insuranceEntityManagerFactory) {
        return new JpaTransactionManager(insuranceEntityManagerFactory);
    }
}
