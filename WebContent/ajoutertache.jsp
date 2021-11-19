<%@page import="com.utilisateurs.ChefDeProjetDAO"%>
<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@page import="com.projet.Projet"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/Projet/page2.css"/>
<%if(session.getAttribute("chef") == null)
        	{ 
        		response.sendRedirect("cdpauthentif.jsp");
        	}
        	else {
        		ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef");
        		ChefDeProjetDAO ch = new ChefDeProjetDAO();
        		Projet p = ch.monprojet(chef.getIdutilisateur());

    }
                ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef");
        		ChefDeProjetDAO ch = new ChefDeProjetDAO();
        		Projet p = ch.monprojet(chef.getIdutilisateur());%>	
<script>
function required()
{
var empt1 = document.forms["ajoutertache"]["tache"].value;
var empt2 = document.forms["ajoutertache"]["datedebut"].value;
var empt3 = document.forms["ajoutertache"]["datefin"].value;

if (empt1 == "" || empt2 == "" || empt3 == "")
{
alert("Veuillez remplir toutes les informations");

return false;
}else {
	alert("Tâche ajoutée");
	return true;
}

}

</script>
</head>
<body>
<jsp:include page="headerchef.jsp"></jsp:include>
<%if (p==null) {%>
<div class="estvide"><h1>Vous n'avez aucun projet.</h1></div><% }
else {%>
<form class ="form_ajouter" action="Ajoutertache" name="ajoutertache" id="ajoutertache" method="post" onsubmit="return required()">
<h1>Ajouter Tâche</h1>

<div class="txtb"><input type="text" name="tache" placeholder="Tâche"/></div>
<div class="txtb"><input type="text" name="datedebut" placeholder="Date début (YYYY-MM-DD)"/></div>
<div class="txtb"><input type="text" name="datefin" placeholder="Date Fin (YYYY-MM-DD)"/></div>


<input type="submit" value="Ajouter" class="logbtn"/>
</form>
<%} %>
</body>
</html>