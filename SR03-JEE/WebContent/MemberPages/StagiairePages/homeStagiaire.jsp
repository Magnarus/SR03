<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Accueil</title>
	</head>
	
	<body>
		<p> Accueil Stagiaire : </p>
		<a href="<c:url value="/MemberPages/StagiairePages/listQuest" />">Questionnaires</a><br/>
		<a href="<c:url value="/MemberPages/StagiairePages/listRun" />">Historique des parcours</a>
	</body>
</html>