<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> Accueil administrateur </title>
	</head>
	
	<body>
		<p> Accueil administrateur : </p>
		<a href="<c:url value="/MemberPages/AdminPages/manageUsers.jsp" />">Gestion des utilisateurs</a>
		Gestion des questionnaires : <c:redirect url="/WEB-INF/manageQuest.jsp" />
		<%--<a href="<c:url value="/MemberPages/AdminPages/manageUsers.jsp" />">Gestion des utilisateurs</a>  --%>
		<%--<a href="<c:url value="/MemberPages/AdminPages/manageUsers.jsp" />">Gestion des utilisateurs</a>  --%>
		
	</body>
	
</html>