<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавление кузова</title>
</head>
<body>
Добавить кузов
<br/>
<form action="./addformtype" method="post">
    <table cellpadding="0" cellspacing="0" border="0">
        <tr>
            <td align="right>">VIN:</td>
            <td>
                <input type="text" name="vin"> <br/>
            </td>
        </tr>
        <tr>
            <td align="right>">Цвет:</td>
            <td>
                <input type="text" name="color"> <br/>
            </td>
        </tr>
        <tr>
            <td align="right>">Количество дверей:</td>
            <td>
                <input type="text" name="countdoors"> <br/>
            </td>
        </tr>
        <tr>
            <td align="right>">Тип кузова:</td>
            <td>
                <select name="idtypebody">
                    <c:forEach items="${requestScope.typebodies}" var="typeBody">
                        <option value="${typeBody.id}">${typeBody.name}</option>
                    </c:forEach>
            </td>
        </tr>
    </table>
    <input type="hidden" name="addformtype" value="body"/>
    <br/>
    <input type="submit" name="submit" value="Сохранить"/>
</form>
</body>
</html>
