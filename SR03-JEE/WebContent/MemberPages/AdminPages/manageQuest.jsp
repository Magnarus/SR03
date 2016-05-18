<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestion des questionnaires</title>
	</head>
	<body>
		<table>
			<tr>
				<th> Nom </th>
				<th> Date de création </th>
				<th> Action </th>
			</tr>
			<c:forEach var="quest"  items="${requestScope['listQuestionnaire']}" >
				<tr>
			          <td> ${quest.Name } </td>
			          <td> ${quest.dateCreation } </td>
			          <td> 
			          	<!--  TODO : ADD ACTION -->
			          </td>
			    </tr>
			</c:forEach>
			<!--  TODO : ADD REDIRECT HTML OU JSP STYLE ? -->
			
		</table>
	</body>
</html>