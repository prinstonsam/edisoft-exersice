<%@ page import="com.prinstonsam.edisoft.model.TypeTransmission" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Типы трансмиссий</title>
</head>
<body>
<%
    List<TypeTransmission> typeTransmissions = (List<TypeTransmission>) request.getAttribute("typetransmissions");
%>

Список типов кузовов:
<ul>
    <%for (TypeTransmission typeTransmission : typeTransmissions) {%>
    <li><%=typeTransmission.getName()%> <a href="deleteformtype?type=typetransmission&id=<%=typeTransmission.getId()%>">Удалить</a></li>
    <%}%>
</ul>
<form action="jsp/addformtype.jsp" method="post">
    <input type="hidden" name="addformtype" value="typetransmission"/>
    <input type="submit" name="submit" value="Добавить"/>
</form>

</body>
</html>
