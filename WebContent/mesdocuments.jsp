<%@page import="com.projet.Document"%>
<%@page import="com.projet.Projet"%>
<%@page import="com.utilisateurs.ChefDeProjetDAO"%>
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
ChefDeProjetDAO cdp = new ChefDeProjetDAO();
Projet p = cdp.monprojet(chef.getIdutilisateur());
%>



<% if (cdp.monprojet(chef.getIdutilisateur())==null){ %>
<div class="estvide"><h1>Vous n'avez aucun projet</h1></div><%}
else if(cdp.consulterdocs(p.getIdProjet()).isEmpty()){%>
<div class="estvide"><h1>Aucun Document dans la liste</h1></div><% }else{%>
<div class="les_docs"> 
<table>
<caption><h1>Liste des Documents</h1></caption>
<tr><th>Id Document</th><th>Description</th></tr>
<%for(Document d:cdp.consulterdocs(p.getIdProjet())){ 
%>
<tr>
<td><%=d.getIdDocument()%></td>
<td><%=d.getDescriptiondoc()%></td>

<td> <a href="telechargementdoc?file=<%=d.getIdDocument()%>" target="_top">Télécharger</a>
    </td>


<td><a href="Supprimerdoc?iddoc=<%=d.getIdDocument()%>">Supprimer</a></td>
</tr>

<%}}%>

</table>
</div>
</body>
</html>