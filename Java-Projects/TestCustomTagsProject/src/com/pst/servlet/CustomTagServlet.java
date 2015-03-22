/**
 * 
 */
package com.pst.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for custom tag testing
 */
@WebServlet(urlPatterns="/customTagTester")
public class CustomTagServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2461820964808790653L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//set up needed attributes for iteration tags
		Collection<String> iterationCollection = new ArrayList<String>();
		for(DispatcherType type : EnumSet.allOf(DispatcherType.class)) {
			iterationCollection.add(type.toString());
		}
		request.setAttribute("simpleIterationCollection", iterationCollection);
		
		//set up needed attributes for iteration tags
		Collection<String> classicIterationCollection = new ArrayList<String>();
		for(SessionTrackingMode type : EnumSet.allOf(SessionTrackingMode.class)) {
			classicIterationCollection.add(type.toString());
		}
		request.setAttribute("classicIterationCollection", classicIterationCollection);
		
		//set up needed attributes for conditional tag
		request.setAttribute("testToDisplay", 2);
		
		//set up needed attributes for dynamic attribute tag
		request.setAttribute("providedStyles", "height:100px;width:100px;background-color:000000;");

		//set up needed attributes for tag file tag
		request.setAttribute("firstName", "Developer One");
		request.setAttribute("nextName", "Developer Two");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customTagTester.jsp");
		requestDispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
