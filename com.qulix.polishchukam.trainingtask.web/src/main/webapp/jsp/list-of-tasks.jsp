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
    <title>Список задач</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="mypadding-div">
    <c:url var="addLink" value="${pageContext.request.contextPath}/controller">
        <c:param name="command" value="add-task"/>
    </c:url>
    <a href="${addLink}">
        <button class="mybutton">Добавить</button>
    </a>
</div>
<jsp:useBean id="taskService" class="service.TaskService"/>
<table class="mytable-table mytable-table-horizontal mytable-table-highlight">
    <thead>
    <tr>
        <th>Идентификатор</th>
        <th>Проект (Сокращенное название)</th>
        <th>Название</th>
        <th>Дата начала</th>
        <th>Дата окончания</th>
        <th>Исполнитель (ФИО)</th>
        <th>Статус</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="eachTask" items="${taskService.tasks}">
        <c:url var="editLink" value="${pageContext.request.contextPath}/controller">
            <c:param name="task-id" value="${eachTask.id}"/>
            <c:param name="command" value="edit-task"/>
        </c:url>
        <c:url var="deleteLink" value="${pageContext.request.contextPath}/controller">
            <c:param name="task-id" value="${eachTask.id}"/>
            <c:param name="command" value="delete-task"/>
        </c:url>
        <tr>
            <td>${eachTask.id}</td>
            <td>${eachTask.project.shortName}</td>
            <td>${eachTask.name}</td>
            <td>${eachTask.beginTime}</td>
            <td>${eachTask.endTime}</td>
            <td>${eachTask.collaborator.surname} ${eachTask.collaborator.name} ${eachTask.collaborator.patronymic}</td>
            <td>
                <c:if test="${eachTask.taskStatus == 'NOT_STARTED'}">Не начата</c:if>
                <c:if test="${eachTask.taskStatus == 'IN_PROGRESS'}">В процессе</c:if>
                <c:if test="${eachTask.taskStatus == 'COMPLETED'}">Завершена</c:if>
                <c:if test="${eachTask.taskStatus == 'POSTPONED'}">Отложена</c:if>
            </td>
            <td><a href="${editLink}">Изменить</a></td>
            <td><a href="${deleteLink}"
                   onclick="if (!(confirm('Вы уверены, что хотите удалить эту задачу?'))) return false">Удалить
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
