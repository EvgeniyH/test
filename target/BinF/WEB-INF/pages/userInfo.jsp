<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Jenya
  Date: 05.06.2017
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отображение перед сохранением</title>
</head>
<body>
<h4 align="center" style="font: 14px Arial; color: blue">Вывод данных</h4>
<table cellpadding="3" cellspacing="3" rules="all" width="400" style="font: 12px Arial">
    <tr>
        <th>Id пользователя </th>
        <td align="right">${userJSP.id}</td>
    </tr>
    <tr>
        <th>Ф.И.О </th>
        <td align="right">${userJSP.fio}</td>
    </tr>
    <tr>
        <th>Дата и время ввода </th>
        <td align="right">${userJSP.date}</td>
    </tr>
</table>
<br>
<spring:form action="/" method="get">
    <button type="submit">Вернуться к вводу данных</button>
</spring:form>
<%--<button type="button">Показать предыдущие записи</button>--%>
<div>
    <table border="1" cellspacing="3" cellpadding="3" rules="all" style="font: 11px Arial;">
        <tr>
            <td>Идентификатор</td>
            <td>Ф.И.О</td>
            <td>Дата и время ввода</td>
        </tr>
        <c:forEach items="${datas}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.fio}</td>
                <td><ftm:formatDate value="${user.date}" pattern="dd.MM.yyyy HH:mm:ss"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
