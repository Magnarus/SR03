<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>R�capitulatif</title>
	</head>
	<body>
		<h2> Votre r�sultat au questionnaire : </h2>
		
		<c:forEach items="${result}" var="entry">
   			 <p> Question : ${entry.key.title } </p>
   			 <p>
	   			 <c:choose>
				    <c:when test="${entry.value==0}">
				        Vous avez r�pondu correctement. 
				    </c:when>    
				    <c:otherwise>
				        Vous n'avez pas r�pondu correctement
				    </c:otherwise>
				</c:choose>
			</p>
			
			<c:forEach items="${entry.key.answers}" var="answer">
				<input type="radio" name="answer" value="${answer.value}" 
					<c:choose>
					    <c:when test="${answer.id == entry.key.rightAnswer}">
					        checked="checked"
					    </c:when>    
					    <c:otherwise>
					        disabled="disabled"
					    </c:otherwise>
					</c:choose>
				/> ${answer.value}
			</c:forEach>
			
		</c:forEach>
		
		
	</body>
</html>