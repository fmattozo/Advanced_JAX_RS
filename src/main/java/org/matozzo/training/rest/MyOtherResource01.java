package org.matozzo.training.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/path")
public class MyOtherResource01 {
	
	// fazendo dessa forma, pegando os Param como atributos
	// todos os metodos podem usa-los sem a necessidade de receber como parametro
	// exatamente como atributos de uma classe
	// Mas nao é possível usar simgleton numa classe como esta.
	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("queryParam") private String queryParamExample;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMyOtherResource01() {
		return "Teste " + pathParamExample + " " + queryParamExample;
	}

}
