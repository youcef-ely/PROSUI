<%@page import="com.utilisateurs.ChefDeProjet"%>
<!DOCTYPE HTML>

<%
	ChefDeProjet user = (ChefDeProjet)session.getAttribute("chef");
%>
<html>
<head>
<title><%= user.getNom()%> <%=user.getPrenom()%></title>
<link rel="stylesheet" href="/Projet/page2.css"/>
<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">

</head>
<body>
<jsp:include page="headerchef.jsp"></jsp:include>

<div class="profil">
<table>
<caption><h1>Mon Profil</h1></caption>
<tr><td>Mon Id</td><td><%=user.getIdutilisateur() %></td></tr>
<tr><td>Nom</td><td><%=user.getNom() %></td></tr>
<tr><td>Prénom</td><td><%=user.getPrenom() %></td></tr>
<tr><td>Email</td><td><%=user.getEmail() %></td></tr>
<tr><td>Date d'inscription</td><td><%=user.getDateinscription() %></td></tr>
<tr><td>Téléphone</td><td>+<%=user.getTelephone() %></td></tr>
<tr><td >Mot de Passe</td><td><%=user.getMotDePasse() %></td></tr>
</table>
<a href="/Projet/modifierprofilchef.jsp" class="mdpchange">Changer Mot De Passe</a>
</div>
</body>
</html>



