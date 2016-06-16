<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Création Annonce</title>
	</head>
	
	<body>
	
		<form method="POST">
			<label for="action">Que souhaitez-vous faire : </label>
				<select name="action">
					<option value="add">Créer annonce</option>
					<option value="mod">Modifier annonce</option>
					<option value="del">Supprimer annonce</option>
				</select><br />
				<input type="submit" value="envoyer" />
		</form>
		
	</body>
	
</html>