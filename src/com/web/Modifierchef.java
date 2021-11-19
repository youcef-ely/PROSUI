package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projet.Projet;
import com.utilisateurs.Administrateur;
import com.utilisateurs.AdministrateurDAO;
import com.utilisateurs.ChefDeProjet;

/**
 * Servlet implementation class Modifierchef
 */
@WebServlet("/Modifierchef")
public class Modifierchef extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AdministrateurDAO ad=new AdministrateurDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifierchef() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrateur a = (Administrateur) session.getAttribute("admin");
		int id=Integer.parseInt(request.getParameter("id"));
		ChefDeProjet chef=ad.findchef(id);
		request.setAttribute("chef", chef);
		this.getServletContext().getRequestDispatcher("/modifierchef.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Administrateur admin = (Administrateur)session.getAttribute("admin");
		int idchef=Integer.parseInt(request.getParameter("idchef"));
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email= request.getParameter("email");
		long tel = Long.parseLong(request.getParameter("tel"));
		String mdp = request.getParameter("password");
		ChefDeProjet chef=new ChefDeProjet(idchef, nom, prenom, email, tel, mdp);
		int i=ad.modifierCDP(chef);
		if(i>0) {
			response.sendRedirect("/Projet/consulterchefs.jsp");
		}
	}
	}


