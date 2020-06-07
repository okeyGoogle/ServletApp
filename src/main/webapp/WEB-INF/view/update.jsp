<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 07.06.2020
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Servlet</title>
</head>
<body>

<div>Имя: <c:out value="${requestScope.user.name}"/></div>
<div>Возраст: <c:out value="${requestScope.user.age}"/></div>
<br />

<form method="post" action="/update">
    <label>Новое имя: <input type="text" name="name" /></label><br>

    <input type="number" hidden="true" name="id" value="${requestScope.user.id}"/>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
