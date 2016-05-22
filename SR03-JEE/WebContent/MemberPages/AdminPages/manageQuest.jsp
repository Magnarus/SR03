<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestion des questionnaires</title>
	</head>
	<body>
		<h1> Gestion des questionnaires </h1>
		<!--  Affichage des questionnaires existants -->
		<p> Questionnaires existants </p>	
		<table>
			<tr>
				<th> Nom </th>
				<th> Date de cr�ation </th>
				<th> Action </th>
			</tr>
			<c:forEach var="quest"  items="${requestScope['listQuest']}" >
				<tr>
			          <td><a href="<c:url value="detailQuest?id=${quest.id}"/>" >${quest.name } </a></td>
			          <td> ${quest.dateCreation } </td>
			          <td> 
			          	<form  method="POST"><input type="hidden" name="id" value="${quest.id}"/><input value="Supprimer" type="submit"/></form>
			          </td>
			    </tr>
			</c:forEach>
		</table>
		<!-- Cr�ation d'un nouveau questionnaire -->
		<a href="<c:url value="createQuest.jsp"/>" > Cr�ation nouveau questionnaire</a>
			
		
	</body>
</html>