package org.matozzo.training.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


// @ApplicationPath("webapi")
// defini o path inicial da aplicação... blabla/webapi/<o resto>
// diferente de antes quando editamos o arquivo web.xml para configurar isso
@ApplicationPath("webapi")
public class MyRestApiApp extends Application{
	
	// We dont need to implement nothing here
	// cause "extends Application"

}


