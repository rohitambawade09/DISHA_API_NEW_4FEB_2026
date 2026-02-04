package com.disha.hms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.HibernateTransactionManager;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Value("${spring.datasource.username}")
	private String dbUser;
	
	@Value("${spring.datasource.password}")
	private String dbPassword;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${hibernate.show_sql}")
	private boolean showSql;
	
	@Value("${hibernate.format_sql}")
	private boolean formatSql;
	
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriver;
	
	@Value("${hibernate.hbm2ddl}")
	private String ddlAuto;
	
	 @Bean
	 public DataSource dataSource() {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName(dbDriver);
			ds.setUrl(dbUrl);
			ds.setUsername(dbUser);
			ds.setPassword(dbPassword);
			return ds;
	 }
	
	 @Bean(name="entityManagerFactory")
	 public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
	        factory.setDataSource(dataSource());
	        factory.setPackagesToScan("com.disha.hms.entity");

	        Properties props = new Properties();
	        props.put("hibernate.dialect", hibernateDialect);
	        props.put("hibernate.show_sql", showSql);
	        props.put("hibernate.format_sql", formatSql);
	        props.put("hibernate.hbm2ddl.auto", ddlAuto);

	        factory.setHibernateProperties(props);
	        return factory;
	 }
	
	 @Bean(name="transactionManager")
	 public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	        HibernateTransactionManager tx = new HibernateTransactionManager();
	        tx.setSessionFactory(sessionFactory);
	        return tx;
	 }
	 
}
