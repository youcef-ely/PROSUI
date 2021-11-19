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
 * Servlet implementation class Updatecompte
 */
@WebServlet("/Updatecompte")
public class Updatecompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatecompte() {
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
		Administrateur a = (Administrateur) session.getAttribute("admin");
		AdministrateurDAO ad = new AdministrateurDAO();
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email= request.getParameter("email");
		long tel = Long.parseLong(request.getParameter("tel"));
		String mdp = request.getParameter("password");
		Administrateur nvad = new Administrateur(nom, prenom, email, tel, mdp);
		int i = ad.mettreajour(a.getIdutilisateur(), nvad);
		if(i>0) {
			session.invalidate();
			response.sendRedirect("/Projet/adminauthentif.jsp");
		}
	}

}
