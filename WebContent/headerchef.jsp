<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/Projet/page.css"/>
<title>Insert title here</title>

</head>
<body>

<%if(session.getAttribute("chef") == null)
        	{ 
        		response.sendRedirect("/Projet/cdpauthentif.jsp");
        	}
        	else {
        		ChefDeProjet user = (ChefDeProjet) session.getAttribute("chef");
      %>
        		
<header class="header">
<div class="logo">
<h1>PRO<span>SUI</span></h1> 
</div>
<ul class="navigation">
<li><img src="/Projet/lesimages/home.png" class="homeimg"><a href="/Projet/espacechef.jsp">Accueil</a></li>
<li><img src="/Projet/lesimages/profil.png" class="headerimg"><a href="/Projet/monprofilchef.jsp"><%=user.getNom() %> <%=user.getPrenom()%></a></li>
<li><img src="/Projet/lesimages/image1.png" class="headerimg"><a href="Deconnexion">Déconnexion</a></li> 
</ul>
</header>
<%}%>
</body>
</html>