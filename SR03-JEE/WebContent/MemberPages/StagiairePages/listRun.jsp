<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>Parcours</title>
</head>
<body>
		<h1> Listes des parcours pr�c�dents </h1>
		<!--  Affichage des questionnaires existants -->
		<p> Parcours </p>	
		 <form method = "POST" > 
	      	  <label for="filter"> Filtre : </label>
			  <input type="text" name="filter" value=""/>
							<input value="Chercher" type="submit"/>
	    </form>
		<display:table id="row" name="listRun" requestURI="/MemberPages/StagiairePages/listRun" pagesize="3" >
			<display:column property="quest.subject" title="Sujet" />
			<display:column property="quest.name" title="Questionnaire"  />
			<display:column property="date" title="Date"  />
			<display:column property="duration" title="Dur�e"  />
			<display:column property="score" title="Score"  />
		</display:table>
		
		<a href="<c:url value="/MemberPages/StagiairePages/homeStagiaire" />">Accueil</a><br/>
</body>
</html>