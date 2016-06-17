<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method = "POST" action="afficheAnnonce" > 
      	  <select name="categs">
      	  	<c:forEach var="c" items="${requestScope['categorieList']}">
      	  		<option value="${c.id}">${c.nom}</option>
      	  	</c:forEach>
      	  </select>
	     <input type="submit" value="Valider">  
	</form>
	<table>
			<tr>
				<th> Nom </th>
				<th> Annonceur </th>
				<th> Téléphone </th>
				<th> Adresse </th>
				<th> Créateur </th>
				<th> Détails </th>
			</tr>
			<c:forEach var="annonce"  items="${requestScope['annonceList']}" >
				<tr>
			          <td>${annonce.nom }</td>
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
			    </tr>
			</c:forEach>
		</table>
</body>
</html>