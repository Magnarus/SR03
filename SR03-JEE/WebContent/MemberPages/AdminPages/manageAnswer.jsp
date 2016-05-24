<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../form.css" />
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>Réponses</title>
	</head>
	<body>
		<h1>Réponses</h1>
		<display:table id="row" name="answers" requestURI="/MemberPages/AdminPages/manageAnswer" pagesize="3" decorator="projectSR03.decorators.ManageAnswerDecorator">
			<display:column property="id" title="id" />
			<display:column property="value" title="Valeur" />
			<display:column title="Bonne réponse">
				<c:choose>
					<c:when test="${row.id == rightAnswer}">Oui</c:when>
					<c:otherwise>Non <a href="?id=${param.id}&right=${row.id}">Changer</a></c:otherwise>
				</c:choose>
			</display:column>
			<display:column property="state" title="etat"  />
			<display:column title="Action">
				<form  method="POST">
					<input type="hidden" name="a_id" value="${row.id}"/>
					<input value="Supprimer" name="supprimer" type="submit"/>
					<c:if test="${row_rowNum != 1}"><input value="Monter" name="monter" type="submit"/></c:if>
					<c:if test="${row_rowNum != size}"><input value="Descendre" name="descendre" type="submit"/></c:if>
				</form>
			</display:column>
		</display:table>
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