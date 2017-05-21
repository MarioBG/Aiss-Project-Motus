package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.consorcio.Parada;


@Path("/paradas")
public class ParadaResource {
	
	/* Singleton */
	private static ParadaResource _instance=null;
	ParadasRepository repository;
	
	private ParadaResource() {
		repository=MapParadasRepository.getInstance();

	}
	
	public static ParadaResource getInstance()
	{
		if(_instance==null)
				_instance=new ParadaResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Parada> getAll()
	{
		return repository.getAllParadas();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Parada get(@PathParam("id") String id)
	{
		Parada list = repository.getParada(id);
		
		if (list == null) {
			throw new NotFoundException("The stop with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addParada(@Context UriInfo uriInfo, Parada parada) {
		if (parada.getNombre() == null || "".equals(parada.getNombre()))
			throw new BadRequestException("The name of the stop must not be null");
		if (parada.getIdNucleo() == null || "".equals(parada.getIdNucleo()))
			throw new BadRequestException("The municipality code must not be null");
		if (parada.getIdZona() == null || "".equals(parada.getIdZona()))
			throw new BadRequestException("The zone code must not be null");

		repository.addParada(parada);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(parada.getIdParada());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(parada);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateParada(Parada parada) {
		Parada oldparada = repository.getParada(parada.getIdParada());
		if (oldparada == null) {
			throw new NotFoundException("The stop with id="+ parada.getIdParada() +" was not found");			
		}
		
		// Update name
		if (parada.getNombre()!=null)
			oldparada.setNombre(parada.getNombre());
		
		// Update municipality
		if (parada.getIdNucleo()!=null)
			oldparada.setIdNucleo(parada.getIdNucleo());
		
		// Update zone
			if (parada.getIdZona()!=null)
				oldparada.setIdZona(parada.getIdZona());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removePlaylist(@PathParam("id") String id) {
		Parada toberemoved=repository.getParada(id);
		if (toberemoved == null)
			throw new NotFoundException("The playlist with id="+ id +" was not found");
		else
			repository.deleteParada(id);
		
		return Response.noContent().build();
	}
}
