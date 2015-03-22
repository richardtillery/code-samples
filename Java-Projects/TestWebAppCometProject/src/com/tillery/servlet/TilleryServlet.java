/**
 * 
 */
package com.tillery.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bond
 *
 */
@WebServlet(name="TilleryServlet", urlPatterns={"/tillery"}, asyncSupported=true)
public class TilleryServlet extends HttpServlet {
	Logger logger = Logger.getLogger(this.getClass().getCanonicalName());

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		final AsyncContext asyncContext = request.startAsync(request, response);
		asyncContext.start(new Thread() {
			public void run() {
				logger.info("async context time!!!");
				for(int i = 10; i > 0; i--) {
					try {
						//wait 2 seconds then write another number to the response
						Thread.sleep(2000);
						asyncContext.getResponse().getWriter().write("[" + i + "]");
						asyncContext.getResponse().getWriter().flush();
						logger.info("async context wrote " + i + "!!!");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				asyncContext.complete();
			}
		});
		logger.info("completed reponse");		
	}

}
