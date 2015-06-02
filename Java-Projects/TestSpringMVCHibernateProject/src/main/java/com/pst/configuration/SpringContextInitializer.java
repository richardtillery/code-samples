package com.pst.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

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
	}
}
