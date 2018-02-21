package org.matozzo.training.rest.client;



import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.matozzo.training.rest.client.model.Message;

/*
 * Here we will do a get in a List of elements
 */
public class GenericDemo {

	public static void main(String[] args) {

		// created a client connection
		Client client = ClientBuilder.newClient();

		/* Here we will get the LIST (ARRAY) of messages
		 * so we need get in a List Return and inform the .get() to return a List
		 * but jersey dont know the type, so we use a GenericType class to do the conersion
		 */
		String link = "http://localhost:8080/messenger/training/";
		List<Message> messages = client.target(link).path("messages")
									.queryParam("year", 2015)
									.request(MediaType.APPLICATION_JSON)
									.get(new GenericType<List<Message>>() {});
		
		
		System.out.println(messages);

	}

}
