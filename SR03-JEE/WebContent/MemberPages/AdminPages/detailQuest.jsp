<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" rel="stylesheet" href="../../form.css" />
		<title>Questions du questionnaire</title>
	</head>
	<body>
		<h1>Questions</h1>
		<table>
			<tr>
				<th> Nom </th>
				<th> Etat </th>
				<th> Action </th>
			</tr>
			<c:forEach var="q"  items="${requestScope['questions']}" >
				<tr>
		          	<td><a href="<c:url value="manageAnswer?id=${q.id}"/>" >${q.title} </a></td>
		          	<td>
			          	<c:choose>
			          		<c:when test="${q.state == true}"><a href="?id=${param.id}&questionId=${q.id}&state=0">Actif</a></c:when>
			          		<c:otherwise><a href="?id=${param.id}&questionId=${q.id}&state=1">Inactif</a></c:otherwise>
			          	</c:choose>
		          	</td>
		          	<td> 
		          		<form  method="POST"><input type="hidden" name="q_id" value="${q.id}"/><input value="Supprimer" type="submit"/></form>
		          	</td>
			    </tr>
			</c:forEach>
		</table>
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