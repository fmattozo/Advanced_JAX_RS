package org.matozzo.training.rest;


import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

/*
 * Here we are validate the BASIC AUTH
 * Using the SECURED_URL_PREFIX we can determine the "domains" that we will 
 * check or not the security
 * 
 */
@Provider
public class SecurityFilter implements ContainerRequestFilter{

	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";		// the field in the request header
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";			// the prefix = Basic ... because the value of Authorization is "Basic <64encodedUserPassword"
	private static final String SECURED_URL_PREFIX = "secure";					// using the @Path definition
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {		// Getting the request URI path and check if we will applie the security for it
			// find the authorization field
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if(authHeader != null && authHeader.size() > 0) {													// check if there are Authorization field
				String authToken = authHeader.get(0);									// get the Authorization
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");	// remove the "Basic" label from initial positions
				String decodeString = Base64.decodeAsString(authToken);					// decode the base64 user:pwd 
				StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");		// split info based in ":" -- user:pwd
				String username = tokenizer.nextToken();								// get user
				String password = tokenizer.nextToken();								// get pwd
				
				if("user".equals(username) && "password".equals(password)) {			// checking .. here we can use a stored user-pwd list to accept criteria
					return;
				}
				
			}
			
			// Case dont have authorization header
			Response unauthorizedStatus = Response
											.status(Response.Status.UNAUTHORIZED)
											.entity("User cannot access the resource.")
											.build();
			
			// command to abort connection
			requestContext.abortWith(unauthorizedStatus);
		}
		
	}

}
