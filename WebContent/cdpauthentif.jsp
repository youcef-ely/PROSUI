<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<meta charset="ISO-8859-1">
<title>Authenfification</title>
<link rel="stylesheet" href="/Projet/style1.css"/>
<link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
<script>
function required()
{
var empt1 = document.forms["authentificationchef"]["gmail"].value;
var empt2 = document.forms["authentificationchef"]["password"].value;

if (empt1 == "" || empt2 == "" )
{
alert("Veuillez remplir toutes les informations");

return false;
}

}

</script>
</head>
<body>


  
  
    <form class="register-form" action="AuthentificationCHEF" method="post" name="authentificationchef" id="authentificationchef" onsubmit="return required">
    <h1>Chef De Projet</h1>
      <div class="txtb">
      <input type="text" name="gmail" placeholder="Email"/>
      </div>
      
      
      
      <div class="txtb">
      <input type="password" name="password" placeholder="Password" />
      
      </div>
     <input type="submit"  class="logbtn" value="Connecter"></br>
     <input type="reset" class="logbtn" value="Annuler">
     
    </form>
    
</body>
</html>