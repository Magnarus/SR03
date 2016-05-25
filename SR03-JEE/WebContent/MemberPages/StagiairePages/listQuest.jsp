<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>Liste des questionnaires</title>
	</head>
	<body>
		<h1> Listes des questionnaires disponibles </h1>
		<!--  Affichage des questionnaires existants -->
		<p> Questionnaires existants </p>	
		 <form method = "POST" > 
	      	  <label for="filter"> Filtre : </label>
			  <input type="text" name="filter" value=""/>
							<input value="Chercher" type="submit"/>
	    </form>
		<display:table id="row" name="listQuest" requestURI="/MemberPages/StagiairePages/listQuest" pagesize="3" >
			<display:column property="name" title="Nom" />
			<display:column property="dateCreation" title="Date de création"  />
			<display:column title="Action">
				<form method="POST">
					<input type="hidden" name="id" value="${row.id}"/>
					<input value="Effectuer" type="submit"/>
				</form>
			</display:column>
		</display:table>
		
		<a href="<c:url value="/MemberPages/StagiairePages/homeStagiaire" />">Accueil</a><br/>
	</body>
</html>