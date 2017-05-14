package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import aiss.model.resource.ConsorcioResource;

public class ConsorcioComments extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public ConsorcioComments(){
		singletons.add(ConsorcioResource.class);
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
