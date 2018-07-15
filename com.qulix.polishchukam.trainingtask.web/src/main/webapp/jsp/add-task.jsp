<%@ page import="java.util.Enumeration" %><%--
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
    <title>Форма ввода задачи</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<jsp:useBean id="projectService" class="service.ProjectService"/>
<jsp:useBean id="collaboratorService" class="service.CollaboratorService"/>
<form name="add-task-form" action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="save-task"/>
    <c:if test="${not empty param['from-project-form']}">
        <input type="hidden" name="from-project-form" value="${param['from-project-form']}">
    </c:if>
    <c:if test="${not empty param['project-is-new']}">
        <input type="hidden" name="project-is-new" value="${param['project-is-new']}">
    </c:if>
    <c:if test="${not empty sessionScope.project}">
        <input type="hidden" name="project-name" value="${sessionScope.project.name}">
        <input type="hidden" name="project-short-name" value="${sessionScope.project.shortName}">
        <input type="hidden" name="project-description" value="${sessionScope.project.description}">
    </c:if>
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
                       value="${requestScope.task != null ? requestScope.task.id : ''}"></td>
        </tr>
        <tr>
            <td>Проект</td>
            <td>
                <c:choose>
                    <c:when test="${not empty param['from-project-form']}">
                        <select name="project-id" disabled="disabled" id="select-id">
                            <option value="${sessionScope.project.id}" selected="selected">
                                    ${sessionScope.project.name}, ${sessionScope.project.shortName}
                            </option>
                        </select>
                    </c:when>
                    <c:otherwise>
                        <select name="project-id" id="select-id" required>
                            <c:forEach var="eachProject" items="${projectService.projects}">
                                <option value="${eachProject.id}" ${eachProject.id == requestScope.task.project.id ? 'selected="selected"' : ''}>
                                        ${eachProject.name}, ${eachProject.shortName}
                                </option>
                            </c:forEach>
                        </select>
                    </c:otherwise>
                </c:choose>
                <input type="hidden" name="project-id" id="proj-id"/>
            </td>
        </tr>
        <tr>
            <td>Название</td>
            <td><input type="text" name="name"
                       value="${requestScope.task != null ? requestScope.task.name : ''}" required
                       pattern="[0-9a-zA-Z\u0400-\u044F\u0451]+([0-9a-zA-Z\u0400-\u044F\u0451' _.,;-]{1,})*"
                       title="Пожалуйста, введите минимум 1 букву или цифру. Далее можно вводить произвольное количество(<=50) букв, цифр и символы(вместо двойных кавычек используйте одинарные) ' _.,;-" maxlength="50">
            </td>
        </tr>
        <tr>
            <td>Работа в часах</td>
            <td><input type="number" name="work-in-hours"
                       value="${requestScope.task != null ? requestScope.task.workInHours : ''}" required
                       pattern="[0-9]*" title="Пожалуйста, введите целое неотрицательное число." min="0" max="10000"> </td>
        </tr>
        <tr>
            <td>Дата начала</td>
            <td><input type="date" name="begin-time" id="begin-time-id"
                       value="${requestScope.task != null ? requestScope.task.beginTime : ''}" required min="1970-01-01"
                       max="3000-01-01"></td>
        </tr>
        <tr>
            <td>Дата окончания</td>
            <td><input type="date" name="end-time" id="end-time-id"
                       value="${requestScope.task != null ? requestScope.task.endTime : ''}" required min="1970-01-01"
                       max="3000-01-01"></td>
        </tr>
        <tr>
            <td>Статус</td>
            <td>
                <select name="task-status">
                    <option value="NOT_STARTED" ${requestScope.task.taskStatus == 'NOT_STARTED' ? 'selected="selected"' : ''}>
                        Не начата
                    </option>
                    <option value="IN_PROGRESS" ${requestScope.task.taskStatus == 'IN_PROGRESS' ? 'selected="selected"' : ''}>
                        В процессе
                    </option>
                    <option value="COMPLETED" ${requestScope.task.taskStatus == 'COMPLETED' ? 'selected="selected"' : ''}>
                        Завершена
                    </option>
                    <option value="POSTPONED" ${requestScope.task.taskStatus == 'POSTPONED' ? 'selected="selected"' : ''}>
                        Отложена
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Исполнитель</td>
            <td>
                <select name="collaborator-id" required>
                    <c:forEach var="eachCollaborator" items="${collaboratorService.collaborators}">
                        <option value="${eachCollaborator.id}" ${eachCollaborator.id == requestScope.task.collaborator.id ? 'selected="selected"' : ''}>
                                ${eachCollaborator.surname} ${eachCollaborator.name} ${eachCollaborator.patronymic}, ${eachCollaborator.position}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        </tbody>
    </table>
    <br><br>
    <p class="center-p">
        <c:url var="cancel" value="${pageContext.request.contextPath}/controller">
            <c:param name="command" value="cancel-task"/>
            <c:if test="${not empty param['from-project-form']}">
                <c:param name="from-project-form" value="from-project-form"/>
            </c:if>
            <c:if test="${not empty param['project-is-new']}">
                <c:param name="project-is-new" value="project-is-new"/>
            </c:if>
        </c:url>
        <a href="${cancel}" style="text-decoration: none" class="mybutton">Отмена</a>
        <input type="submit" name="buttonSave" value="Сохранить" class="mybutton" onclick="return DateCheck()"/>
    </p>
</form>
<script type="text/javascript" src="../js/add-task.js"></script>
</body>
</html>
