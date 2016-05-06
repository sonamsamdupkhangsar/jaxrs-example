package com.sonam.rest.config;

import javax.ws.rs.core.Application;
import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.JAXRSDataBinding;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
//import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sonam.rest.service.AddressService;
import com.sonam.rest.service.PersonAddress;

@Configuration
public class BeanConfiguration {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean(name = Bus.DEFAULT_BUS_ID, destroyMethod = "shutdown")
    public SpringBus springBus() {
	logger.info("springBus setup");
	return new SpringBus();
    }

    @Bean
    // @DependsOn("cxf")
    public Server userResourceEndpoint(ApplicationContext appContext) {
	logger.debug("creating jaxrsServer for userResource");
	JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(new Application(),
		JAXRSServerFactoryBean.class);

	factory.setServiceBeanObjects(addressService());
	factory.setAddress("/address");
	factory.setProvider(jsonProvider());
	return factory.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
	return new JacksonJsonProvider();
    }

    @Bean
    public JAXRSDataBinding jaxrsDataBinding() {
	return new JAXRSDataBinding();
    }

    @Bean
    public AddressService addressService() {
	return new PersonAddress();
    }
}
