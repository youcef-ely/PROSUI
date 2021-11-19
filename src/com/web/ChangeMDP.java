package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utilisateurs.ChefDeProjet;
import com.utilisateurs.ChefDeProjetDAO;
import com.utilisateurs.AdministrateurDAO;
import com.utilisateurs.ChefDeProjet;

/**
 * Servlet implementation class ChangeMDP
 */
@WebServlet("/ChangeMDP")
public class ChangeMDP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMDP() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef");
		ChefDeProjetDAO cdp = new ChefDeProjetDAO();
		String nvmdp = request.getParameter("passwordchef");
		int i = cdp.modifierchef(chef.getIdutilisateur(), nvmdp);
		if(i > 0) {
			session.invalidate();
			response.sendRedirect("/Projet/cdpauthentif.jsp");
		}
	}

}
