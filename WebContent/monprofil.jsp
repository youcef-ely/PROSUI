<%@page import="com.utilisateurs.Administrateur"%>
<!DOCTYPE HTML>

<%
	Administrateur admin = (Administrateur)session.getAttribute("admin");
%>
<html>
<head>
<title><%= admin.getNom()%> <%=admin.getPrenom()%></title>
<link rel="stylesheet" href="/Projet/page.css"/>
<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="profil">
<table>
<caption><h1>Mon Profil</h1></caption>
<tr><td>Mon Id</td><td><%=admin.getIdutilisateur() %></td></tr>
<tr><td>Nom</td><td><%=admin.getNom() %></td></tr>
<tr><td>Prénom</td><td><%=admin.getPrenom() %></td></tr>
<tr><td>Email</td><td><%=admin.getEmail() %></td></tr>
<tr><td>Date d'inscription</td><td><%=admin.getDateinscription() %></td></tr>
<tr><td>Téléphone</td><td>+<%=admin.getTelephone() %></td></tr>
<tr><td >Mot de Passe</td><td><%=admin.getMotDePasse() %></td></tr>
</table>
<a href="/Projet/modifier_profil.jsp" class="bouton_modifier">Modifier</a>
</div>
</body>
</html>



