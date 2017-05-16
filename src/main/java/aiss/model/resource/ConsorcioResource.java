package aiss.model.resource;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.consorcio.Consorcio;
import aiss.model.consorcio.Municipio;
import aiss.model.consorcio.Nucleo;
import aiss.model.consorcio.ParadaDatos;
import aiss.model.consorcio.Paradas;
import aiss.model.consorcio.ParadasDatos;

public class ConsorcioResource {
	//uri para obtener la lista de consorcios
	private String uri = "http://api.ctan.es/v1/Consorcios/consorcios";
	private String uri2 = "http://api.ctan.es/v1/Consorcios/";
	private static ConsorcioResource _instance=null;
	//private String uri3 = "http://api.ctan.es/v1/Consorcios/:idConsorcio/nucleos";

	
	public Collection<Consorcio> getConsorcios() {
		ClientResource cr = null;
		Consorcio [] consorcios = null;
		try {
			cr = new ClientResource(uri);
			consorcios = cr.get(Consorcio[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener los consorcios: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(consorcios);
	}
	
	public static ConsorcioResource getInstance()
	{
		if(_instance==null)
				_instance=new ConsorcioResource();
		return _instance;
	}
	
	public Collection<Municipio> getMunicipios(String idConsorcio) {
		ClientResource cr = null;
		Municipio[] municipios = null;
		try {
			cr = new ClientResource(uri2 + idConsorcio + "/municipios");
			municipios = cr.get(Municipio[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener los municipios: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(municipios);
	}
	
	public Collection<Nucleo> getNucleos(String idNucleo) {
		ClientResource cr = null;
		Nucleo[] nucleos = null;
		try {
			cr = new ClientResource(uri2 + idNucleo + "/nucleos");
			nucleos = cr.get(Nucleo[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener los municipios: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(nucleos);
	}
	
	public Paradas getParadas(String idConsorcio, String idMunicipio, String idNucleo) {
		ClientResource cr = null;
		Paradas paradas = null;
	
		try {
			cr = new ClientResource(uri2 + idConsorcio + "/municipios/" + idMunicipio + "/nucleos/" + idNucleo + "/paradas");
			paradas = cr.get(Paradas.class);
			
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener las paradas: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return paradas;
	}
	
	//uri2 + "/:idConsorcio/paradas/:idParada"
	public ParadaDatos getParada(String idConsorcio, String idParada){
		ClientResource cr = null;
		ParadaDatos parada = null;
		try {
			cr = new ClientResource(uri + idConsorcio + "/paradas" + idParada);
			parada = cr.get(ParadaDatos.class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener los datos de la parada: " + cr.getResponse().getStatus());
			throw re;
		}
		return parada;
	
	}
	
	public ParadasDatos getParadasConsorcio(String idConsorcio) {
	    ClientResource cr = null;
	    ParadasDatos paradas = null;
	  
	    try {
	      cr = new ClientResource(uri2 + idConsorcio + "/paradas/");
	      paradas = cr.get(ParadasDatos.class);
	      
	      
	    } catch (ResourceException re) {
	      System.err.println("Error al obtener las paradas: " + cr.getResponse().getStatus());
	      throw re;
	    }
	    
	    return paradas;
	  }
	
}
