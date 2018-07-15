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
    <title>List of tasks</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="mypadding-div">
    <c:url var="addLink" value="${pageContext.request.contextPath}/controller">
        <c:param name="command" value="add-task"/>
    </c:url>
    <a href="${addLink}">
        <button class="mybutton">Add+</button>
    </a>
</div>
<jsp:useBean id="taskService" class="service.TaskService"/>
<table class="mytable-table mytable-table-horizontal mytable-table-highlight">
    <thead>
    <tr>
        <th>Id</th>
        <th>Project short name</th>
        <th>Name</th>
        <th>Start date</th>
        <th>Finish date</th>
        <th>Surname</th>
        <th>Name</th>
        <th>Patronymic</th>
        <th>Status</th>
        <th>Edit</th>
        <th>Delete</th>
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
            <td>${eachTask.collaborator.surname}</td>
            <td>${eachTask.collaborator.name}</td>
            <td>${eachTask.collaborator.patronymic}</td>
            <td>${eachTask.taskStatus}</td>
            <td><a href="${editLink}">Edit</a></td>
            <td><a href="${deleteLink}"
                   onclick="if (!(confirm('Are u sure u want to delete this task?'))) return false">Delete
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
