<%--
  Created by IntelliJ IDEA.
  User: Jenya
  Date: 05.06.2017
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Начальная страница</title>
</head>
<body>
    <spring:form method="post" modelAttribute="userJSP" action="/check-user">
        <table border="1" cellpadding="3" cellspacing="3" rules="all">
            <tr>
                <td><spring:input path="id"/></td>
            </tr>
            <tr>
                <td><spring:input path="fio"/></td>
            </tr>
            <tr>
                <td align="right"><spring:button>Сохранить</spring:button></td>
            </tr>
        </table>
    </spring:form>
</body>
</html>
