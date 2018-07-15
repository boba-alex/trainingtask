<%--
  Created by IntelliJ IDEA.
  User: polishchukam
  Date: 05.05.2018
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Форма ввода персоны</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<form name="add-collaborator-form" action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="save-collaborator"/>
    <table class="mysimpletable-table">
        <thead>
        <tr>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Идентификатор</td>
            <td><input type="text" readonly name="id"
                       value="${requestScope.collaborator != null ? requestScope.collaborator.id : ''}"></td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td><input type="text" name="surname" id="surname"
                       value="${requestScope.collaborator != null ? requestScope.collaborator.surname : ''}" required
                       pattern="[a-zA-Z\u0400-\u044F\u0451]+([-. ']{1}[a-zA-Z\u0400-\u044F\u0451]{1,})*" title="Пожалуйста, введите минимум 1 букву. Далее можно вводить в цикле -. ' и затем произвольное количество(<=20) букв." minlength="1" maxlength="20">
            </td>
        </tr>
        <tr>
            <td>Имя</td>
            <td><input type="text" name="name"
                       value="${requestScope.collaborator != null ? requestScope.collaborator.name : ''}" required
                       pattern="[a-zA-Z\u0400-\u044F\u0451]+([-. ']{1}[a-zA-Z\u0400-\u044F\u0451]{1,})*" title="Пожалуйста, введите минимум 1 букву. Далее можно вводить в цикле -. ' и затем произвольное количество(<=20) букв." minlength="1" maxlength="20"></td>
        </tr>
        <tr>
            <td>Отчество</td>
            <td><input type="text" name="patronymic"
                       value="${requestScope.collaborator != null ? requestScope.collaborator.patronymic : ''}" required
                       pattern="[a-zA-Z\u0400-\u044F\u0451]+([-. ']{1}[a-zA-Z\u0400-\u044F\u0451]{1,})*" title="Пожалуйста, введите минимум 1 букву. Далее можно вводить в цикле -. ' и затем произвольное количество(<=20) букв." minlength="1" maxlength="20"></td>
        </tr>
        <tr>
            <td>Должность</td>
            <td><input type="text" name="position"
                       value="${requestScope.collaborator != null ? requestScope.collaborator.position : ''}" required
                       pattern="[a-zA-Z\u0400-\u044F\u0451]+([-. ']{1}[a-zA-Z\u0400-\u044F\u0451]{1,})*" title="Пожалуйста, введите минимум 1 букву. Далее можно вводить в цикле -. ' и затем произвольное количество(<=20) букв." minlength="1" maxlength="20"></td>
        </tr>
        </tbody>
    </table>
    <br><br>
    <p class="center-p">
        <c:url var="cancel" value="${pageContext.request.contextPath}/controller">
            <c:param name="command" value="cancel-collaborator"/>
        </c:url>
        <a href="${cancel}" style="text-decoration: none" class="mybutton">Отмена</a>
        <input type="submit" name="buttonSave" value="Сохранить" class="mybutton"/>
    </p>
</form>
</body>
</html>
