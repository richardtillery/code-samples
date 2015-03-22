/**
 * 
 */
package com.pst.test.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tilleryr
 *
 */
@WebServlet( name="NewTilleryServlet", urlPatterns={"/newtillery","/altnewtillery"}, 
				initParams={ @WebInitParam(name="newTilleryPhrase", value="Dude!")})
public class NewTilleryServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.getServletContext().setAttribute("newAttribute", this.getInitParameter("newTilleryPhrase"));		
		response.setContentType("text/html");
		response.getWriter().write("Howdy!");
	}
	
}
