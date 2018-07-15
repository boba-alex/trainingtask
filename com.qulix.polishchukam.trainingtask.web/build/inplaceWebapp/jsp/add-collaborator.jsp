<%--
  Created by IntelliJ IDEA.
  User: polishchukam
  Date: 05.05.2018
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add collaborator</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<form name="add-collaborator-form" action="${pageContext.request.contextPath}/controller" method="GET">
    <input type="hidden" name="command" value="save-collaborator"/>
    <table class="mysimpletable-table">
        <thead>
        <tr>
            <th>Property</th>
            <th>Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Id</td>
            <td><input type="text" disabled="disabled" name="id"
                       value="${sessionScope.collaborator != null ? sessionScope.collaborator.id : ''}"></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><input type="text" name="surname" id="surname"
                       value="${sessionScope.collaborator != null ? sessionScope.collaborator.surname : ''}" required
                       pattern="[a-zA-Zа-яА-Я]{3,}" title="Please, enter at least 3 characters">
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"
                       value="${sessionScope.collaborator != null ? sessionScope.collaborator.name : ''}" required
                       pattern="[a-zA-Zа-яА-Я]{3,}" title="Please, enter at least 3 characters"></td>
        </tr>
        <tr>
            <td>Patronymic</td>
            <td><input type="text" name="patronymic"
                       value="${sessionScope.collaborator != null ? sessionScope.collaborator.patronymic : ''}" required
                       pattern="[a-zA-Zа-яА-Я]{3,}" title="Please, enter at least 3 characters"></td>
        </tr>
        <tr>
            <td>Position</td>
            <td><input type="text" name="position"
                       value="${sessionScope.collaborator != null ? sessionScope.collaborator.position : ''}" required
                       pattern="[a-zA-Zа-яА-Я]{2,}" title="Please, enter at least 2 characters"></td>
        </tr>
        </tbody>
    </table>
    <br><br>
    <p class="center-p">
        <a href="list-of-collaborators.jsp" style="text-decoration: none" class="mybutton">Cancel</a>
        <input type="submit" name="buttonAddCollaborator" value="Save" class="mybutton"/>
    </p>
</form>
</body>
</html>
