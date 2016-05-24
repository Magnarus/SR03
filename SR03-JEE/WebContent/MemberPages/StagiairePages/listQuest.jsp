<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<table>
			<tr>
				<th> Nom </th>
				<th> Date de création </th>
				<th> Action </th>
			</tr>
			<c:forEach var="quest"  items="${requestScope['listQuest']}" >
				<tr>
			          <td> ${quest.name } </td>
			          <td> ${quest.dateCreation } </td>
			          <td> 
			          	<form method="POST"><input type="hidden" name="id" value="${quest.id}"/><input value="Effectuer" type="submit"/></form>
			          </td>
			    </tr>
			</c:forEach>
		</table>
		
		<a href="<c:url value="/MemberPages/StagiairePages/homeStagiaire" />">Accueil</a><br/>
	</body>
</html>