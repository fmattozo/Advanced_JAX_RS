package org.matozzo.training.rest.customMedias;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces("text/shortdate")
// substitui aqui o tipo que vc criou... no fundo mesmo esta retornando uma string formatada
// isso pode servir para que se use um tipo camuflado dentro de outra coisa
public class ShortDateMessageBodyWriter<T> implements MessageBodyWriter<Date>{

	// deprecated method.. just use to return -1
	@Override
	public long getSize(Date arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {

		return -1;
	}

	// verifica se o tipo que vai fazer a transformação é o mesmo q este write trata
	// retornando true or false
	@Override
	public boolean isWriteable(Class<?> type, Type arg1, Annotation[] arg2, MediaType arg3) {
		return Date.class.isAssignableFrom(type);
	}

	@Override
	// o primeiro parametro é o tipo
	public void writeTo(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream out) throws IOException, WebApplicationException {

		@SuppressWarnings("deprecation")
		String shortDate = date.getDate() + "-" + date.getMonth() + "-" + date.getYear();
		out.write(shortDate.getBytes());

	}

}
