package aiss.controller;

import java.io.IOException;

import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.drive.FileItem;
import aiss.model.resource.GoogleDriveResource;

public class DriveFileNew extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DriveFileDelete.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {	
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			String title=req.getParameter("title");
			String content=req.getParameter("content");			
			if(accessToken!=null && !"".equals(accessToken)){
				if(title!=null && !"".equals(title)){
					GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
					FileItem file = new FileItem();
					file.setTitle(title);
					file.setMimeType("text/plain");
					gdResource.insertFile(file, content);
					req.setAttribute("message", "File '"+title+"' added to your Drive!");
					req.getRequestDispatcher("/interfaz.jsp").forward(req,resp);
				}else{
					req.setAttribute("message", "You must provide a valid title for file");
					req.setAttribute("content", content);
					req.getRequestDispatcher("GoogleDriveSave.jsp").forward(req,resp);
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
