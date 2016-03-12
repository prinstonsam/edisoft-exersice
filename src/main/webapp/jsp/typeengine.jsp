<%@ page import="com.prinstonsam.edisoft.model.TypeEngine" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Типы двигателей</title>
</head>
<body>
<%
    List<TypeEngine> typeEngines = (List<TypeEngine>) request.getAttribute("typeengines");
%>

Список типов кузовов:
<ul>
    <%for (TypeEngine typeEngine : typeEngines) {%>
    <li><%=typeEngine.getName()%> <a href="deleteformtype?type=typeengine&id=<%=typeEngine.getId()%>">Удалить</a></li>
    <%}%>
</ul>
<form action="jsp/addformtype.jsp" method="post">
    <input type="hidden" name="addformtype" value="typeengine"/>
    <input type="submit" name="submit" value="Добавить"/>
</form>

</body>
</html>
