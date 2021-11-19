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
<link rel="stylesheet" href="/Projet/page2.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%Administrateur admin=(Administrateur)session.getAttribute("admin"); 
AdministrateurDAO ad=new AdministrateurDAO();
%>
<% if(ad.consulterMesProjets(admin.getIdutilisateur()).isEmpty()){
	%><div class="estvide"><h1>Aucun projet dans la liste</h1></div><% 
}else{%>
<div class="les_docs"> 
<table>
<caption><h1>Planning général</h1></caption>
<%for(Projet projet:ad.consulterMesProjets(admin.getIdutilisateur())){ 
%>
<tr>

<td><%=projet.getTitreProjet()%></td>

<td><a href="/Projet/planning.jsp?idprojet=<%=projet.getIdProjet()%>">Planning du Projet</a></td>

</tr>

<%}}%>

</table>
</div>
</body>
</html>