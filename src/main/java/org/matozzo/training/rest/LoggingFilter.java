package org.matozzo.training.rest;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;



@Provider
public class LoggingFilter implements ContainerRequestFilter,
									  ContainerResponseFilter		// Não é uma boa fazer isso, melhor ter 2 classes para resolver as coisas separas
									  {

	// Metodo from ContainerRequestFilter
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Request Filter");
		System.out.println("Headers: " + requestContext.getHeaders());
		
	}

	// Metodo from ContainerResponseFilter
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		System.out.println("RESPONSE Filter");
		System.out.println("Headers: " + responseContext.getHeaders());
		
	}

}
