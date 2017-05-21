package aiss.api.resources;

import java.util.Collection;

import aiss.model.consorcio.Parada;

public interface ParadasRepository {
	
	
	// Songs
	public void addParada(Parada s);
	public Collection<Parada> getAllParadas();
	public Parada getParada(String paradaId);
	public void updateParada(Parada s);
	public void deleteParada(String paradaId);

}
