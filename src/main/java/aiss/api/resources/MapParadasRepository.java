package aiss.api.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.consorcio.Parada;


public class MapParadasRepository implements ParadasRepository{

	Map<String, Parada> paradaMap;
	private static MapParadasRepository instance=null;
	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapParadasRepository getInstance() {
		
		if (instance==null) {
			instance = new MapParadasRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		paradaMap = new HashMap<String,Parada>();
		
		// Create songs
		Parada p1=new Parada();
		p1.setNombre("Plaza Mayor");
		p1.setIdNucleo("23");
		p1.setIdParada("1");
		p1.setIdZona("1");
		addParada(p1);
		
		Parada p2=new Parada();
		p2.setNombre("Calle Ancha");
		p2.setIdNucleo("11");
		p2.setIdParada("2");
		p2.setIdZona("3");
		addParada(p2);
		
		Parada p3=new Parada();
		p3.setNombre("Avenida de la Constitución");
		p3.setIdNucleo("44");
		p3.setIdParada("3");
		p3.setIdZona("2");
		addParada(p3);
	}
	
	// Playlist related operations
	@Override
	public void addParada(Parada p) {
		String id = "p" + index++;	
		p.setIdParada(id);
		paradaMap.put(id,p);
	}
	
	@Override
	public Collection<Parada> getAllParadas() {
			return paradaMap.values();
	}

	@Override
	public Parada getParada(String id) {
		return paradaMap.get(id);
	}
	
	@Override
	public void updateParada(Parada p) {
		paradaMap.put(p.getIdParada(),p);
	}

	@Override
	public void deleteParada(String id) {	
		paradaMap.remove(id);
	}
}
