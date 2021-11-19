<%@page import="com.utilisateurs.AdministrateurDAO"%>
<%@page import="com.utilisateurs.Administrateur"%>
<%@page import="com.projet.Document"%>
<%@page import="com.projet.Projet"%>
<%@page import="com.projet.Planning"%>
<%@page import="com.utilisateurs.ChefDeProjetDAO"%>
<%@page import="com.utilisateurs.ChefDeProjet"%>
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
<jsp:include page="header.jsp"></jsp:include>
<%Administrateur admin = (Administrateur) session.getAttribute("admin");
AdministrateurDAO ad = new AdministrateurDAO();
int id = Integer.parseInt(request.getParameter("idprojet"));

%>
<% if(ad.consulterplanning(id).isEmpty()){
	%><div class="estvide"><h1>Aucun planning pour ce projet</h1></div><% 
}else{%>
<div class="tache" style="width=:80%;"> 
<table>
<caption><h1>Planning de projet</h1></caption>

<tr class="tache" style="width:10%;"><th>Tâche</th><th>Date début</th><th>Date fin</th></tr>
<%for(Planning  p: ad.consulterplanning(id)){ 
%>
<tr>
<td><%=p.getTache()%></td>
<td> <%=p.getDatedebut()%></td>
<td> <%=p.getDatefin()%></td>





</tr>

<%}}%>

</table>
</div>
</body>
</html>