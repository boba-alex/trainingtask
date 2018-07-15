<%@ page import="entity.Project" %><%--
  Created by IntelliJ IDEA.
  User: polishchukam
  Date: 05.05.2018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add project</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<jsp:useBean id="taskService" class="service.TaskService"/>
<form name="add-project-form" action="${pageContext.request.contextPath}/controller" method="GET"
      id="add-project-form-id">
    <input type="hidden" name="command" value="save-project"/>
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
                       value="${sessionScope.project != null ? sessionScope.project.id : ''}"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"
                       value="${sessionScope.project != null ? sessionScope.project.getName() : ''}" required
                       pattern="[a-zA-Zа-яА-Я]{2,}(\s{1}[a-zA-Zа-яА-Я]{1,})*"
                       title="Please, enter at least 2 characters, then 1 space and words(at least 1 character)"></td>
        </tr>
        <tr>
            <td>Short name</td>
            <td><input type="text" name="short-name"
                       value="${sessionScope.project != null ? sessionScope.project.shortName : ''}" required
                       pattern="[a-zA-Zа-яА-Я]{2,}" title="Please, enter at least 2 characters"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><textarea name="description" form="add-project-form-id" cols="30"
                          rows="10">${sessionScope.project != null ? sessionScope.project.description : ''}</textarea>
            </td>
        </tr>

        <tr>
            <td>Tasks</td>
            <td>
                <div class="mypadding-div">
                    <c:url var="addLink" value="${pageContext.request.contextPath}/controller">
                        <c:param name="command" value="add-task"/>
                    </c:url>
                    <a href="${addLink}" class="mybutton">Add task+</a>
                </div>
            </td>
        </tr>

        <c:forEach var="eachTask"
                   items="${sessionScope.project != null ? taskService.getTasksByProject(sessionScope.project) : ''}">
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
    <br><br>
    <p class="center-p">
        <a href="list-of-projects.jsp" style="text-decoration: none" class="mybutton">Cancel</a>
        <input type="submit" name="buttonAddProject" value="Save" class="mybutton"/>
    </p>
</form>
</body>
</html>
