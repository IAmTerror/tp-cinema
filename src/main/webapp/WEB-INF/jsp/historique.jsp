<%--
  Created by IntelliJ IDEA.
  User: cyril
  Date: 14/11/2018
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Historique</title>
</head>
<body>
<h1>Historique des films consultés : </h1>
<c:forEach items="${films}" var="film">
    <a href=\detail?id=${film.id}>${film.titre} (${film.note})</a>
    <br />
</c:forEach>
</body>
</html>
