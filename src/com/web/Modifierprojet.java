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
import com.utilisateurs.Administrateur;
import com.utilisateurs.AdministrateurDAO;
import com.utilisateurs.ChefDeProjet;

/**
 * Servlet implementation class Modifierprojet
 */
@WebServlet("/Modifierprojet")
public class Modifierprojet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AdministrateurDAO ad=new AdministrateurDAO();
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifierprojet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("admin");
		int id=Integer.parseInt(request.getParameter("id"));
		Projet projet=ad.findprojet(id);
		request.setAttribute("projet", projet);
		this.getServletContext().getRequestDispatcher("/modifierprojet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrateur admin = (Administrateur) session.getAttribute("admin");
		Projet projet=(Projet)session.getAttribute("projet");
		byte[] fileupload = null;
		int idprojet=0;
		String titre =null;
		String type = null;
		String fileName = null;
		String etat = null;
		String datelimite = null;
		String chef = null;
		int idcdp = 0;
       if(ServletFileUpload.isMultipartContent(request)){
            try {
                List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                    	fileName = item.getName();
                    	fileupload = IOUtils.toByteArray(item.getInputStream());	                    		                    	
                    } else {
                    	String name = item.getFieldName();
                        String value = item.getString();
                        
                        switch (name) {
                        case "idprojet":
                        	idprojet=Integer.parseInt(value);
                        	break;
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
	
       
	
		if(chef!=null ) { //si nom et prenom non vides
			String[] option = chef.split(" ");
			String Nom_Chef = option[0]; 
			String Prenom_Chef = option[1]; 
			ChefDeProjet c = ad.consuletrCDPparnom(Nom_Chef, Prenom_Chef);
			idcdp=c.getIdutilisateur();
		}else {
			idcdp=projet.getIdCDP();
		}
		if(etat ==null)
			etat=projet.getEtatProjet();
		
		
		
		projet=new Projet(idprojet,titre, type, fileupload, etat, datelimite,idcdp,fileName);
		ad.modifierProjet(projet);
		
			response.sendRedirect("/Projet/consulterprojets.jsp");
	}
	}