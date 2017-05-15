package aiss.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

public class ComentariosResource {
	
	private static ComentariosResource _instance=null;

	public ComentariosResource() {
		// TODO Auto-generated constructor stub
	}
	
	public static ComentariosResource getInstance()
	{
		if(_instance==null)
				_instance=new ComentariosResource();
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<String> getAll()
	{
		List<String> ans = new ArrayList<String>();
		ans.add("Tata :D");
		return ans;
	}
	
}
