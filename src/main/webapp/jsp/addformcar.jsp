<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сборка автомобиля</title>
</head>
<body>
Собрать автомобиль
<br/>
<form action="./addformtype" method="post">
    <table cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td align="right>">Серийный номер</td>
            <td>
                <input type="text" name="serialnumber"> <br/>
            </td>
        </tr>
        <tr>
            <td align="right>">Двигатель:</td>
            <td>
                <select name="idengine">
                    <c:forEach items="${requestScope.engines}" var="engine">
                    <option value="${engine.id}">${engine.serialNumber}</option>
                    </c:forEach>
            </td>
        </tr>
        <tr>
            <td align="right>">Кузов:</td>
            <td>
                <select name="idbody">
                    <c:forEach items="${requestScope.bodies}" var="body">
                    <option value="${body.id}">${body.vin}</option>
                    </c:forEach>
            </td>
        </tr>
        <tr>
            <td align="right>">Трансмиссия:</td>
            <td>
                <select name="idtransmission">
                    <c:forEach items="${requestScope.transmissions}" var="transmission">
                    <option value="${transmission.id}">${transmission.serialNumber}</option>
                    </c:forEach>
            </td>
        </tr>
    </table>
    <input type="hidden" name="addformtype" value="car"/>
    <br/>
    <input type="submit" name="submit" value="Сохранить"/>
</form>
</body>
</html>
