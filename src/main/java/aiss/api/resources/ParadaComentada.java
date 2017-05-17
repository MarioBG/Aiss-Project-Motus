package aiss.api.resources;

import java.util.ArrayList;
import java.util.List;

import aiss.model.consorcio.ParadaDatos;

public class ParadaComentada extends ParadaDatos {
	
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
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
	public ParadaComentada(ParadaDatos parada){
		super();
		setIdParada(parada.getIdParada());
		setIdNucleo(parada.getIdNucleo());
		setIdZona(parada.getIdZona());
		setNombre(parada.getNombre());
	}
	
	public void addComentario(Comentario comentario){
		comentarios.add(comentario);
	}
	
	public boolean removeComentario(String com){
		return comentarios.remove(com);
	}
	
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
	@Override
	public String toString() {
		return getNombre()+" [" + comentarios + "]";
	}

}
