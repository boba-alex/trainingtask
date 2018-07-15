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
    <title>Ошибка</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<jsp:include page="/jsp/header.jsp"/>
<div class="content">
    <div id="content-header">
        <h2 class="header-text">Ошибка:</h2>
    </div>
    <div id="content-main">
        <div id="form" class="infobox">
            <p>Статус ошибки: ${pageContext.errorData.statusCode}</p>
            <p>От: ${pageContext.errorData.requestURI}</p>
            <p>Сообщение: ${pageContext.errorData.throwable.message}</p>
            <p>Сообщение: <%=
            (request.getSession().getAttribute("errorMessage") != null) ?
                    (String) request.getSession().getAttribute("errorMessage") : "unknown error"
            %>
            </p>
            <button type="button" onclick="history.back()" class="mybutton">Назад</button>
        </div>
    </div>
</div>

</body>
</html>
