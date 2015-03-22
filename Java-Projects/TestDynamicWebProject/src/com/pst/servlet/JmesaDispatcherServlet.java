/**
 * 
 */
package com.pst.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tilleryr
 *
 */
@WebServlet(urlPatterns="/jmesaTest")
public class JmesaDispatcherServlet extends JmesaBaseServlet {

	private static final long serialVersionUID = 5037848968033474545L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		createAndStorePersonList(req);
		//dispatch to view
		req.getRequestDispatcher("/jmesaTest.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//dispatch to view
		req.getRequestDispatcher("/jmesaTest.jsp").forward(req, resp);		
	}
}
