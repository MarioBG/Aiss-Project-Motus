package aiss.controller;

import java.io.IOException;


import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.drive.Files;
import aiss.model.resource.GoogleDriveResource;

public class DriveSaveController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DriveSaveController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
		String origen = req.getParameter("origen");
		String destino= req.getParameter("destino");
		String content= origen +","+ destino;
		if(accessToken!=null && !"".equals(accessToken)){
			GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
			Files files=gdResource.getFiles();
			if(files!=null){
				req.setAttribute("content", content);
				req.setAttribute("files", files);
				req.getRequestDispatcher("/GoogleDriveSave.jsp").forward(req,resp);
			}else{
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
			}
		}else{
			log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}
