<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../form.css" />
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>Questions du questionnaire</title>
	</head>
	<body>
		<h1>Questions</h1>
		
	<display:table id="row" name="questions" requestURI="/MemberPages/AdminPages/detailQuest" pagesize="3" decorator="projectSR03.decorators.DetailQuestDecorator">
		<display:column property="title" title="Nom" href="manageAnswer" paramId="id" paramProperty="id" />
		<display:column property="state" title="etat"  />
		<display:column title="Action">
			<form  method="POST">
       			<input type="hidden" name="q_id" value="${row.id}"/>
       			<input value="Supprimer" name="supprimer" type="submit"/>
       			<c:if test="${row_rowNum != 1}"><input value="Monter" name="monter" type="submit"/></c:if>
       			<c:if test="${row_rowNum != size}"><input value="Descendre" name="descendre" type="submit"/></c:if>
       		</form>
		</display:column>
	</display:table>
	<br/>
		
	<form method="post" action="createQuestion">
		<fieldset>
			<legend>Création d'une question</legend>
			<p>Création d'une question : </p>
			
			<label for="title">Titre : <span class="requis"></span></label>
			<input type="text" id="title" name="title" size="20" maxlength="60" />
			<input type="hidden" name="q_id" value="${param.id}" />
			<span class="erreur">${form.errors['title']}</span>
			<br />
			<input type="submit" value="Créer" class="sansLabel" />
			<br />
		</fieldset>
	</form>
</body>
</html>