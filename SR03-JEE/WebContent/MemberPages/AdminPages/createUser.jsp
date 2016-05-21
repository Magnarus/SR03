<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Création d'un utilisateur</title>
		<link type="text/css" rel="stylesheet" href="/SR03-JEE/WebContent/form.css" />
	</head>
		<body>
		<form method="post">
	            <fieldset>
	                <legend>Nouvel utilisateur</legend>
	                <label for="email">Email : <span class="requis"></span></label>
	                <input type="text" id="email" name="email" 
	               		 value="<c:out value="${utilisateur.email}"/>"  size="75" maxlength="75" />
	                <span class="erreur">${form.errors['email']}</span>
	                <br />
	
	                <label for="password">Mot de passe : <span class="requis"></span></label>
	                <input type="password" id="password" name="password" 
	                	value="<c:out value="${utilisateur.password}"/>" size="75" maxlength="20" />
	                <span class="erreur">${form.errors['password']}</span>
	                <br />
	                
	                <label for="lastname">Nom : <span class="requis"></span></label>
	                <input type="text" id="lastname" name="lastname" 
	                	value="<c:out value="${utilisateur.lastName}"/>" size="75" maxlength="75" />
	                <span class="erreur">${form.errors['lastname']}</span>
	                <br />
	                
	                <label for="firstname">Prénom : <span class="requis"></span></label>
	                <input type="text" id="firstname" name="firstname" 
	                	value="<c:out value="${utilisateur.firstName}"/>" size="75" maxlength="75" />
	                <span class="erreur">${form.errors['firstname']}</span>
	                <br />
	                
	                <label for="admin"> Role : <span class="requis"></span></label>
	                <input type="radio" name="admin" value="admin" /> Administrateur 
	                <input type="radio" name="admin" value="stagiaire" checked/> Stagiaire <br/>
	                
	               	                
	                <input type="submit" value="Créer" class="sansLabel" /> <br />
	                <p class="${empty form.errors ? 'succes' : 'erreur'}">${form.result}</p>
	                <br />
	            </fieldset>
	        </form>	
	</body>
</html>