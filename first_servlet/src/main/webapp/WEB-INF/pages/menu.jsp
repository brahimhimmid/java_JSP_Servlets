<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>page de menu</title>
    <jsp:useBean id="user" scope="session" type="modele.Utilisateur"/> >
    <jsp:useBean id="utilisateurs" scope="request" type="java.util.Collection<modele.Utilisateur>"/>
</head>
<body>
<h1> Bonjour ${user.pseudo}, voici le  menu de jour </h1>
<ul>
    <li><a href="/authentification/deconnexion">Deconnexion</a> </li>
</ul>
Liste des utilisateurs inscrits
<ul>
    <c:forEach items="${utilisateurs}" var="x">

        <li>${x.pseudo}</li>

    </c:forEach>

</ul>

</body>
</html>
