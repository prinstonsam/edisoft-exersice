<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Двигатели</title>
</head>
<body>
Список двигателей:
<table cellpadding="0" border="1">
    <tr>
        <th>Серийный номер</th>
        <th>Объем</th>
        <th>Можность л/с</th>
        <th>Тип двигателя</th>
    </tr>
    <c:forEach var="engine" items="${requestScope.engines}">
        <tr>
            <td><c:out value="${engine.serialNumber}"></c:out></td>
            <td><c:out value="${engine.volume}"></c:out></td>
            <td><c:out value="${engine.power}"></c:out></td>
            <td><c:out value="${engine.typeEngine.name}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<form action="./addengine" method="post">
    <input type="submit" name="submit" value="Добавить"/>
</form>
</body>
</html>
