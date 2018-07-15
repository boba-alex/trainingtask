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
    <title>Форма ввода проекта</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<jsp:useBean id="taskService" class="service.TaskService"/>
<form name="add-project-form" action="${pageContext.request.contextPath}/controller" method="POST"
      id="add-project-form-id">
    <input type="hidden" name="command" value="save-project"/>
    <input type="hidden" name="from-project-form" value="from-project-form"/>
    <c:if test="${not empty param['project-is-new']}">
        <input type="hidden" name="project-is-new" value="${param['project-is-new']}">
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
                       value="${sessionScope.project != null ? sessionScope.project.id : ''}"></td>
        </tr>
        <tr>
            <td>Название</td>
            <td><input type="text" name="name"
                       value="${sessionScope.project != null ? sessionScope.project.getName() : ''}" required
                       pattern="[0-9a-zA-Z\u0400-\u044F\u0451]+([0-9a-zA-Z\u0400-\u044F\u0451' _.,;-]{1,})*"
                       title="Пожалуйста, введите минимум 1 букву или цифру. Далее можно вводить произвольное количество(<=50) букв, цифр и символы(вместо двойных кавычек используйте одинарные) ' _.,;-" maxlength="50">
            </td>
        </tr>
        <tr>
            <td>Сокращенное название</td>
            <td><input type="text" name="short-name"
                       value="${sessionScope.project != null ? sessionScope.project.shortName : ''}" required
                       pattern="[0-9a-zA-Z\u0400-\u044F\u0451]+([0-9a-zA-Z\u0400-\u044F\u0451' _.,;-]{1,})*" title="Пожалуйста, введите минимум 1 букву или цифру. Далее можно вводить произвольное количество(<=20) букв, цифр и символы(вместо двойных кавычек используйте одинарные) ' _.,;-" maxlength="20"></td>
        </tr>
        <tr>
            <td>Описание</td>
            <td><textarea class="textarea-noresize" name="description" form="add-project-form-id" cols="30"
                          rows="10">${sessionScope.project != null ? sessionScope.project.description : ''}</textarea>
            </td>
        </tr>

        <tr>
            <td>Список задач, принадлежащих проекту</td>
            <td>
                <div class="mypadding-div">
                    <input type="submit" value="Добавить" class="mybutton"
                           formaction="${pageContext.request.contextPath}/controller?command=add-task-to-project">
                </div>
            </td>
        </tr>
        <tr>
            <td>Идентификатор</td>
            <td>Название</td>
            <td>Дата начала</td>
            <td>Дата окончания</td>
            <td>Исполнитель (ФИО)</td>
            <td>Статус</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach var="eachTask"
                   items="${sessionScope.tasksOfProject}">
            <c:url var="editLink" value="${pageContext.request.contextPath}/controller">
                <c:param name="task-id" value="${eachTask.id}"/>
                <c:param name="command" value="edit-task"/>
                <c:param name="from-project-form" value="from-project-form"/>
                <c:if test="${not empty param['project-is-new']}">
                    <c:param name="project-is-new" value="project-is-new"/>
                </c:if>
            </c:url>
            <c:url var="deleteLink" value="${pageContext.request.contextPath}/controller">
                <c:param name="task-id" value="${eachTask.id}"/>
                <c:param name="command" value="delete-task"/>
                <c:param name="from-project-form" value="from-project-form"/>
                <c:if test="${not empty param['project-is-new']}">
                    <c:param name="project-is-new" value="project-is-new"/>
                </c:if>
            </c:url>
            <tr>
                <td>${eachTask.id}</td>
                <td>${eachTask.name}</td>
                <td>${eachTask.beginTime}</td>
                <td>${eachTask.endTime}</td>
                <td>${eachTask.collaborator.surname} ${eachTask.collaborator.name} ${eachTask.collaborator.patronymic} </td>
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
    <br><br>
    <p class="center-p">
        <c:url var="cancel" value="${pageContext.request.contextPath}/controller">
            <c:param name="command" value="cancel-project"/>
        </c:url>
        <a href="${cancel}" style="text-decoration: none" class="mybutton">Отмена</a>
        <input type="submit" name="buttonSave" value="Сохранить" class="mybutton"/>
    </p>
</form>
</body>
</html>
