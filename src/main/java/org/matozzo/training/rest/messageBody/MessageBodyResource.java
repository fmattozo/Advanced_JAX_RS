package org.matozzo.training.rest.messageBody;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// realizar a conversao para message body quando o jersey nao é capaz
// como transformar date em textplain
// realmente eu vejo formas mais simples de fazer isso, pois vc precisaria criar um esquema desse
// para cada tipo de conversão, assim vc tb poderia criar suas classes sem necessidade de usar
// esses recursos especificos do jersey
@Path("messageBody")
@Produces(MediaType.TEXT_PLAIN)
public class MessageBodyResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date getDate() {
		return Calendar.getInstance().getTime();
	}

}
