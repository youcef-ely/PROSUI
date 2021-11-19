<%@page import="com.projet.Planning"%>
<%@page import="com.utilisateurs.ChefDeProjetDAO"%>
<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@page import="com.utilisateurs.AdministrateurDAO"%>
<%@page import="com.utilisateurs.Administrateur"%>
<%@page import="com.projet.Projet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/Projet/tache.css"/>


</head>
<body>
<jsp:include page="headerchef.jsp"></jsp:include>

<%ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef");
ChefDeProjetDAO ch = new ChefDeProjetDAO();
Projet p = ch.monprojet(chef.getIdutilisateur());%>


<%if (ch.monprojet(chef.getIdutilisateur())==null){
%>
<div class="estvide"><h1>Vous n'avez aucun projet.</h1></div>
<%} else if (ch.consultermonplanning(p.getIdProjet()).isEmpty()){%>
<div class="estvide"><h1>Aucune tâche dans la liste.</h1></div><%}
else {%>

<div class="tache">
<table>
<caption><h1>Planning du projet</h1></caption>
<tr><th>Tâche</td><th>Date début</th><th>Date fin</th></tr>

<% for(Planning pl : ch.consultermonplanning(p.getIdProjet())){
%>
<tr>
<td style="width:30%;"> <%=pl.getTache()%></td>
<td><%=pl.getDatedebut()%></td>
<td><%=pl.getDatefin()%></td>


<td class="gestion"><a href="Modifiertache?idtache=<%=pl.getIdtache()%>">Modifier</a></td>
<td class="gestion"><a href="Supprimertache?idtache=<%=pl.getIdtache()%>">Supprimer</a></td>
</tr>
<%	
}}	
%>
</table>
</div>
</body>
</html>