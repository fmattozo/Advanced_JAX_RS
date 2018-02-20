package org.matozzo.training.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
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
		// opção 1
		//String link = "http://localhost:8080/messenger/training/messages/1";
		//Response response = client.target(link).request().get();

		// opção 2
		String link = "http://localhost:8080/messenger/training/messages/1";
		Response response = client.target(link)
								  .request(MediaType.APPLICATION_JSON)		// definindo qual o tipo de resposta esperado
								  .get();									
		// vc pode passar o tipo do objeto aqui direto usando  .get(Message.class) mas ai o response tem q ser trocado pelo tipo Message
		// se fizer assim vc perde o response, de onde pode pegar header e tudo mais então é melhor deixar assim e ter os 2 objetos - reponse e o message que criamos abaixo
		// outr opção para isso é retornar como String .get(String.class),, ai o json vira string, mas perde todos os outros dados melhor nao fazer.

		/*
		opção 3 // fazendo em partes a mesma coisa q acima // dessa forma vc pode
		usar o target varias vezes, não vi vantagem real, mas é uma forma 
		WebTarget target = client.target(link); 
		Builder request = target.request(); 
		Response receivedResponse = request.get(); 
		Message receiveMessage = receivedResponse.readEntity(Message.class);
		*/

		// Converte a responde para um objeto Message
		Message message1 = response.readEntity(Message.class);

		/*
		 * Um exemplo de best practice é criar target genericos
		 * confesso que acho melhor de usar a String link, como eu fiz no exemplo acima, melhor
		 * pois além de manter response e message, trabalhar com concatenação de string é bem mais simples
		 * ao invés de fazer varios WebTarget, vc cria strings e concatenas ela com + no target 
		 */
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/training/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget simgleMessageTarget = messagesTarget.path("{messageId}");		// passando para ser resolvido depois
		Message message2 = simgleMessageTarget
							.resolveTemplate("messageId", "2")			// resolvendo aqui o valor para messageId
							.request(MediaType.APPLICATION_JSON)
							.get(Message.class);						// vc não tem mais o response para validar nada, vem direto o message
		/* Perceba que se usasse o exemplo 2, criando constantes ou strings para os targets
		 * vc teria menos trabalho e a mim pareceria mais claro
		 * mas esse aqui é um recurso valido e citado como best practice :(
		 */
		
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage());

	}

}
