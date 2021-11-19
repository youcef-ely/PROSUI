<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Créer compte</title>
<link rel="stylesheet" href="/Projet/page.css"/>
<script>
function required()
{
var empt1 = document.forms["creercompte"]["nom"].value;
var empt2 = document.forms["creercompte"]["prenom"].value;
var empt3 = document.forms["creercompte"]["email"].value;
var empt4 = document.forms["creercompte"]["tel"].value;
var empt5 = document.forms["creercompte"]["password"].value;
if (empt1 == "" || empt2 == "" || empt3 == "" || empt4 == "" || empt5 == "")
{
alert("Veuillez remplir toutes les informations");

return false;
}

}

</script>
</head>
<body>
<form class="form_ajouter" name="creercompte" action="Creercompteadmin" method="post" onsubmit="return required()">
    <h1>Créer Compte</h1>
    
      <div class="txtb">
      <input type="text" name="nom" placeholder="Nom"/>
      </div>
      
      <div class="txtb">
      <input type="text" name="prenom" placeholder="Prénom"/>
      </div>
      
      <div class="txtb">
      <input type="text" name="email" placeholder="Email"/>
      </div>
      
      <div class="txtb">
      <input type="text" name="tel" placeholder="Téléphone"/>
      </div> 
          
      <div class="txtb">
      <input type="password" name="password" placeholder="Mot De Passe" />
      </div>
      
     <input type="submit"  class="logbtn" value="Créer compte"></br>
    
</form>
 </p>
 </div>
 </form>
</body>
</html>