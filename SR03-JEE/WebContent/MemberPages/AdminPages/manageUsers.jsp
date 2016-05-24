<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="../../table.css" />
		<title>Gestions users</title>
	</head>
	<body>
		<p> Gestion des utilisateurs :</p>
		
		<table>
			<tr>
				<th> ID </th>
				<th> Nom </th>
				<th> Prénom </th>
				<th> Téléphone </th>
				<th> Société </th>
				<th> Email </th>
				<th> Mot de passe </th>
				<th> Administrateur </th>
				<th> Actif </th>
			</tr>
			<c:forEach items="${listUsers}" var="user" varStatus="status">
				<tr>
					<td> <a href="<c:url value="detailUser?userId=${user['id']}"/>" >${user['id']} </a> </td>
					<td> ${user['lastName']} </td>
					<td> ${user['firstName']} </td>
					<td> ${user['phoneNumber']} </td>
					<td> ${user['company']} </td>
					<td> ${user['email']} </td>
					<td> ${user['password']} </td>
					<td> 
						<input type="checkbox" name="isAdmin" 
						<c:if test="${ user['admin'] }">
								disabled="disabled"  checked="checked" </c:if>
						<c:if test="${ !user['admin'] }">
								disabled="disabled"</c:if>
						/>
					 </td>
					<td> 
						<input type="checkbox" name="stateUser" 
						<c:if test="${ user['state'] }">
								 disabled="disabled" checked="checked" </c:if>
						<c:if test="${ !user['state'] }">
								  disabled="disabled" </c:if>
						/>
				   </td>
				</tr>
			</c:forEach>
		</table>
		<!-- Création d'un nouveau questionnaire -->
		<a href="<c:url value="/MemberPages/AdminPages/CreateUser"/>" > Nouvel utilisateur </a>
		<a href="<c:url value="/MemberPages/AdminPages/homeAdmin" />">Accueil</a><br/>
	
	</body>
</html>