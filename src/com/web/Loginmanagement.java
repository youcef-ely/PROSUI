package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utilisateurs.Administrateur;
import com.utilisateurs.AdministrateurDAO;

/**
 * Servlet implementation class Loginmanagement
 */
@WebServlet("/Loginmanagement")
public class Loginmanagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdministrateurDAO ad = new AdministrateurDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginmanagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("motdepasse");
		long tel = Long.parseLong(request.getParameter("telephone"));
		String date = request.getParameter("date");
		
		int i = ad.creerCompte(nom, prenom, email, tel, password);
		if(i>0) {
		response.sendRedirect("/Projet/espaceadmin.jsp");
		}
	}

}
