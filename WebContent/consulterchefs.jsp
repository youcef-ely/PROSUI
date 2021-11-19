<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@page import="com.utilisateurs.AdministrateurDAO"%>
<%@page import="com.utilisateurs.Administrateur"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/Projet/page.css"/>


</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%Administrateur admin = (Administrateur) session.getAttribute("admin");
AdministrateurDAO ad = new AdministrateurDAO();%>


<%if (ad.consulterCDPs(admin.getIdutilisateur()).isEmpty()){
%>
<div class="estvide"><h1>Aucun chef dans la liste.</h1></div>
<%} else {%>
<div class="les_chefs">
<table>
<caption><h1>Liste des chefs</h1></caption>
<tr><th>Id Chef</th><th>Nom</th><th>Prénom</th><th>Email</th><th>Téléphone</th><th>Date d'inscription </th><th>Id admin</th></tr>
<% for(ChefDeProjet chef : ad.consulterCDPs(admin.getIdutilisateur())){
%>
<tr>
<td><%=chef.getIdutilisateur()%></td>
<td><%=chef.getNom() %></td>
<td><%=chef.getPrenom() %></td>
<td><%=chef.getEmail() %></td>
<td><%=chef.getTelephone() %></td>
<td><%=chef.getDateinscription() %></td>
<td><%=chef.getIdAdmin() %></td>
<td class="gestion"><a href="Modifierchef?id=<%=chef.getIdutilisateur()%>">Modifier</a></td>
<td class="gestion"><a href="Supprimerchef?id=<%=chef.getIdutilisateur()%>">Supprimer</a></td>
</tr>
<%	
}}	
%>
</table>
</div>
</body>
</html>