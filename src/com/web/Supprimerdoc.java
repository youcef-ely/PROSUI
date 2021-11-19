package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utilisateurs.ChefDeProjetDAO;

/**
 * Servlet implementation class Supprimerdoc
 */
@WebServlet("/Supprimerdoc")
public class Supprimerdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChefDeProjetDAO ch = new ChefDeProjetDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimerdoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("iddoc"));
		int i = ch.supprimerdoc(id);
		if(i>0) {
			response.sendRedirect("/Projet/mesdocuments.jsp");
		}
		
		
	}

	
	
}
