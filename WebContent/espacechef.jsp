<%@page import="com.utilisateurs.ChefDeProjet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/Projet/page.css"/>
</head>
<body>
<%if(session.getAttribute("chef") == null)
        	{ 
        		response.sendRedirect("cdpauthentif.jsp");
        	}
        	else {
        		ChefDeProjet user = (ChefDeProjet) session.getAttribute("chef");        		
        	}%>	
<jsp:include page="headerchef.jsp"></jsp:include>
<jsp:include page="sidebarchef.jsp"></jsp:include>
</body>
</html>