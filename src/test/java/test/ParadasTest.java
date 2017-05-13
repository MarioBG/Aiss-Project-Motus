package test;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import aiss.model.consorcio.Paradas;
import aiss.model.resource.ConsorcioResource;

public class ParadasTest {
@Test
	public void testParadas() throws Exception{
		ConsorcioResource consorcioResource=new ConsorcioResource();
		Paradas paradas = consorcioResource.getParadas("7","1","1");
		assertNotNull("The list of paradas is null",paradas);
		System.out.println(paradas.getParadas().toString());
	}

}
