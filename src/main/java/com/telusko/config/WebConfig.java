package com.telusko.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.telusko" })
public class WebConfig implements WebMvcConfigurer {
 
 @Autowired
 DataSource dataSource;
 
 @Bean
 public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate(){
  return new NamedParameterJdbcTemplate(dataSource);
 }
 
 @Bean
 public DataSource getDataSource() throws NamingException{
  JndiTemplate jndiTemplate = new JndiTemplate();
  DataSource dataSource = (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/springmvc");
  
  return dataSource;
 }
 
 
 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
  registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
 }
 
 @Bean
 public InternalResourceViewResolver viewResolver(){
  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

  viewResolver.setPrefix("/WEB-INF/jsp/");
  viewResolver.setSuffix(".jsp");
  viewResolver.setViewClass(JstlView.class);
  return viewResolver;
 }
}