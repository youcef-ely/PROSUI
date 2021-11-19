<%@page import="com.projet.Projet"%>
<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@page import="com.utilisateurs.AdministrateurDAO"%>
<%@page import="com.utilisateurs.Administrateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<script>
function required()
{
var empt1 = document.forms["modifierprojet"]["titre"].value;
var empt2 = document.forms["modifierprojet"]["type"].value;
var empt3 = document.forms["modifierprojet"]["etat"].value;
var empt4 = document.forms["modifierprojet"]["datelimite"].value;
var empt5 = document.forms["modifierprojet"]["chef"].value;
var empt6 = document.forms["modifierprojet"]["file"].value;
if (empt1 == "" || empt2 == "" || empt3 == "Etat d'avancement du projet" || empt4 == "" || empt5 == "Sélectionnez un chef de projet" || empt6 == "" )
{
alert("Veuillez remplir toutes les informations");

return false;
}

}

</script>
</head>
<%
int idprojet=0;
String titre="";
String type="";
byte[] description=null;
String etat="";
String datelimite="";
int chef=0;
Administrateur admin=(Administrateur)session.getAttribute("admin");
AdministrateurDAO ad=new AdministrateurDAO();
Projet projet=(Projet)request.getAttribute("projet");
session.setAttribute("projet", projet);

if(projet!=null){
	idprojet=projet.getIdProjet();
	titre=projet.getTitreProjet();
	type=projet.getTypeProjet();
	description=projet.getDescriptionProjet();
	etat=projet.getEtatProjet();
	datelimite=projet.getDatelimite();
	chef=projet.getIdCDP();
}
%>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form class ="form_ajouter" name="modifierprojet" id="modifierprojet" action="Modifierprojet" method="post" enctype="multipart/form-data" onsubmit="return required()">

<h1>Modifier Projet</h1>
<input type="hidden" name="idprojet" value="<%=idprojet%>" />
<div class="txtb"><input type="text" name="titre" value="<%=titre%>" /></div>
<div class="txtb"><input type="text" name="type" value="<%=type%>"/></div>
<div class="txtb">
<select name="etat" value="<%=etat%>" >
	<option value="0" disabled selected >Etat d'avancement du projet</option>
	<option value="En Cours">En Cours</option>
	<option value="En pause">En pause</option>
	<option value="Terminé">Terminé</option>
</select></div>
<div class="txtb"><input type="text" name="datelimite" value="<%=datelimite%>" /></div>
<div class="txtb">
<select name="chef" value="<%=chef%>"><option value="0" disabled selected >Sélectionnez un chef de projet</option>
 <%for(ChefDeProjet c:ad.consulterCDPsDansProjet(admin.getIdutilisateur())){%>
      <option><%=c.getNom()%> <%=c.getPrenom()%></option><%}%></select>
</div>
<div class="txtb"><input type="file"  id="myfile" name="description" accept="application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint,image/*,application/pdf" value="<%=description %>" /></div>

<input type="submit" value="Valider" class="logbtn"/>
</form>
</body>
</html>