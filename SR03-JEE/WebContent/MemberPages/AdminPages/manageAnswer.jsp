<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../form.css" />
		<title>Réponses</title>
	</head>
<body>
	<h1>Réponses</h1>
	<table>
			<tr>
				<th> Valeur </th>
				<th> Bonne réponse </th>
				<th> Action </th>
			</tr>
			<c:forEach var="a"  items="${requestScope['answers']}" >
				<tr>
			          <td>${a.value}</td>
			          <td>
			          <c:choose>
			              <c:when test="${a.id == rightAnswer}">Oui</c:when>
			              <c:otherwise>Non <a href="?id=${param.id}&right=${a.id}">Changer</a></c:otherwise>
			          </c:choose>
			          </td>
			          <td> 
			          	<form  method="POST"><input type="hidden" name="a_id" value="${a.id}"/><input value="Supprimer" type="submit"/></form>
			          </td>
			    </tr>
			</c:forEach>
		</table>
		<form method="post" action="createAnswer">
            <fieldset>
                <legend>Création d'une réponse</legend>
                <p>Création d'une réponse : </p>
                <label for="title">Valeur : <span class="requis"></span></label>
                <input type="text" id="value" name="value" size="20" maxlength="60" />
                <input type="hidden" name="q_id" value="${param.id}" />
                <span class="erreur">${form.errors['title']}</span>
                <br />
                <input type="submit" value="Créer" class="sansLabel" />
                <br />
            </fieldset>
        </form>
</body>
</html>