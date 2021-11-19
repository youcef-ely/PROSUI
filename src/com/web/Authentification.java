package com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utilisateurs.Administrateur;
import com.utilisateurs.AdministrateurDAO;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdministrateurDAO ad;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        ad = new AdministrateurDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gmail = request.getParameter("gmail");
		String password = request.getParameter("password");
		String msg;
		Administrateur a = ad.seconnecter(gmail, password);
		
        if(a != null) {
        	HttpSession session	= request.getSession(true);
        	session.setAttribute("admin",a);
        	session.setAttribute("id", a.getIdutilisateur());
        	session.setAttribute("nom", a.getNom());
        	session.setAttribute("prenom", a.getPrenom());
        	session.setAttribute("email", a.getEmail());
        	session.setAttribute("telephone", a.getTelephone());
        	response.sendRedirect("/Projet/espaceadmin.jsp");
        	
        }else 
        	response.sendRedirect("/Projet/adminauthentif.jsp");		
  	}
}

