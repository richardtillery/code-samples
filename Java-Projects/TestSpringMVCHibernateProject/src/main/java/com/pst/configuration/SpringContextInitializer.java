package com.pst.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Spring implements the javax.servlet.ServletContainerInitializer SPI, their implementation 
 * (org.springframework.web.SpringServletContainerInitializer) handles WebApplicationInitializer(s) like this one.
 * 
 * i.e., this will fire up upon deployment and can be used to create/register servlets with the container, 
 * resulting in an XML-less Web Archive.
 */
public class SpringContextInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		
		//create context, provide our configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringConfiguration.class);
		context.setServletContext(servletContext);
		
		//create and register dispatcher servlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring",  dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/spring/*");		
		
		dispatcherServlet.refresh();
		context.refresh();
		
		
		//create and register homemade WADL servlet as well
		ServletContainer restfulServlet = new ServletContainer();
		ServletRegistration.Dynamic newDispatcher = servletContext.addServlet("restful",  restfulServlet);
		newDispatcher.setInitParameter("jersey.config.server.provider.packages", "com.pst.resources");
		newDispatcher.setLoadOnStartup(1);
		newDispatcher.addMapping("/rest/*");		
	}
}
