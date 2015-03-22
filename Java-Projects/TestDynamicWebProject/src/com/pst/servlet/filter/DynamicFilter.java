/**
 * 
 */
package com.pst.servlet.filter;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Dynamically registered filter
 */
public class DynamicFilter implements Filter {

	protected final Log logger = LogFactory.getLog(getClass());

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		logger.debug("DynamicFilter invoked, filtering request " + ((HttpServletRequest) servletRequest).getRequestURL());
		filterChain.doFilter(servletRequest, servletResponse);
		logger.debug("DynamicFilter invoked, sending response");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
