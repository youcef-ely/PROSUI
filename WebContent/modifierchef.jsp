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
var empt1 = document.forms["modifierchef"]["nom"].value;
var empt2 = document.forms["modifierchef"]["prenom"].value;
var empt3 = document.forms["modifierchef"]["email"].value;
var empt4 = document.forms["modifierchef"]["tel"].value;
var empt5 = document.forms["modifierchef"]["password"].value;

if (empt1 == "" || empt2 == "" || empt3 == "" || empt4 == "" || empt5 == ""  )
{
alert("Veuillez remplir toutes les informations");

return false;
}

}

</script>
</head>
<%
int idchef=0;
String nom="";
String prenom="";
String email="";
long telephone=0;
String password="" ;
Administrateur admin=(Administrateur)session.getAttribute("admin");
ChefDeProjet chef=(ChefDeProjet)request.getAttribute("chef");
if(chef!=null){
idchef=chef.getIdutilisateur();
nom=chef.getNom();
prenom=chef.getPrenom();
email=chef.getEmail();
telephone=chef.getTelephone();
password=chef.getMotDePasse();
}
%>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form class="form_ajouter" id ="modifierchef" name="modifierchef" action="Modifierchef" method="post" onsubmit="return required()">
    <h1>Modifier Chef</h1>
  
      <input type="hidden" name="idchef" value="<%=idchef%>"/>
     
      <div class="txtb">
      <input type="text" name="nom" value="<%=nom%>"/>
      </div>
      <div class="txtb">
      <input type="text" name="prenom" value="<%=prenom%>"/>
      </div>
      <div class="txtb">
      <input type="text" name="email" value="<%=email%>"/>
      </div>
      
      <div class="txtb">
      <input type="text" name="tel" value="<%=telephone%>"/>
      </div> 
          
      <div class="txtb">
      <input type="password" name="password" value="<%=password%>" />
      
      </div>
     <input type="submit"  class="logbtn" value="Valider"></br>
    </form>
</body>
</html>