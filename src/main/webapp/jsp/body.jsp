
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список кузовов</title>
</head>
<body>

Список кузовов:
<table cellpadding="0" border="1">
    <tr>
        <th>VIN</th>
        <th>Тип кузова</th>
        <th>Цвет</th>
        <th>Количество дверей</th>
    </tr>
    <c:forEach var="body" items="${requestScope.bodies}">
        <tr>
            <td><c:out value="${body.vin}"></c:out></td>
            <td><c:out value="${body.color}"></c:out></td>
            <td><c:out value="${body.typeBody.name}"></c:out></td>
            <td><c:out value="${body.countDoors}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<form action="./addbody" method="post">
    <input type="submit" name="submit" value="Добавить"/>
</form>
</body>
</html>
