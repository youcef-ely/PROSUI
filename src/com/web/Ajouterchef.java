package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utilisateurs.Administrateur;
import com.utilisateurs.AdministrateurDAO;

/**
 * Servlet implementation class Ajouterchef
 */
@WebServlet("/Ajouterchef")
public class Ajouterchef extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AdministrateurDAO ad = new AdministrateurDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouterchef() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Administrateur admin = (Administrateur)session.getAttribute("admin");
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email= request.getParameter("email");
		long tel = Long.parseLong(request.getParameter("tel"));
		String mdp = request.getParameter("password");
		
		int i= ad.ajouterCDP(nom, prenom, email, tel, mdp, admin.getIdutilisateur());
		if(i>0) {
			response.sendRedirect("/Projet/consulterchefs.jsp");
		}
	}

}
