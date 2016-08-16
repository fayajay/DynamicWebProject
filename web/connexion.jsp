<%-- 
    Document   : connexion
    Created on : 16 août 2016, 14:53:07
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>youhouhouhou</h1>
        <form method="POST">
                Nom : <input type="text" name="nom"/>
                Prenom : <input type="text" name="prenom"/><br/>

                <input type="submit" value="enregistrer"/>
                <input type="reset" value="annuler"/>
            </form>
        <a href="servletTest">Liste Etudiant</a>
    </body>
</html>
