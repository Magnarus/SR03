<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Réponses</title>
</head>
<body>
	<h1>Réponses</h1>
	<table>
			<tr>
				<th> Valeur </th>
				<th> Action </th>
			</tr>
			<c:forEach var="a"  items="${requestScope['answers']}" >
				<tr>
			          <td>${a.value}</a></td>
			          <td> 
			          	<form  method="POST"><input type="hidden" name="a_id" value="${a.id}"/><input value="Supprimer" type="submit"/></form>
			          </td>
			    </tr>
			</c:forEach>
		</table>
</body>
</html>