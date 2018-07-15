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
    <title>Список проектов</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="mypadding-div">
    <c:url var="addLink" value="${pageContext.request.contextPath}/controller">
        <c:param name="command" value="add-project"/>
        <c:param name="project-is-new" value="project-is-new"/>
    </c:url>
    <a href="${addLink}">
        <button class="mybutton">Добавить</button>
    </a>
</div>
<jsp:useBean id="projectService" class="service.ProjectService"/>
<table class="mytable-table mytable-table-horizontal mytable-table-highlight">
    <thead>
    <tr>
        <th>Идентификатор</th>
        <th>Название</th>
        <th>Сокращенное название</th>
        <th>Описание</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="eachProject" items="${projectService.projects}">
        <c:url var="editLink" value="${pageContext.request.contextPath}/controller">
            <c:param name="project-id" value="${eachProject.id}"/>
            <c:param name="command" value="edit-project"/>
        </c:url>
        <c:url var="deleteLink" value="${pageContext.request.contextPath}/controller">
            <c:param name="project-id" value="${eachProject.id}"/>
            <c:param name="command" value="delete-project"/>
        </c:url>
        <tr>
            <td>${eachProject.id}</td>
            <td>${eachProject.name}</td>
            <td>${eachProject.shortName}</td>
            <td><label><textarea class="textarea-noresize" readonly>${eachProject.description}</textarea></label></td>
            <td><a href="${editLink}">Изменить</a></td>
            <td><a href="${deleteLink}"
                   onclick="if (!(confirm('Вы уверены, что хотите удалить этот проект?'))) return false">Удалить
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
