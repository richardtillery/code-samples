/**
 * 
 */
package com.pst.servlet.init;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pst.servlet.listener.DynamicListener;


/**
 * @author tilleryr
 *
 */
public class ServletContainerInitializerImpl implements ServletContainerInitializer {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public void onStartup(Set<Class<?>> classSet, ServletContext servletContext)
			throws ServletException {
		logger.debug("ServletContainerInitializer invoked, registering servlet");
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("DynamicServlet", com.pst.servlet.DynamicServlet.class);
		servletRegistration.addMapping("/DynamicServlet");
		servletRegistration.setInitParameter("name", "Tillery");
		
		logger.debug("ServletContainerInitializer invoked, registering filter");
		FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("DynamicFilter", com.pst.servlet.filter.DynamicFilter.class);
		filterRegistration.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), false, "DynamicServlet");

		logger.debug("ServletContainerInitializer invoked, adding listener");
		servletContext.addListener(DynamicListener.class);		

	}

}
