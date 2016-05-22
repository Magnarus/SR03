<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		 <link type="text/css" rel="stylesheet" href="../../form.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Passage du questionnaire</title>
	</head>
	<body>
		<form method="post">
			 <fieldset>
                <legend> Question </legend>
              
                <label for="question"> <c:out value='${questionInformations.title }' /> : <span class="requis"></span></label>
                <c:forEach var="answer"  items="${requestScope['questionInformations'].answers}">
                	<input type="radio" name="question" value="${answer.value}" /> ${answer.value}
                </c:forEach>
                <br />
                <input type="submit" value="Créer" class="sansLabel" /> <br />
            </fieldset>
		
		</form>
	</body>
</html>