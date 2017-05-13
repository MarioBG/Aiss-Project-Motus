package aiss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.consorcio.ParadaDatos;
import aiss.model.resource.ConsorcioResource;

public class ConsorcioParadaController {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String idConsorcio = req.getParameter("idConsorcio");
		String idParada = req.getParameter("idParada");
		ConsorcioResource consorcioResource=new ConsorcioResource();
		ParadaDatos parada=consorcioResource.getParada(idConsorcio,idParada);
		req.setAttribute("parada", parada);
		req.getRequestDispatcher("/Parada.jsp").forward(req,resp);
	
}

public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	doGet(req,resp);
}
}
