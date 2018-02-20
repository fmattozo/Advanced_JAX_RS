package org.matozzo.training.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.matozzo.training.rest.client.model.Message;

// this a Java Application with resources to use (access) Rest API
// the package org.matozzo.training.rest.client.model is a copy of models of message project
// message project is the first project implemented
// so you run the message project to use this app
public class RestApiClient {

	public static void main(String[] args) {
		
		// create a client object
		// this will be used to connect with the API rest
		Client client = ClientBuilder.newClient();
		
		// Creatre a object to receive the response from API Rest
		String link = "http://localhost:8080/messenger/training/messages/1";
		Response response = client.target(link).request().get();
		
		// Converte a responde para um objeto Message
		Message message = response.readEntity(Message.class);
		
		System.out.println(message.getMessage());
		System.out.println(message.getAuthor());
		
		

	}

}
