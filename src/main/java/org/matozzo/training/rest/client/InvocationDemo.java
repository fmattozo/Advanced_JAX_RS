package org.matozzo.training.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




public class InvocationDemo {

	public static void main(String[] args) {
		
		// Usar um metodo para construir a request primeiro
		InvocationDemo demo = new InvocationDemo();
		Invocation invocation = demo.prepareRequestForMessagesByYear(2015);	// Creating a "request"
		Response response = invocation.invoke();							// Here the request is really executed
		
		System.out.println(response.getStatus());
		

	}
	
	
	public Invocation prepareRequestForMessagesByYear(int year) {

		/* This method will return a prepared request
		 * that dont run here, but just return the request PREPARED
		 */
		
		// create a client object
		// this will be used to connect with the API rest
		Client client = ClientBuilder.newClient();
		
		String link = "http://localhost:8080/messenger/training/";
		return client.target(link)
				.path("messages")						// Podia estar no link, mas colocando aqui fica mais claro
				.queryParam("year", year)				// Assim que se passa QueryParam
				.request(MediaType.APPLICATION_JSON)
				.buildGet();							// Here is the black magic... using BUILDGET()
		
	}

}
