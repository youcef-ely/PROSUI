<%@page import="com.projet.Planning"%>
<%@page import="com.utilisateurs.ChefDeProjetDAO"%>
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
var empt1 = document.forms["modifiertache"]["tache"].value;


if (empt1 == "" )
{
alert("Veuillez remplir toutes les informations");

return false;
}

}

</script>
</head>
<%
int idtache=0;
String tache="";
String deb="";
String fin="";

ChefDeProjet chef=(ChefDeProjet)session.getAttribute("chef");
Planning p = (Planning) request.getAttribute("planning");
if(p!=null) {
	 idtache = p.getIdtache();
	 tache = p.getTache();
	 deb = p.getDatedebut();
	 fin = p.getDatefin();
}
%>
<body>
<jsp:include page="headerchef.jsp"></jsp:include>
<form class="form_ajouter" id ="modifiertache" name="modifiertache" action="Modifiertache" method="post" onsubmit="return required()">
    <h1>Modifier Tâche</h1>
  
      <input type="hidden" name="idtache" value="<%=idtache%>"/>
     
      <div class="txtb">
      <input type="text" name="tache" value="<%=tache%>"/>
      </div>
      
      <div class="txtb">
      <input type="text" name="datedebut" value="<%=deb%>"/>
      </div>
      
      <div class="txtb">
      <input type="text" name="datefin" value="<%=fin%>"/>
      </div>
      
     <input type="submit"  class="logbtn" value="Valider"></br>
    </form>
</body>
</html>