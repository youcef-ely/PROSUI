package com.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utilisateurs.ChefDeProjet;
import com.utilisateurs.ChefDeProjetDAO;

/**
 * Servlet implementation class AuthentificationCHEF
 */
@WebServlet("/AuthentificationCHEF")
public class AuthentificationCHEF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChefDeProjetDAO cdp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationCHEF() {
        super();
        cdp = new ChefDeProjetDAO();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		String gmail = request.getParameter("gmail");
		String password = request.getParameter("password");
		ChefDeProjet chef = cdp.seconnecter(gmail, password);
        if(chef != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("chef", chef);
        	response.sendRedirect("/Projet/espacechef.jsp");
        }else
        	response.sendRedirect("/Projet/cdpauthentif.jsp");
        
	}

}
