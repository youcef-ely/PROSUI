package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projet.Projet;
import com.utilisateurs.ChefDeProjet;
import com.utilisateurs.ChefDeProjetDAO;

/**
 * Servlet implementation class Ajoutertache
 */
@WebServlet("/Ajoutertache")
public class Ajoutertache extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChefDeProjetDAO c = new ChefDeProjetDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajoutertache() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef");
		String tache= request.getParameter("tache");
		String debut= request.getParameter("datedebut");
		String fin= request.getParameter("datefin");
	    Projet p = c.monprojet(chef.getIdutilisateur());
	    int i = c.ajoutertache(tache,debut,fin, p.getIdProjet());
	    if(i>0) {
	    	response.sendRedirect("/Projet/ajoutertache.jsp");
	    }
	}

}
