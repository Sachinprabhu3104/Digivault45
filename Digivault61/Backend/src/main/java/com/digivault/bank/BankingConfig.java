package com.digivault.bank;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.digivault" })
public class BankingConfig {

    @Bean
     JdbcTemplate jdbcTemplate() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource());

        return jdbcTemplate;
    }

    public DataSource datasource(){

        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUsername("digiusr");
        ds.setPassword("password");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/digivault?useSSL=false");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }

}
