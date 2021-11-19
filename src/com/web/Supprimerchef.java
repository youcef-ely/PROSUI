package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utilisateurs.AdministrateurDAO;

/**
 * Servlet implementation class Supprimerchef
 */
@WebServlet("/Supprimerchef")
public class Supprimerchef extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdministrateurDAO ad = new AdministrateurDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimerchef() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ad.supprimerCDP(id);
		response.sendRedirect("/Projet/consulterchefs.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
