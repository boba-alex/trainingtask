<%--
  Created by IntelliJ IDEA.
  User: polishchukam
  Date: 05.05.2018
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="content">
<div id="content-header">
    <h2 class="header-text">Error:</h2>
</div>
<div id="content-main">
    <div id="form" class="infobox">
        <p>Status code: ${pageContext.errorData.statusCode}</p>
        <p>From: ${pageContext.errorData.requestURI}</p>
        <p>Message: ${pageContext.errorData.throwable.message}</p>
        <p>Stacktrace: ${pageContext.errorData.throwable.stacktrace}</p>
        <p>Custom message: <%=
        (request.getSession().getAttribute("errorMessage") != null) ?
                (String) request.getSession().getAttribute("errorMessage") : "unknown error"
        %>
        </p>
        Back:<a href=${pageContext.request.contextPath}${pageContext.errorData.requestURI}>-></a>
    </div>
</div>
</div>

</body>
</html>
