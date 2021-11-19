package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utilisateurs.AdministrateurDAO;


/**
 * Servlet implementation class Creercompteadmin
 */
@WebServlet("/Creercompteadmin")
public class Creercompteadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AdministrateurDAO ad = new AdministrateurDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Creercompteadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String email= request.getParameter("email");
		long tel = Long.parseLong(request.getParameter("tel"));
		String mdp = request.getParameter("password");
		int i = ad.creerCompte(nom, prenom, email, tel, mdp);
		if(i>0) {
			response.sendRedirect("/Projet/adminauthentif.jsp");
		}
	}
	
	

}
