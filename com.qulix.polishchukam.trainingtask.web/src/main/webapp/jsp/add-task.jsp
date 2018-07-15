<%--
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
    <title>Add task</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<jsp:useBean id="projectService" class="service.ProjectService"/>
<jsp:useBean id="collaboratorService" class="service.CollaboratorService"/>
<form name="add-task-form" action="${pageContext.request.contextPath}/controller" method="GET">
    <input type="hidden" name="command" value="save-task"/>
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
                       value="${sessionScope.task != null ? sessionScope.task.id : ''}"></td>
        </tr>
        <tr>
            <td>Project</td>
            <td>
                <select name="project-id" ${!empty sessionScope.project ? ' disabled="true"' : ''} id="select-id">
                    <c:forEach var="eachProject" items="${projectService.projects}">
                        <option value="${eachProject.id}" ${eachProject.id == sessionScope.project.id ? 'selected="selected"' : ''}>
                                ${eachProject.name}, ${eachProject.shortName}
                        </option>
                    </c:forEach>
                </select>
                <input type="hidden" name="project-id" id="proj-id"/>;
                <script>
                     document.getElementById("proj-id").value = document.getElementById("select-id").value;
                </script>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"
                       value="${sessionScope.task != null ? sessionScope.task.name : ''}" required
                       pattern="[a-zA-Zа-яА-Я]{2,}(\s{1}[a-zA-Zа-яА-Я]{1,})*"
                       title="Please, enter at least 2 characters, then 1 space and words(at least 1 character)"></td>
        </tr>
        <tr>
            <td>Work in hours</td>
            <td><input type="text" name="work-in-hours"
                       value="${sessionScope.task != null ? sessionScope.task.workInHours : ''}" required
                       pattern="[0-9]*" title="Please, enter integer numbers"></td>
        </tr>
        <tr>
            <td>Start date</td>
            <td><input type="date" name="begin-time"
                       value="${sessionScope.task != null ? sessionScope.task.beginTime : ''}" required min="1970-01-01"
                       max="3000-01-01"></td>
        </tr>
        <tr>
            <td>Finish date</td>
            <td><input type="date" name="end-time"
                       value="${sessionScope.task != null ? sessionScope.task.endTime : ''}" required min="1970-01-01"
                       max="3000-01-01"></td>
        </tr>
        <tr>
            <td>Task status</td>
            <td>
                <select name="task-status">
                    <option value="NOT_STARTED" ${sessionScope.task.taskStatus == 'NOT_STARTED' ? 'selected="selected"' : ''}>
                        NOT_STARTED
                    </option>
                    <option value="IN_PROGRESS" ${sessionScope.task.taskStatus == 'IN_PROGRESS' ? 'selected="selected"' : ''}>
                        IN_PROGRESS
                    </option>
                    <option value="COMPLETED" ${sessionScope.task.taskStatus == 'COMPLETED' ? 'selected="selected"' : ''}>
                        COMPLETED
                    </option>
                    <option value="POSTPONED" ${sessionScope.task.taskStatus == 'POSTPONED' ? 'selected="selected"' : ''}>
                        POSTPONED
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Collaborator</td>
            <td>
                <select name="collaborator-id">
                    <c:forEach var="eachCollaborator" items="${collaboratorService.collaborators}">
                        <option value="${eachCollaborator.id}" ${eachCollaborator.id == sessionScope.task.collaborator.id ? 'selected="selected"' : ''}>
                                ${eachCollaborator.surname}, ${eachCollaborator.name}, ${eachCollaborator.patronymic}, ${eachCollaborator.position}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        </tbody>
    </table>
    <br><br>
    <p class="center-p">
        <a href="list-of-tasks.jsp" style="text-decoration: none" class="mybutton">Cancel</a>
        <input type="submit" name="buttonAddTask" value="Save" class="mybutton"/>
    </p>
</form>
</body>
</html>
