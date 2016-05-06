package com.sonam.rest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "com.sonam" })
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public AppConfig() {
	logger.debug("instantiating AppConfig");
    }
}
