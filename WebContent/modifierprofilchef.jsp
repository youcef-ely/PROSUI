<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@page import="com.utilisateurs.ChefDeProjetDAO"%>
<%@page import="com.utilisateurs.Administrateur"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Mot De passe</title>
<%ChefDeProjet chef = (ChefDeProjet) session.getAttribute("chef"); %>
<link rel="stylesheet" href="/Projet/page.css"/>
<script>
function required()
{

var empt1 = document.forms["modifiermdp"]["passwordchef"].value;

if (empt1 == "" )
{
alert("Veuillez remplir toutes les informations");
return false;
}
else return true;
}

</script>
</head>
<body>
<jsp:include page="headerchef.jsp"></jsp:include>

<form class="form_ajouter" name="modifiermdp" id="modifiermdp" action="ChangeMDP" method="post" onsubmit="return required()">
    <h1>Modifier Mot de Passe</h1>
      
          
      <div class="txtb">
      <input type="password" name="passwordchef" placeholder="Nouveau Mot De Passe" value="<%=chef.getMotDePasse()%>"/>
      
      </div>
     <input type="submit"  class="logbtn" value="Valider"></br>
    </form>
</form>
 </p>
 </div>
 </form>
</body>
</html>