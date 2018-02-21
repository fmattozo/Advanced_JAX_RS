package org.matozzo.training.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class PoweredByResponse implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().add("X-Powered-By", "Matozzo");
		
	}

}

/*
 * Essas classes Filter, que tem a anotation Provider são usadas aqui para injetar valores automaticamente nas resquest e Response
 * neste caso aqui estamos colocando um valor no header
 * Isso é automatico, vc cria a classe com provide e já esta pronto
 * Aqui vc poderia colocar varios headers, usar codigo para determinar se poe ou não
 * ou seja, trabalhar como uma extensão do código geral, que sempre sera executado antes do retorno 
 */
