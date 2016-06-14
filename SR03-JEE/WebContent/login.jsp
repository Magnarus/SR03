<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Login page</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="login">
            <fieldset>
                <legend>Login page</legend>
                <p>Login page : </p>

                <label for="email">Email : <span class="requis"></span></label>
                <input type="text" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <br />

                <label for="password">Password : <span class="requis"></span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
    </body>
</html>