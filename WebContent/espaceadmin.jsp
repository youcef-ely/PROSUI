<%@page import="com.utilisateurs.Administrateur"%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="sidebar.jsp"></jsp:include>
<%if(session.getAttribute("admin") == null)
        	{ 
        		response.sendRedirect("adminauthentif.jsp");
        	}
        	else {
        		Administrateur user = (Administrateur) session.getAttribute("admin");        		
        	}%>	