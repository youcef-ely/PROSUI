<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@page import="com.utilisateurs.ChefDeProjetDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

    }%>	
    
    <%ChefDeProjet chef=(ChefDeProjet)session.getAttribute("chef"); 
ChefDeProjetDAO cdp = new ChefDeProjetDAO();
%>
<script>
function required()
{
var empt1 = document.forms["ajouterdoc"]["descriptiondoc"].value;
var empt2 = document.getElementById('file').files.length
if (empt1 == "" || empt2 == 0 )
{
alert("Veuillez remplir toutes les informations");

return false;
}

}

</script>
</head>
<body>
<jsp:include page="headerchef.jsp"></jsp:include>
<%if (cdp.monprojet(chef.getIdutilisateur())==null){ %>
<div class="estvide"><h1>Vous n'avez aucun projet</h1></div><%}else{ %>
<form class ="form_ajouter" action="Ajouterdoc" name="ajouterdoc" id="ajouterdoc" method="post" enctype="multipart/form-data" onsubmit="return required()">
<h1>Ajouter Document</h1>

<div class="txtb"><input type="text" name="descriptiondoc" placeholder="Nom du document"/></div>

<div class="txtb"><input type="file"  id="file" name="file" accept="application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint,image/*,application/pdf" /></div>

<input type="submit" value="Ajouter" class="logbtn"/>
</form>
<%} %>
</body>
</html>