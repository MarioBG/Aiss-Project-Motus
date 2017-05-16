package aiss.api.resources;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.consorcio.Parada;
import aiss.model.consorcio.Paradas;


@Path("/comentarios")
public class ComentariosResource {
	
	private static ComentariosResource _instance=null;
	private static List<String> comentarios = new ArrayList<String>();
	private static List<List<ParadaComentada>> paradas = new ArrayList<List<ParadaComentada>>();
	private static String uri2 = "http://api.ctan.es/v1/Consorcios/";
	
	
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
		ClientResource cr = null;
		Paradas partialParadas = null;
		Random r = new Random();
		for(int idConsorcio=1; idConsorcio<=9; idConsorcio++){
			List<ParadaComentada> consorcio = new ArrayList<ParadaComentada>();
			try {
				cr = new ClientResource(uri2 + idConsorcio + "/paradas/");
				partialParadas = cr.get(Paradas.class);
				for (Parada p : partialParadas.getParadas()){
					consorcio.add(new ParadaComentada(p));
				}
				paradas.add(consorcio);
			} catch (ResourceException re) {
				System.err.println("Error al obtener las paradas: " + cr.getResponse().getStatus());
				throw re;
			}
		}
		for(List<ParadaComentada> p : paradas){
			for(ParadaComentada q : p){
				q.addComentario(comentarios.get(r.nextInt(comentarios.size())));
				q.addComentario(comentarios.get(r.nextInt(comentarios.size())));
				q.addComentario(comentarios.get(r.nextInt(comentarios.size())));
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
	@Produces("application/json")
	public Collection<ParadaComentada> getAll()
	{
		return paradas.get(0);
	}
}
