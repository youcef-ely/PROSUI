package com.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projet.Projet;
import com.utilisateurs.AdministrateurDAO;

/**
 * Servlet implementation class telechargementfichier
 */
@WebServlet("/telechargementfichier")
public class telechargementfichier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AdministrateurDAO ad=new AdministrateurDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public telechargementfichier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
		int idProjet = Integer.parseInt(request.getParameter("file"));
		Projet projet =ad.findprojet(idProjet);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String gurufile = "securité.jpg";
		String gurupath = "C:\\Users\\Yassine\\AppData\\Local\\Temp\\";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""+ projet.getFilename() + "\"");

		InputStream bis = new ByteArrayInputStream(projet.getDescriptionProjet());
		
		int i;
		while ((i = bis.read()) != -1) {
			out.write(i);
		}
		bis.close();
		out.close();
}
}
