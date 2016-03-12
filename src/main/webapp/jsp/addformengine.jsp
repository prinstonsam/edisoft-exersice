<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление двигателя</title>
</head>
<body>
Добавить кузов
<br/>
<c:out value="${requestScope.typeengines}" />
<form action="./addformtype" method="post">
    <table cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td align="right>">Серийный номер</td>
            <td>
                <input type="text" name="serialnumber"> <br/>
            </td>
        </tr>
        <tr>
            <td align="right>">Объем</td>
            <td>
                <input type="text" name="volume"> <br/>
            </td>
        </tr>
        <tr>
            <td align="right>">Мощность</td>
            <td>
                <input type="text" name="power"> <br/>
            </td>
        </tr>
        <tr>
            <td align="right>">Тип двигателя:</td>
            <td>
                <select name="idtypeengine">
                    <c:forEach items="${requestScope.typeengines}" var="typeEngine">
                    <option value="${typeEngine.id}">${typeEngine.name}</option>
                    </c:forEach>
            </td>
        </tr>
    </table>
    <input type="hidden" name="addformtype" value="engine"/>
    <br/>
    <input type="submit" name="submit" value="Сохранить"/>
</form>
</body>
</html>
