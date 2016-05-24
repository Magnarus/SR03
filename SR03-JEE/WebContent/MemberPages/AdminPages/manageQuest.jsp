<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>Gestion des questionnaires</title>
	</head>
	<body>
		<h1> Gestion des questionnaires </h1>
		<!--  Affichage des questionnaires existants -->
		<p> Questionnaires existants </p>
		<display:table id="row" name="listQuest" requestURI="/MemberPages/AdminPages/manageQuest" pagesize="3" decorator="projectSR03.decorators.ManageQuestDecorator">
			<display:column property="name" title="Nom" href="detailQuest" paramId="id" paramProperty="id" />
			<display:column property="subject" title="Sujet"/>
			<display:column property="dateCreation" title="Date de création"  />
			<display:column property="state" title="etat"  />
			<display:column title="Action">
				<form  method="POST">
					<input type="hidden" name="q_id" value="${row.id}"/>
					<input value="Supprimer" type="submit"/>
				</form>
			</display:column>
		</display:table>
		<!-- Création d'un nouveau questionnaire -->
		<a href="<c:url value="createQuest.jsp"/>" > Création nouveau questionnaire</a>
		<a href="<c:url value="/MemberPages/AdminPages/homeAdmin" />">Accueil</a><br/>
	</body>
</html>