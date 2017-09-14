package com.niit.collaborate.config;


import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.collaborate.dao.BlogDAO;
import com.niit.collaborate.dao.BlogDAOImpl;
import com.niit.collaborate.model.Blog;

@Configuration
@ComponentScan("com.niit.collaborate")
public class DBConfig
{
public DataSource getOracleDataSource()
{
	DriverManagerDataSource driverManagerDataSource =new DriverManagerDataSource();
	driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.oracle");
	driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	driverManagerDataSource.setUsername("AathiraSanthosh");
	driverManagerDataSource.setPassword("Aathi7atun");
	return driverManagerDataSource;
}

public Properties getHibernateProperties()
{
	Properties properties = new Properties();
	properties.setProperty("hibernate.hbm2ddl.auto", "update");
	properties.put("hibernate.dialect","org.hibernate.dialect.oracle11");
	return properties;
}

@Bean
public SessionFactory getSessionFactory()
{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		return localSessionFactoryBuilder.buildSessionFactory();
}

@Bean 
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
{
	return new HibernateTransactionManager(sessionFactory);
}
	
@Bean
public BlogDAO getBlogDAO(SessionFactory sessionFactory)
{
	return new BlogDAOImpl(sessionFactory);
}
}
