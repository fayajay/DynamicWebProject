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
                Id : <input type="text" name="numEt"/><br>
                Nom : <input type="text" name="nomEt"/>
                Prenom : <input type="text" name="prenomEt"/><br>
                Classe : <input type="text" name="idClasse"/><br>
                <input type="submit" value="enregistrer"/>
                <input type="reset" value="annuler"/>
            </form>
        <a href="servletTest">Liste Etudiant</a>
    </body>
</html>
