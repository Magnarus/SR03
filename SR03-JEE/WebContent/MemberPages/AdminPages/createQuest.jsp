<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cr�ation d'un questionnaire</title>
		        <link type="text/css" rel="stylesheet" href="../../form.css" />
	</head>
	<body>
		<form method="post" action="createQuest">
            <fieldset>
                <legend>Cr�ation d'un questionnaire</legend>
                <p>Cr�ation d'un questionnaire : </p>

                <label for="title">Titre : <span class="requis"></span></label>
                <input type="text" id="title" name="title" size="20" maxlength="60" />
                <br />

                <label for="subject">Sujet : <span class="requis"></span></label>
                <input type="text" id="subject" name="subject" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Cr�er" class="sansLabel" />
                <br />
            </fieldset>
        </form>
	</body>
</html>