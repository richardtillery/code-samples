/**
 * 
 */
package com.pst.test.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tilleryr
 *
 */
@WebServlet( name="TilleryServlet", urlPatterns={"/tillery","/alttillery"})
public class TilleryServlet extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response) throws IOException {
		ServletContext newTillery = request.getServletContext().getContext("/TestWebProject1/newtillery");
		String phrase = (String) newTillery.getAttribute("newAttribute");
		response.setContentType("text/html");
		response.getWriter().write("Howdy! " + phrase);
	}
	
}
