package aiss.api.resources;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/lists")
public class PlaylistResource {
	
	/* Singleton */
	private static PlaylistResource _instance=null;
	
	private PlaylistResource() {
		
	}
	
	public static PlaylistResource getInstance()
	{
		if(_instance==null)
				_instance=new PlaylistResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<String> getAll()
	{
		ArrayList<String> ans = new ArrayList<String>();
		ans.add("Hello :D");
		return ans;
	}
}
