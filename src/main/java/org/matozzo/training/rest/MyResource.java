package org.matozzo.training.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// refrente ao lifecycle dos resources
// @singleton faz com que apenas uma sessão dessa classe seja criada
// sem ele cada vez q acessar a classe uma nova instancia será criada - esse é o padrão
// usando ele vc cria uma instancia e mantem ela ativa
// o problema aqui é que assim vc cria uma instancia antes de processar a request
// e dessa forma não consegue trabalhar com pathparam queryparam etc
@Path("test")
@Singleton
public class MyResource {

	
	private int count;
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		count++;
		return "It works!.. This method was called " + count + " times";
	}
	
	
	
}