<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Détail de l'utilisateur</title>
		<link type="text/css" rel="stylesheet" href="../../form.css" />
	</head>
	<body>
		
		<h2> Détail de l'utilisateur <c:out value='${user.firstName }' /> <c:out value='${user.lastName }' /> </h2>
		<form method = "POST">
			<fieldset>
	                <legend>Nouvel utilisateur</legend>
	                <label for="email">Email : <span class="requis"></span></label>
	                <input type="text" id="email" name="email" 
	               		 value="<c:out value="${user.email}"/>"  size="75" maxlength="75" />
	                <span class="erreur">${form.errors['email']}</span>
	                <br />
	
	                <label for="password">Mot de passe : <span class="requis"></span></label>
	                <input type="password" id="password" name="password" 
	                	value="<c:out value="${user.password}"/>" size="75" maxlength="20" />
	                <span class="erreur">${form.errors['password']}</span>
	                <br />
	                
	                <label for="lastname">Nom : <span class="requis"></span></label>
	                <input type="text" id="lastname" name="lastname" 
	                	value="<c:out value="${user.lastName}"/>" size="75" maxlength="75" />
	                <span class="erreur">${form.errors['lastname']}</span>
	                <br />
	                
	                <label for="firstname">Prénom : <span class="requis"></span></label>
	                <input type="text" id="firstname" name="firstname" 
	                	value="<c:out value="${user.firstName}"/>" size="75" maxlength="75" />
	                <span class="erreur">${form.errors['firstname']}</span>
	                <br />

	                <label for="phonenumber">Téléphone : <span class="requis"></span></label>
	                <input type="text" id="phonenumber" name="phonenumber" 
	                	value="<c:out value="${user.phoneNumber}"/>" size="75" maxlength="75" />
	                <span class="erreur">${form.errors['phonenumber']}</span>
	                <br />
	                
	                <label for="company">Société : <span class="requis"></span></label>
	                <input type="text" id="company" name="company" 
	                	value="<c:out value="${user.company}"/>" size="75" maxlength="75" />
	                <span class="erreur">${form.errors['company']}</span>
	                <br />
	                	                
	                <label for="admin"> Role : <span class="requis"></span></label>
	                <input type="radio" name="admin" value="admin" 
	                	<c:if test="${ user['admin'] }">
								disabled="disabled"  checked="checked" </c:if>
	                /> Administrateur 
	                <input type="radio" name="admin" value="stagiaire"
	                	<c:if test="${ !user['admin'] }">
								 checked="checked" </c:if>
	                /> Stagiaire <br/>
	                
	                
	                <label for="state"> Etat : <span class="requis"></span></label>
	                <input type="radio" name="state" value="actif" 
	                	<c:if test="${ user['state'] }">
							  checked="checked" </c:if>
	                /> Actif 
	                <input type="radio" name="state" value="nactif"
	                	<c:if test="${ !user['state'] }">
								 checked="checked" </c:if>
	                /> Non actif <br/>
	               	                
	                <input type="submit" value="Mettre à jour" class="sansLabel" /> <br />
	                <p class="${empty form.errors ? 'succes' : 'erreur'}">${form.result}</p>
	                <br />
	            </fieldset>
	        </form>	
		
		
		</form>
	</body>
</html>