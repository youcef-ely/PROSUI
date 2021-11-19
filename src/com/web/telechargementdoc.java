package com.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.Document;
import com.utilisateurs.ChefDeProjetDAO;

/**
 * Servlet implementation class telechargementdoc
 */
@WebServlet("/telechargementdoc")
public class telechargementdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ChefDeProjetDAO ch=new ChefDeProjetDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public telechargementdoc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iddoc = Integer.parseInt(request.getParameter("file"));
		Document document =ch.finddocument(iddoc);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String gurufile = "securité.jpg";
		String gurupath = "C:\\Users\\Yassine\\AppData\\Local\\Temp\\";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ document.getFilename() + "\"");
		InputStream bis = new ByteArrayInputStream(document.getDocument());
		int i;
		while ((i = bis.read()) != -1) {
			out.write(i);
		}
		bis.close();
		out.close();
	}

}
