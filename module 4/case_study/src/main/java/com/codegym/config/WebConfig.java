package com.codegym.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
public class WebConfig {
//    @Bean
//    public DataSource dataSource()	{
//        EmbeddedDatabaseBuilder builder	=	new	EmbeddedDatabaseBuilder();
//        return	builder.setType(EmbeddedDatabaseType.HSQL).build();
//    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory()	 {
//        HibernateJpaVendorAdapter vendorAdapter	 =	new	HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        LocalContainerEntityManagerFactoryBean	factory	=	new	LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.codegym.entity");
//        factory.setDataSource(dataSource());
//        return	factory;
//    }
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)	 {
//        JpaTransactionManager	txManager	=	new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory);
//        return	txManager;
//    }
}
