<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../form.css" />
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>R�ponses</title>
	</head>
<body>
	<h1>R�ponses</h1>
	<table>
			<tr>
				<th> Valeur </th>
				<th> Bonne r�ponse </th>
				<th> Etat </th>
				<th> Action </th>
			</tr>
			<c:set var="count" value="0" scope="page" />
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
			          <c:choose>
			          		<c:when test="${a.state == true}"><a href="?id=${param.id}&aId=${a.id}&state=0">Actif</a></c:when>
			          		<c:otherwise><a href="?id=${param.id}&aId=${a.id}&state=1">Inactif</a></c:otherwise>
			          	</c:choose>
			          </td>
			          <td>
						<form  method="POST">
							<input type="hidden" name="a_id" value="${a.id}"/>
							<input value="Supprimer" name="supprimer" type="submit"/>
							<c:if test="${count != 0}"><input value="Monter" name="monter" type="submit"/></c:if>
							<c:if test="${count != size-1}"><input value="Descendre" name="descendre" type="submit"/></c:if>
						</form>
			          </td>
			    </tr>
			    <c:set var="count" value="${count + 1}" scope="page"/>
			</c:forEach>
		</table>
		<form method="post" action="createAnswer">
            <fieldset>
                <legend>Cr�ation d'une r�ponse</legend>
                <p>Cr�ation d'une r�ponse : </p>
                <label for="title">Valeur : <span class="requis"></span></label>
                <input type="text" id="value" name="value" size="20" maxlength="60" />
                <input type="hidden" name="q_id" value="${param.id}" />
                <span class="erreur">${form.errors['title']}</span>
                <br />
                <input type="submit" value="Cr�er" class="sansLabel" />
                <br />
            </fieldset>
        </form>
</body>
</html>