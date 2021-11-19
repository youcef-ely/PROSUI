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

import com.projet.Projet;
import com.utilisateurs.ChefDeProjet;
import com.utilisateurs.ChefDeProjetDAO;

/**
 * Servlet implementation class Ajouterdoc
 */
@WebServlet("/Ajouterdoc")
public class Ajouterdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChefDeProjetDAO c = new ChefDeProjetDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouterdoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef");
			byte[] fileupload = null;
			String fileName = null;
			String descriptiondoc = null;
			
			
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
							case "descriptiondoc":
								descriptiondoc = value;
								break;
							
							default:
								break;
							}
	                    }
	                }
	            } catch (Exception ex) {
	               
	            }         		
	        }
	       
	       
	       
	       
		   
		   Projet p = c.monprojet(chef.getIdutilisateur());
		  
	       int i = c.ajouterdoc(descriptiondoc, fileupload, fileName,p.getIdProjet());
		
			
		
			if(i>0) {
			response.sendRedirect("/Projet/mesdocuments.jsp");
			}
	}
		
	}


