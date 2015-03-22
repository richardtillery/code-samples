/**
 * 
 */
package com.pst.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Dynamically generated upon deployment
 */
public class DynamicServlet extends HttpServlet {

	private static final long serialVersionUID = -1252849554933138498L;

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().write("GET recieved for " + this.getInitParameter("name") + "!");
		resp.flushBuffer();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().write("POST recieved for " + this.getInitParameter("name") + "!");
		resp.flushBuffer();
	}

}
