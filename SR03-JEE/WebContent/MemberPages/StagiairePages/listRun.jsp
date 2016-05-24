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
		<h1> Listes des parcours précédents </h1>
		<!--  Affichage des questionnaires existants -->
		<p> Parcours </p>	
		<display:table id="row" name="listRun" requestURI="/MemberPages/StagiairePages/listRun" pagesize="3" >
			<display:column property="quest.subject" title="Sujet" />
			<display:column property="quest.name" title="Questionnaire"  />
			<display:column property="date" title="Date"  />
			<display:column property="duration" title="Durée"  />
			<display:column property="score" title="Score"  />
		</display:table>
		
		<a href="<c:url value="/MemberPages/StagiairePages/homeStagiaire" />">Accueil</a><br/>
</body>
</html>