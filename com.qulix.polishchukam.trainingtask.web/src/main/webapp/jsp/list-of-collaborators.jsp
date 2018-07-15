<%--
  Created by IntelliJ IDEA.
  User: polishchukam
  Date: 05.05.2018
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список сотрудников</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="mypadding-div">
    <c:url var="addLink" value="${pageContext.request.contextPath}/controller">
        <c:param name="command" value="add-collaborator"/>
    </c:url>
    <a href="${addLink}">
        <button class="mybutton">Добавить</button>
    </a>
</div>
<jsp:useBean id="collaboratorService" class="service.CollaboratorService"/>
<table class="mytable-table mytable-table-horizontal mytable-table-highlight">
    <thead>
    <tr>
        <th>Идентификатор</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Должность</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="eachCollaborator" items="${collaboratorService.collaborators}">
        <c:url var="editLink" value="${pageContext.request.contextPath}/controller">
            <c:param name="collaborator-id" value="${eachCollaborator.id}"/>
            <c:param name="command" value="edit-collaborator"/>
        </c:url>
        <c:url var="deleteLink" value="${pageContext.request.contextPath}/controller">
            <c:param name="collaborator-id" value="${eachCollaborator.id}"/>
            <c:param name="command" value="delete-collaborator"/>
        </c:url>
        <tr>
            <td>${eachCollaborator.id}</td>
            <td>${eachCollaborator.surname}</td>
            <td>${eachCollaborator.name}</td>
            <td>${eachCollaborator.patronymic}</td>
            <td>${eachCollaborator.position}</td>
            <td><a href="${editLink}">Изменить</a></td>
            <td><a href="${deleteLink}"
                   onclick="if (!(confirm('Вы уверены, что хотите удалить этого сотрудника?'))) return false">Удалить
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
