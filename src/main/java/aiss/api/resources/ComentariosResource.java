package aiss.api.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.consorcio.ParadaDatos;
import aiss.model.consorcio.ParadasDatos;
import aiss.model.resource.ConsorcioResource;


@Path("/comentarios")
public class ComentariosResource {
	
	private static ComentariosResource _instance=null;
	private static List<String> comentarios = new ArrayList<String>();
	private static List<List<ParadaComentada>> paradas = new ArrayList<List<ParadaComentada>>();
	
	
	private ComentariosResource() {
		comentarios.add("Los autobuses suelen tardar bastante en esta parada.");
		comentarios.add("ola xd alguna bez el condoctor iba borracho y emos tenido que parar porque iba dando eses y asi no se podia ir");
		comentarios.add("El servicio de esta parada es muy regular, estoy muy contento.");
		comentarios.add("Ya podrían poner banquitos o algo, que vaya tela tenerse que ir al bar de enfrente.");
		comentarios.add("Esta parada suele estar bien, pero en fiestas cortan por la calle de enfrente y no hay quien pase y tiene que dar el bus una vuelta muy grande.");
		comentarios.add("Ceci n\'est pas une critique.");
		comentarios.add("Buen servicio, buena accesibilidad y buen servicio en general.");
		comentarios.add("Pues la verdad es que yo me la esperaba más grande, no sé.");
		comentarios.add("Ya he cogido el bus y me aburro, por eso escribo este comentario.");
		rellenaListaParadas();
	}
	
	public static void rellenaListaParadas(){
		ConsorcioResource cr = null;
		Random r = new Random();
		for(int idConsorcio=1; idConsorcio<=9; idConsorcio++){
			List<ParadaComentada> consorcio = new ArrayList<ParadaComentada>();
			cr = new ConsorcioResource();
			ParadasDatos partialParadas=cr.getParadasConsorcio(Integer.toString(idConsorcio));
			for (ParadaDatos p : partialParadas.getParadas()){
				consorcio.add(new ParadaComentada(p));
			}
			ComentariosResource.paradas.add(consorcio);
		}
		for(List<ParadaComentada> p : paradas){
			for(ParadaComentada q : p){
				q.addComentario(new Comentario(comentarios.get(r.nextInt(comentarios.size()))));
				q.addComentario(new Comentario(comentarios.get(r.nextInt(comentarios.size()))));
				q.addComentario(new Comentario(comentarios.get(r.nextInt(comentarios.size()))));
			}
		}
	}
	
	public static ComentariosResource getInstance()
	{
		if(_instance==null)
				_instance=new ComentariosResource();
		return _instance;
	}
	

	@GET
	@Path("/{paradaId}")
	@Produces("application/json")
	public ParadaComentada getParada(@PathParam("paradaId") String paradaId)
	{
		for(List<ParadaComentada> l : paradas){
			for(ParadaComentada p : l){
				if(p.getIdParada().equals(paradaId))
					return p;
			}
		}
		throw new NotFoundException("No se encontró ninguna parada con ID: "+paradaId);
	}
	
	@GET
	@Produces("application/json")
	public Collection<ParadaComentada> getAll()
	{
		return paradas.get(0);
	}
	
	private static int indexParada(List<List<ParadaComentada>> lista, String id){
		for (List<ParadaComentada> l : lista){
			for(ParadaComentada p : l){
				if(p.getIdParada().equals(id)){
					return lista.indexOf(l);
				}
			}
		}
		return -1;
	}
	
	@POST
	@Path("/{paradaId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addComentario(@Context UriInfo uriInfo,@PathParam("paradaId") String paradaId, Comentario comentario){
		int i = indexParada(paradas,paradaId);
		if(i==-1){
			throw new NotFoundException("No se encontró la parada con esta ID=" + paradaId);
		}
		ParadaComentada ans = null;
		for(ParadaComentada p : paradas.get(i)){
			if (p.getIdParada().equals(paradaId)){
				p.addComentario(comentario);
				ans=p;
				System.out.println(p);
			}
		}
		/*UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(comentario.getIdComentario());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(comentario);			
		return resp.build();*/
		return Response.status(201).entity(ans).build();
			
	}
	
}
