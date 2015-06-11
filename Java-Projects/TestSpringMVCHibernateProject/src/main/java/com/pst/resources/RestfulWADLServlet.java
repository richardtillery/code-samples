/**
 * 
 */
package com.pst.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author tilleryr
 *
 */
@Path("/wadlServlet")
public class RestfulWADLServlet{

	@GET
	@Path("/getWADL") 
	@Consumes("text/html")
	public String getWADL() {
		return "blah!";
	}

	@POST
	@Path("/postWADL") 
	@Produces("application/json")
	public String postWADL() {
		return "blah!";
	}

}
