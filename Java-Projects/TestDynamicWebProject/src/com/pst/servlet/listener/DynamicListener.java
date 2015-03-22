/**
 * 
 */
package com.pst.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Dynamic Listener
 */
public class DynamicListener implements ServletContextListener {

	protected final Log logger = LogFactory.getLog(getClass());

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		logger.debug("DynamicListener, context destroyed: " + servletContextEvent.getServletContext().getContextPath());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		logger.debug("DynamicListener, context initialized: " + servletContextEvent.getServletContext().getContextPath());		
	}

}
