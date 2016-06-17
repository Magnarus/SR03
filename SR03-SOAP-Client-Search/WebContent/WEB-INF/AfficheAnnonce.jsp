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
	<form method = "POST" > 
	      	  <label for="filter"> Filtre : </label>
			  <input type="text" name="filter" value=""/>
							<input value="Chercher" type="submit"/>
	    </form>
	<table>
			<tr>
				<th> Nom </th>
				<th> Annonceur </th>
				<th> T�l�phone </th>
				<th> Adresse </th>
				<th> Cr�ateur </th>
				<th> D�tails </th>
			</tr>
			<c:forEach var="annonce"  items="${requestScope['annonceList']}" >
				<tr>
			          <td><a href="<c:url value="detailAnnonce?id=${annonce.id}"/>" >${annonce.nom } </a></td>
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