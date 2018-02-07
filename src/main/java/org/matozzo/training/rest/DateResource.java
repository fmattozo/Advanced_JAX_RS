package org.matozzo.training.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/*// pegando como uma string, sem conversao
@Path("date/{dateString}")
public class DateResource {
	
	@PathParam("dateString") private String dateString;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate() {
		return "Got " + dateString;
	}
	

}*/



@Path("date/{dateString}")
public class DateResource {
	
	@PathParam("dateString") private MyDate myDate;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate() {
		return "Got " + myDate.toString();
	}
	

}