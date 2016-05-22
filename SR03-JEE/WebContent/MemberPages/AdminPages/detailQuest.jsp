<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Questions du questionnaire</title>
	</head>
	<body>
		<h1>Questions</h1>
		<table>
			<tr>
				<th> Nom </th>
				<th> Action </th>
			</tr>
			<c:forEach var="q"  items="${requestScope['questions']}" >
				<tr>
			          <td><a href="<c:url value="manageAnswer?id=${q.id}"/>" >${q.title} </a></td>
			          <td> 
			          	<form  method="POST"><input type="hidden" name="q_id" value="${q.id}"/><input value="Supprimer" type="submit"/></form>
			          </td>
			    </tr>
			</c:forEach>
		</table>
	</body>
</html>