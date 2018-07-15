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
    <title>List of workers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="mypadding-div">
    <c:url var="addLink" value="${pageContext.request.contextPath}/controller">
        <c:param name="command" value="add-collaborator"/>
    </c:url>
    <a href="${addLink}">
        <button class="mybutton">Add+</button>
    </a>
</div>
<jsp:useBean id="collaboratorService" class="service.CollaboratorService"/>
<table class="mytable-table mytable-table-horizontal mytable-table-highlight">
    <thead>
    <tr>
        <th>Id</th>
        <th>Surname</th>
        <th>Name</th>
        <th>Patronymic</th>
        <th>Position</th>
        <th>Edit</th>
        <th>Delete</th>
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
            <td><a href="${editLink}">Edit</a></td>
            <td><a href="${deleteLink}"
                   onclick="if (!(confirm('Are u sure u want to delete this worker?'))) return false">Delete
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
