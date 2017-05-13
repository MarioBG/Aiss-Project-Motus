package aiss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.consorcio.Paradas;
import aiss.model.resource.ConsorcioResource;



public class ConsorcioListController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			
		String idConsorcio = req.getParameter("idConsorcio");
			String idMunicipio = req.getParameter("idMunicipio");
			String idNucleo = req.getParameter("idNucleo");
			ConsorcioResource consorcioResource=new ConsorcioResource();
			Paradas paradas=consorcioResource.getParadas(idConsorcio,idMunicipio, idNucleo);
			req.setAttribute("paradas", paradas.getParadas());
			req.getRequestDispatcher("/ConsorcioParadas.jsp").forward(req,resp);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}