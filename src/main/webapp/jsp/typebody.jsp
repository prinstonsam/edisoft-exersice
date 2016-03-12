<%@ page import="java.util.List"%>
<%@ page import="com.prinstonsam.edisoft.model.TypeBody" %>
<%@ page import="com.prinstonsam.edisoft.model.Body" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Типы кузовов</title>
    </head>
    <body>
        <%
            List<TypeBody> typeBodies = (List<TypeBody>)request.getAttribute("typebodies");
        %>

        Список типов кузовов:
        <ul>
            <%for (TypeBody typeBody :typeBodies){%>
            <li><%=typeBody.getName()%> <a href="deleteformtype?type=typebody&id=<%=typeBody.getId()%>">Удалить</a></li>
            <%}%>
        </ul>
        <form action="jsp/addformtype.jsp" method="post" >
            <input type="hidden" name="addformtype" value="typebody"/>
            <input type="submit" name="submit" value="Добавить"/>
        </form>

    </body>
</html>
