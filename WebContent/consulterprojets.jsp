<%@page import="com.projet.Projet"%>
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
<%Administrateur admin=(Administrateur)session.getAttribute("admin"); 
AdministrateurDAO ad=new AdministrateurDAO();
%>
<% if(ad.consulterMesProjets(admin.getIdutilisateur()).isEmpty()){
	%><div class="estvide"><h1>Aucun projet dans la liste</h1></div><% 
}else{%>
<div class="les_chefs"> 
<table>
<caption><h1>Liste des Projets</h1></caption>
<tr><th>Id Projet</th><th>Titre</th><th>Type</th><th>Description</th><th>Etat</th><th>Date limite</th><th>Id chef</th></tr>
<%for(Projet projet:ad.consulterMesProjets(admin.getIdutilisateur())){ 
%>
<tr>
<td><%=projet.getIdProjet()%></td>
<td><%=projet.getTitreProjet()%></td>
<td><%=projet.getTypeProjet()%></td>

<td> <a href="telechargementfichier?file=<%=projet.getIdProjet()%>" target="_top">Télécharger</a>
    </td>

<td><%=projet.getEtatProjet()%></td>
<td><%= projet.getDatelimite()%></td>
<td><%= projet.getIdCDP()%></td>
<td><a href="/Projet/lesdocuments.jsp?idprojet=<%=projet.getIdProjet()%>">Liste des Documents</a></td>
<td><a href="Modifierprojet?id=<%=projet.getIdProjet()%>">Modifier</a></td>
<td><a href="Supprimerprojet?id=<%=projet.getIdProjet()%>">Supprimer</a></td>
</tr>

<%}}%>

</table>
</div>
</body>
</html>