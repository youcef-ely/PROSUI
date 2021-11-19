<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@page import="com.projet.Projet"%>
<%@page import="com.utilisateurs.AdministrateurDAO"%>
<%@page import="com.utilisateurs.Administrateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% Administrateur admin=(Administrateur)session.getAttribute("admin");
AdministrateurDAO ad=new AdministrateurDAO();
%>
<title>Ajouter Projet</title>
<link rel="stylesheet" href="/Projet/page.css"/>
<script>
function required()
{
var empt1 = document.forms["formprojet"]["titre"].value;
var empt2 = document.forms["formprojet"]["type"].value;
var empt3 = document.forms["formprojet"]["etat"].value;
var empt4 = document.forms["formprojet"]["datelimite"].value;
var empt5 = document.forms["formprojet"]["chef"].value;
var empt6 = document.forms["formprojet"]["file"].value;
if (empt1 == "" || empt2 == "" || empt3 == "Etat d'avancement du projet" || empt4 == "" || empt5 == "Sélectionnez un chef de projet" || empt6 == "" )
{
alert("Veuillez remplir toutes les informations");
window.open("/Projet/ajouterprojet.jsp");
return false;
}

}

</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form class ="form_ajouter" name= "formprojet" action="Ajouterprojet" method="post" enctype="multipart/form-data" onsubmit="return required()">

<h1>Ajouter Projet</h1>
<div class="txtb"><input type="text" name="titre" placeholder="Titre"/></div>
<div class="txtb"><input type="text" name="type" placeholder="Type"/></div>
<div class="txtb"><select name="etat"><option value="0" disabled selected >Etat d'avancement du projet</option><option value="Au Début">Au Début</option></select></div>
<div class="txtb"><input type="text" name="datelimite" placeholder="YYYY-MM-DD (date limite)"/></div>
<div class="txtb">
<select name="chef"><option value="0" disabled selected >Sélectionnez un chef de projet</option>
 <%for(ChefDeProjet c: ad.consulterCDPsDansProjet(admin.getIdutilisateur())){%>
      <option><%=c.getNom()%> <%=c.getPrenom()%></option><%}%></select>
</div>
<div class="txtb"><input type="file"  id="myfile" name="file" accept="application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint,image/*,application/pdf" /></div>

<input type="submit" value="Ajouter" class="logbtn"/>
</form>
</body>
</html>