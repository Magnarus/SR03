<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des annonces</title>
</head>
<body>


		<p> Gestion des annonces :</p>
	   
		<table>
			<tr>
				<th> Nom </th>
				<th> Annonceur </th>
				<th> Téléphone </th>
				<th> Adresse </th>
				<th> Créateur </th>
				<th> Détails </th>
				<th> Action </th>
			</tr>
			<c:forEach var="annonce"  items="${requestScope['annonceList']}" >
				<tr>
			          <td><a href="<c:url value="detailAnnonce?id=${annonce.id}"/>" >${annonce.id } </a></td>
			          <td> ${annonce.annonceur } </td>
			          <td> ${annonce.tel } </td>
			          <td> ${annonce.adresse.rue }  <br/> 
			          		${annonce.adresse.ville} ${annonce.adresse.codePostal }
			          </td>
			          <td>
			          	${annonce.nom }
			          </td>
			          <td>
			          	${annonce.details }
			          </td>
			          <td> 
			          	<form action="manageAnnonces" method="post"><input type="hidden" name="id" value="${annonce.id}"/><input value="Supprimer" type="submit"/></form>
			          </td>
			    </tr>
			</c:forEach>
		</table>
		<!-- Création d'un nouveau questionnaire -->
		<a href="<c:url value="/createAnnonce"/>" > Nouvelle annonce </a>
		<a href="<c:url value="/Home" />">Accueil</a><br/>
</body>
</html>