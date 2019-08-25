package com.spring.data.jpa.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableJpaRepositories("com.spring.data.jpa.repository")
@EnableTransactionManagement
@ComponentScan("com.spring.data.jpa")
public class DataConfig {
	
	@Bean
	public DataSource dataSource()
	{	
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).build();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2.ddl.auto","create-drop");
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.spring.data.jpa");
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setJpaProperties(jpaProperties);
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
		
	}
	
	@Bean
	public PlatformTransactionManager  transactionManager()
	{
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

}
