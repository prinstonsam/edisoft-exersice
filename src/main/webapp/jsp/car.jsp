<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Автомобили</title>
</head>
<body>
Список автомобилей
<table cellpadding="0" border="1">
    <tr>
        <th>Серийный номер</th>
        <th>Двигатель</th>
        <th>Кузов</th>
        <th>Трансмиссия</th>
    </tr>
    <c:forEach var="car" items="${requestScope.cars}">
        <tr>
            <td><c:out value="${car.serialNumber}"></c:out></td>
            <td><c:out value="${car.engine.serialNumber}"></c:out></td>
            <td><c:out value="${car.body.vin}"></c:out></td>
            <td><c:out value="${car.transmission.serialNumber}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<form action="./addcar" method="post">
    <input type="submit" name="submit" value="Добавить"/>
</form>
</body>
</html>

