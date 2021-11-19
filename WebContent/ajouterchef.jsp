<%@page import="com.utilisateurs.Administrateur"%>
<!DOCTYPE HTML>
<html>
<head>
<%if(session.getAttribute("admin") == null)
        	{ 
        		response.sendRedirect("adminauthentif.jsp");
        	}
        	else {
        		Administrateur admin = (Administrateur) session.getAttribute("admin");
        			   	}%>	
<title>Ajouter Chef</title>
<link rel="stylesheet" href="/Projet/page.css"/>
<script>
function required()
{
var empt1 = document.forms["formchef"]["nom"].value;
var empt2 = document.forms["formchef"]["prenom"].value;
var empt3 = document.forms["formchef"]["email"].value;
var empt4 = document.forms["formchef"]["tel"].value;
var empt5 = document.forms["formchef"]["password"].value;
if (empt1 == "" || empt2 == "" || empt3 == "" || empt4 == "" || empt5 == "")
{
alert("Veuillez remplir toutes les informations");

return false;
}

}

</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form class="form_ajouter" name="formchef" action="Ajouterchef" method="post" onsubmit="return required()">
    <h1>Ajouter Chef</h1>
      <div class="txtb">
      <input type="text"  name="nom" placeholder="Nom"/>
      </div>
      <div class="txtb">
      <input type="text"  name="prenom" placeholder="Prénom"/>
      </div>
      <div class="txtb">
      <input type="text"  name="email" placeholder="Email"/>
      </div>
      
      <div class="txtb">
      <input type="text" name="tel" placeholder="Téléphone (212...)"/>
      </div> 
          
      <div class="txtb">
      <input type="password" id="cpassword" name="password" placeholder="Mot De Passe" />
      
      </div>
     <input type="submit"  class="logbtn" value="Ajouter" ></br>
    </form>
</body>
</html>
