<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1> Listes des questionnaires disponibles </h1>
		<!--  Affichage des questionnaires existants -->
		<p> Questionnaires existants </p>	
		<table>
			<tr>
				<th> Sujet </th>
				<th> Questionnaire </th>
				<th> Date </th>
				<th> Durée </th>
				<th> Score </th>
			</tr>
			<c:forEach var="run"  items="${requestScope['listRun']}" >
				<tr>
			          <td> ${run.quest.subject } </td>
			          <td> ${run.quest.name } </td>
			          <td> ${run.date }  </td>
			          <td> ${run.duration }  </td>
			          <td> ${run.score }  </td>
			    </tr>
			</c:forEach>
		</table>
</body>
</html>