package org.matozzo.training.rest.paramConverters;

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


// realizar a conversao usando paramconverter
// mais complexo mas serve para cassos onde vc nao sabe oq vem
// criando coisas Genericas
// usando o conceito de generics do java
// Para isso deve criar mais 2 classes para a conversão... ParamConverterProvider e ParamConverter (inside the other one)
@Path("date/{dateString}")
public class DateResource {
	
	@PathParam("dateString") private MyDate myDate;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate() {
		return "Got " + myDate.toString();
	}
	

}