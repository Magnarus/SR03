<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>Gestion users</title>
	</head>
	<body>
		<p> Gestion des utilisateurs :</p>
		
		<display:table id="row" name="listUsers" requestURI="/MemberPages/AdminPages/manageUsers" pagesize="3" decorator="projectSR03.decorators.ManageUserDecorator">
			<display:column property="id" title="id" href="detailUser" paramId="userId" paramProperty="id"/>
			<display:column property="lastName" title="Nom"/>
			<display:column property="firstName" title="Prénom"/>
			<display:column property="phoneNumber" title="Téléphone"  />
			<display:column property="company" title="Société"  />
			<display:column property="email" title="Email"  />
			<display:column property="password" title="Mot de passe"  />
			<display:column property="admin" title="Administrateur"  />
			<display:column property="state" title="Actif" />
			<display:column title="Action">
				<form  method="POST">
					<input type="hidden" name="q_id" value="${row.id}"/>
					<input value="Supprimer" type="submit"/>
				</form>
			</display:column>
		</display:table>
		<!-- Création d'un nouveau questionnaire -->
		<a href="<c:url value="/MemberPages/AdminPages/CreateUser"/>" > Nouvel utilisateur </a>
		<a href="<c:url value="/MemberPages/AdminPages/homeAdmin" />">Accueil</a><br/>
	
	</body>
</html>