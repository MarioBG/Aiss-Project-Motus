package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

public class ConsorcioComments extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public ConsorcioComments(){
		singletons.add(ComentariosResource.getInstance());
	}

	public Set<Class<?>> getClasses(){
		return classes;
	}
	
	public Set<Object> getSingletons(){
		return singletons;
	}
	
	@GET
	@Produces("application/json")
	public String getCosicas(){
		return "meh";
	}
	
}
