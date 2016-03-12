<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат выполнения операции</title>
</head>
<body>
<%
    String typePart = (String) request.getAttribute("typepart");
    String pageBack = "";
    String message = "";
    if (typePart != null && typePart.equals("typebody")) {
        pageBack = "./typebody";
        String typeAction = (String) request.getAttribute("typeaction");
        if (typeAction != null && !typeAction.equals("")) {
            message = "Тип кузова удален";
        }
    }

    if (typePart != null && typePart.equals("typeengine")) {
        pageBack = "./typeengine";
        String typeAction = (String) request.getAttribute("typeaction");
        if (typeAction != null && !typeAction.equals("")) {
            message = "Тип двигателя удален";
        }
    }

    if (typePart != null && typePart.equals("typetransmission")) {
        pageBack = "./typetransmission";
        String typeAction = (String) request.getAttribute("typeaction");
        if (typeAction != null && !typeAction.equals("")) {
            message = "Тип трансмиссии удален";
        }
    }

    if (typePart == null) {
        message = "Возникла проблема при получении типа операции";
    }
%>

<%
    out.println(message);
    out.println("<br/>");
%>
<a href="<%=pageBack%>">Назад</a>

</body>
</html>
