<%@page import="com.utilisateurs.ChefDeProjetDAO"%>
<%@page import="com.projet.Projet"%>
<%@page import="com.utilisateurs.AdministrateurDAO"%>
<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/Projet/page2.css"/>
</head>
<body>
<jsp:include page="headerchef.jsp"></jsp:include>
<%ChefDeProjet chef=(ChefDeProjet)session.getAttribute("chef"); 
ChefDeProjetDAO c= new ChefDeProjetDAO();
%>
<% if(c.monprojet(chef.getIdutilisateur()) == null){
	%><div class="estvide"><h1>Vous n'avez aucun projet</h1></div><% 
}else{%>
<div class="monprojet"> 
<table>
<caption><h1>Mon Projet</h1></caption>
<tr><th>Id Projet</th><th>Titre</th><th>Type</th><th>Description</th><th>Etat</th><th>Date limite</th></tr>
<% Projet projet = c.monprojet(chef.getIdutilisateur()); %>
<tr>
<td><%=projet.getIdProjet()%></td>
<td><%=projet.getTitreProjet()%></td>
<td><%=projet.getTypeProjet()%></td>

<td> <a href="telechargementfichier?file=<%=projet.getIdProjet()%>" target="_top">Télécharger</a>
    </td>

<td><%=projet.getEtatProjet()%></td>
<td><%=projet.getDatelimite()%></td>

<%} %>

</tr>
<tr></tr>



</table>
</div>
</body>
</html>