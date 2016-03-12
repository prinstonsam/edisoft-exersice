<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Трансмиссии</title>
</head>
<body>
Список трансмиссий
<table cellpadding="0" border="1">
    <tr>
        <th>Серийный номер</th>
        <th>Тип трансмиссии</th>
    </tr>
    <c:forEach var="transmission" items="${requestScope.transmissions}">
        <tr>
            <td><c:out value="${transmission.serialNumber}"></c:out></td>
            <td><c:out value="${transmission.typeTransmission.name}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<form action="./addtransmission" method="post">
    <input type="submit" name="submit" value="Добавить"/>
</form>
</body>
</html>
