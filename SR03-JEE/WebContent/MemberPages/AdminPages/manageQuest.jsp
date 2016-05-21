<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestion des questionnaires</title>
	</head>
	<body>
		<!--  Affichage des questionnaires existants -->
		<table>
			<tr>
				<th> Nom </th>
				<th> Date de cr�ation </th>
				<th> Action </th>
			</tr>
			<c:forEach var="quest"  items="${requestScope['listQuestionnaire']}" >
				<tr>
			          <td> ${quest.name } </td>
			          <td> ${quest.dateCreation } </td>
			          <td> 
			          		
			          </td>
			    </tr>
			</c:forEach>
			
			<!-- Cr�ation d'un nouveau questionnaire -->
			<a href="<c:url value="createQuest.jsp"/>" > Cr�ation nouveau questionnaire</a>
			
		</table>
	</body>
</html>