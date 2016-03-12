<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление трансмиссии</title>
</head>
<body>
Добавить трансмиссию
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
            <td align="right>">Тип трансмиссии:</td>
            <td>
                <select name="idtypetransmission">
                    <c:forEach items="${requestScope.typetransmissions}" var="typetransmission">
                    <option value="${typetransmission.id}">${typetransmission.name}</option>
                    </c:forEach>
            </td>
        </tr>
    </table>
    <input type="hidden" name="addformtype" value="transmission"/>
    <br/>
    <input type="submit" name="submit" value="Сохранить"/>
</form>
</body>
</html>
