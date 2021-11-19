package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.utilisateurs.Administrateur;
import com.utilisateurs.AdministrateurDAO;
import com.utilisateurs.ChefDeProjet;

/**
 * Servlet implementation class Ajouterprojet
 */
@WebServlet("/Ajouterprojet")
public class Ajouterprojet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdministrateurDAO ad = new AdministrateurDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ajouterprojet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrateur admin = (Administrateur) session.getAttribute("admin");
			byte[] fileupload = null;
			String fileName = null;
			String titre =null;
			String type = null;
			String etat = null;
			String datelimite =null;
			 String chef =null;
	       if(ServletFileUpload.isMultipartContent(request)){
	            try {
	                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	                for(FileItem item : multiparts){
	                    if(!item.isFormField()){
	                    	fileName = item.getName();
	                    	fileupload = IOUtils.toByteArray(item.getInputStream());	                    		                    	
	                    } else {
	                    	String name = item.getFieldName();//text1
	                        String value = item.getString();
	                        switch (name) {
							case "titre":
								titre = value;
								break;
							case "type":
								type = value;
								break;
							case "etat":
								etat = value;
								break;
							case "datelimite":
								datelimite = value;
								break;
							case "chef":
								chef = value;
								break;
							default:
								break;
							}
	                    }
	                }
	            } catch (Exception ex) {
	               
	            }         		
	        }
		
	       
	
		int i;
		
			String[] option = chef.split(" ");
			String opt1 = option[0]; 
			String opt2 = option[1]; 
			ChefDeProjet c = ad.consuletrCDPparnom(opt1, opt2);
		i=ad.ajouterProjet(titre, type, fileupload,fileName, etat, datelimite,c.getIdutilisateur(), admin.getIdutilisateur());
			if(i>0) {
			response.sendRedirect("/Projet/consulterprojets.jsp");
			}
	}
	}
			
