package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projet.Planning;
import com.utilisateurs.ChefDeProjet;
import com.utilisateurs.ChefDeProjetDAO;

/**
 * Servlet implementation class Modifiertache
 */
@WebServlet("/Modifiertache")
public class Modifiertache extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChefDeProjetDAO ch = new ChefDeProjetDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifiertache() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef");
		int idtache= Integer.parseInt(request.getParameter("idtache"));
		Planning p = ch.findtache(idtache);
		request.setAttribute("planning", p);
		this.getServletContext().getRequestDispatcher("/modifiertache.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef");
		String nvtache = request.getParameter("tache");
		String datedebut = request.getParameter("datedebut");
		String datefin = request.getParameter("datefin");

		int idtache = Integer.parseInt(request.getParameter("idtache"));
		int i = ch.modifiertache(idtache, nvtache,datedebut,datefin);
		if(i>0) {
			response.sendRedirect("/Projet/planningconcerne.jsp");
		}
	}

}