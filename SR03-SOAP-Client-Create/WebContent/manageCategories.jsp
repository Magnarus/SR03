<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des categories</title>
</head>
<body>


		<p> Gestion des categories :</p>
	   
		<table>
			<tr>
				<th> Nom </th>
				<th> Action </th>
			</tr>
			<c:forEach var="categ"  items="${requestScope['categorieList']}" >
				<tr>
			          <td><a href="<c:url value="detailAnnonce?id=${categ.id}"/>" >${categ.id } </a></td>
			          <td>
			          	${categ.nom}
			          <td> 
			          	<form action="manageCategories" method="post"><input type="hidden" name="id" value="${categ.id}"/><input value="Supprimer" type="submit"/></form>
			          </td>
			    </tr>
			</c:forEach>
		</table>
		<!-- Création d'un nouveau questionnaire -->
		<a href="<c:url value="/createAnnonce"/>" > Nouvelle annonce </a>
		<a href="<c:url value="/Home" />">Accueil</a><br/>
</body>
</html>