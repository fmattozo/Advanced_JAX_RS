package org.matozzo.training.rest.paramConverters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class MyDateConverterParam implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] anotations) {
		if(rawType.getName().equals(MyDate.class.getName())) {
			
			return new ParamConverter<T>() {
				
				@Override
				public T fromString(String value) {
					
					// trabalhando com datas
					Calendar requestDate = Calendar.getInstance();
					if("tomorrow".equalsIgnoreCase(value)) {
						requestDate.add(Calendar.DATE, 1);
					}
					else if("yesterday".equalsIgnoreCase(value)) {
						requestDate.add(Calendar.DATE, -1);
					}
					MyDate myDate = new MyDate();
					myDate.setDay(requestDate.get(Calendar.DATE));
					myDate.setMonth(requestDate.get(Calendar.MONTH));
					myDate.setYear(requestDate.get(Calendar.YEAR));
					
					return rawType.cast(myDate);
					
				}
				
				// por razoes de obrigatoriedade
				@Override
				public String toString(T myBean) {
					if(myBean == null) {
						return null;
					}
					return myBean.toString();
				}
			};
		}
		return null;
	}

}
