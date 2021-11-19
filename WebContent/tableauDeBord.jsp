<%@page import="com.utilisateurs.AdministrateurDAO"%>
<%@page import="com.utilisateurs.Administrateur"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.sql.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Administrateur admin = (Administrateur) session.getAttribute("admin");
AdministrateurDAO ad = new AdministrateurDAO();
Integer nbChefProjet = ad.getNombreChefProjet(admin.getIdutilisateur());
Integer nbProjet = ad.getNombreProjet(admin.getIdutilisateur());
Integer nbdocument=ad.getNombreDocument(admin.getIdutilisateur());
Integer nbEtatdebut=ad.getNombreEtatdebut(admin.getIdutilisateur());
Integer nbEtatencours=ad.getNombreEtatencours(admin.getIdutilisateur());
Integer nbEtatenpause=ad.getNombreEtatenpause(admin.getIdutilisateur());
Integer nbEtattermine=ad.getNombreEtattermine(admin.getIdutilisateur());
%>
<html>
  <head>
  
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Etat', 'Nombre'],
          ['Au Début',     <%=nbEtatdebut%>],
          ['En Cours',      <%=nbEtatencours%>] ,   
          ['En pause',      <%=nbEtatenpause%>],
          ['Terminé',      <%=nbEtattermine%>]
        ]);

        var options = {
          title: "Les états d'avancement des projets"
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
    
    <script type="text/javascript">
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Type", "nombre", { role: "style" } ],
        ["Chefs De Projet existants",<%=nbChefProjet%>, "#b87333"],
        ["Projets existants", <%=nbProjet%>, "silver"],
        ["Documents existants", <%=nbdocument%>, "gold"]
        ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: 'Statistiques générales',
        width: 600,
        height: 400,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
      chart.draw(view, options);
  }
  </script>
  </head>
  <body  style="overflow:hidden;">
  <jsp:include page="header.jsp"></jsp:include>
    <div id="piechart" style="width: 50%; height: 400px; margin-top:100px; margin-left:10%;">
    </div><div id="barchart_values" style="width: 50%; height: 400px; margin-left:50%; margin-top:-400px;"></div>
    
  </body>
</html>