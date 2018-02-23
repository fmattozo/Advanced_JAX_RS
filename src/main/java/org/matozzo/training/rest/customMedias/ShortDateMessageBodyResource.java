package org.matozzo.training.rest.customMedias;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// criando um tipo de retorno novo
// e usando mutiplos produces
// vc deve especificar no header da request qual deles vc quer
@Path("messageBody")
public class ShortDateMessageBodyResource {

	@GET
	//@Produces(value = { MediaType.TEXT_PLAIN, "text/shortdate" })
	@Produces(MediaType.TEXT_PLAIN)
	public Date getDate() {
		return Calendar.getInstance().getTime();
	}

}
