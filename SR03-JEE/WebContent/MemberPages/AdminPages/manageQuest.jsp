<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>Gestion des questionnaires</title>
	</head>
	<body>
		<h1> Gestion des questionnaires </h1>
		<!--  Affichage des questionnaires existants -->
		<p> Questionnaires existants </p>	
		<table>
			<tr>
				<th> Nom </th>
				<th> Date de création </th>
				<th> Etat </th>
				<th> Action </th>
			</tr>
			<c:forEach var="quest"  items="${requestScope['listQuest']}" >
				<tr>
			          <td><a href="<c:url value="detailQuest?id=${quest.id}"/>" >${quest.name } </a></td>
			          <td> ${quest.dateCreation } </td>
			          <td>
			          	<c:choose>
			          		<c:when test="${quest.state == true}"><a href="?id=${quest.id}&state=0">Actif</a></c:when>
			          		<c:otherwise><a href="?id=${quest.id}&state=1">Inactif</a></c:otherwise>
			          	</c:choose>
			          </td>
			          <td> 
			          	<form  method="POST"><input type="hidden" name="id" value="${quest.id}"/><input value="Supprimer" type="submit"/></form>
			          </td>
			    </tr>
			</c:forEach>
		</table>
		<!-- Création d'un nouveau questionnaire -->
		<a href="<c:url value="createQuest.jsp"/>" > Création nouveau questionnaire</a>
		<a href="<c:url value="/MemberPages/AdminPages/homeAdmin" />">Accueil</a><br/>
					
		
	</body>
</html>