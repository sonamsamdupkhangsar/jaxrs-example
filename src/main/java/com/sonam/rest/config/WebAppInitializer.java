package com.sonam.rest.config;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebAppInitializer implements WebApplicationInitializer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
	logger.debug("onStartup");
	servletContext.addListener(new ContextLoaderListener(createWebAppContext()));
	addApacheCxfServlet(servletContext);
    }

    private void addApacheCxfServlet(ServletContext servletContext) {
	CXFServlet cxfServlet = new CXFServlet();

	ServletRegistration.Dynamic appServlet = servletContext.addServlet("CXFServlet", cxfServlet);
	appServlet.setLoadOnStartup(1);

	Set<String> mappingConflicts = appServlet.addMapping("/api/*");
    }

    private WebApplicationContext createWebAppContext() {
	AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
	appContext.register(AppConfig.class);
	return appContext;
    }

}
