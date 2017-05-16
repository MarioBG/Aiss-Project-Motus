package aiss.api.resources;

import java.util.ArrayList;
import java.util.List;

import aiss.model.consorcio.Parada;

public class ParadaComentada extends Parada {
	
	private List<String> comentarios = new ArrayList<String>();
	
	public ParadaComentada(){
		super();
	}
	
	public ParadaComentada(String idParada, String idNucleo, String idZona, String nombre){
		super();
		this.setIdParada(idParada);
		setIdNucleo(idNucleo);
		setIdZona(idZona);
		setNombre(nombre);
	}
	public ParadaComentada(Parada parada){
		super();
		setIdParada(parada.getIdParada());
		setIdNucleo(parada.getIdNucleo());
		setIdZona(parada.getIdZona());
		setNombre(parada.getNombre());
	}
	
	public void addComentario(String com){
		comentarios.add(com);
	}
	
	public boolean removeComentario(String com){
		return comentarios.remove(com);
	}
	
	public List<String> getComentarios(){
		return comentarios;
	}
	
	@Override
	public String toString() {
		return getNombre()+" [" + comentarios + "]";
	}

}
