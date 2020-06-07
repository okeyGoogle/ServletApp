<%--
  Created by IntelliJ IDEA.
  User: Alen
  Date: 10.05.2020
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ServletApp</title>
</head>
<body>
    <h2>Список пользователей</h2><br />

<c:forEach var="user" items="${requestScope.users}">
    <ul>
        <li>Имя: <c:out value="${user.name}"/></li>

        <li>Возраст: <c:out value="${user.age}"/></li>

        <form method="post" action="<c:url value='/delete'/>">
            <input type="number" hidden="true" name="id" value="${user.id}"/>
            <input type="submit" name="delete" value="Удалить"/>
        </form>

        <form method="get" action="<c:url value='/update'/>">
            <input type="number" hidden="true" name="id" value="${user.id}" />
            <input type="submit" name="update" value="Редактировать"/>
        </form>
    </ul>
    <hr/>
</c:forEach>



<h2>Создание нового пользователя</h2><hr/>
<form method="post" action="<c:url value='/add_user'/>">
    <label><input type="text" name="name">Имя</label><br>
    <label><input type="number" name="age">Возраст</label><br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
