<%@page import="com.utilisateurs.Administrateur"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Profil</title>
<%Administrateur admin = (Administrateur) session.getAttribute("admin"); %>
<link rel="stylesheet" href="/Projet/page.css"/>
<script>
function required()
{
var empt1 = document.forms["profil"]["nom"].value;
var empt2 = document.forms["profil"]["prenom"].value;
var empt3 = document.forms["profil"]["email"].value;
var empt4 = document.forms["profil"]["tel"].value;
var empt5 = document.forms["profil"]["password"].value;

if (empt1 == "" || empt2 == "" || empt3 == "" || empt4 == "" || empt5 == ""  )
{
alert("Veuillez remplir toutes les informations");

return false;
}

}

</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form class="form_ajouter"  id="profil" name="profil" action="Updatecompte" method="post" onsubmit="return required()">
    <h1>Modifier Profil</h1>
      <div class="txtb">
      <input type="text" name="nom" placeholder="Nom" value="<%=admin.getNom()%>"/>
      </div>
      <div class="txtb">
      <input type="text" name="prenom" placeholder="Prénom" value="<%=admin.getPrenom()%>"/>
      </div>
      <div class="txtb">
      <input type="text" name="email" placeholder="Email" value="<%=admin.getEmail()%>"/>
      </div>
      
      <div class="txtb">
      <input type="text" name="tel" placeholder="Téléphone" value="<%=admin.getTelephone()%>"/>
      </div> 
          
      <div class="txtb">
      <input type="password" name="password" placeholder="Mot De Passe" value="<%=admin.getMotDePasse()%>"/>
      
      </div>
     <input type="submit"  class="logbtn" value="Valider"></br>
    </form>
</form>
 </p>
 </div>
 </form>
</body>
</html>