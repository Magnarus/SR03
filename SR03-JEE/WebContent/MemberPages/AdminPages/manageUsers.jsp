<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Gestions users</title>
	</head>
	<body>
		<p> Gestion des utilisateurs :</p>
		<c:out value="${test}" />
		
		<c:forEach items="${listUsers}" var="user" varStatus="status">
			<div class="user">
			  Utilisateur n° <c:out value="${user['id']}"/> :
			  <div class="email">
			      <c:out value="${user['email']}" />
			  </div>
			  <div class="password">
			      <c:out value="${news['password']}" />
			  </div>
			  <div class="lastname">
			      <c:out value="${user['email']}" />
			  </div>
			  <div class="firstname">
			      <c:out value="${news['password']}" />
			  </div>
			  <div class="email">
			      <c:out value="${user['admin']}" />
			  </div>
			</div>
			</c:forEach>
	</body>
</html>