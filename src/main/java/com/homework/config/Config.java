package com.homework.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.homework.dao.OfferDaoImpl;
import com.homework.entity.Offer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.homework" })
@EnableTransactionManagement
public class Config implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSession = new LocalSessionFactoryBean();
		localSession.setDataSource(getDataSource());
		localSession.setPackagesToScan("com.homework.entity");
		localSession.setAnnotatedClasses(Offer.class);
		localSession.setHibernateProperties(getHibernateProperties());
		return localSession;
	}

	public Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.connection.pool_size", "10");

		return hibernateProperties;
	}

	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/School");
		dataSource.setUsername("root");
		dataSource.setPassword("arif12345678arif");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getTransection(SessionFactory sessionFactory123) {
		HibernateTransactionManager hibernateTransection = new HibernateTransactionManager(sessionFactory123);
		return hibernateTransection;
	}
    @Bean
	public JavaMailSender getConnectionServer() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setUsername("manismostafa@gmail.com");
		javaMailSenderImpl.setPassword("arif#@#4");
		javaMailSenderImpl.setPort(587);
		Properties properties = new Properties();
		properties.putIfAbsent("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

		javaMailSenderImpl.setJavaMailProperties(properties);
		return javaMailSenderImpl;
	}
	 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/UrlToResourceFolder/**").addResourceLocations("/resources/");

	}

}
