<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String addFormType = request.getParameter("addformtype");
        if (addFormType!=null && addFormType.equals("typebody"))
            out.println("Добавить тип кузова");
        if (addFormType!=null && addFormType.equals("typeengine"))
            out.println("Добавить тип двигателя");
        if (addFormType!=null && addFormType.equals("typetransmission"))
            out.println("Добавить тип трансмиссии");
    %>
    <br/>
    <form action="../addformtype" method="post">
        <table cellpadding="0" cellspacing="0" border="0">
            <tr>
                <td align="right>">Название: </td>
                <td>
                    <input type="text" name="name"> <br/>
                </td>
            </tr>
        </table>
        <input type="hidden" name="addformtype" value=<%=addFormType%> />
        <br/>
        <input type="submit" name="submit" value="Сохранить"/>
    </form>
</body>
</html>
