<%--
  Created by IntelliJ IDEA.
  User: ibrah
  Date: 15/01/2024
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page de connexion</title>
    <jsp:useBean id="erreur" type="java.lang.String" scope="request" class="java.lang.String"/>
</head>
<body>
<span style="color: red">
    ${erreur}
</span>
<!--dans action on met url gérer par le controleur -->
<form method="post" action="/authentification/connexion">
   <label for="field:pseudo">Saisir votre pseudo</label>
    <input name="pseudo" id="field:pseudo" type="text">
    <label for="field:password">Saisir votre password</label>
    <input name="password" id="field:password" type="password">
    <input type="submit">


</form>

</body>
</html>
