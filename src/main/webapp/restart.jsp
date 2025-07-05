<%@ page import="com.web.quest.repository.DataBase" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%--    Bootstrap import--%>
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" href="styles.css">
    <title>ФИНАЛ</title>
    <style>
        .custom-margin {
            margin-top: 13rem;
        }
    </style>
</head>
<body>
<div>
    <div class="custom-margin container d-flex justify-content-center align-items-center text-center">
        <% String result = request.getParameter("id");%>
        <% if (Integer.parseInt(result) > 0) { %>
        <div class="p-4 mb-4 border border-dark bg-warning text-dark rounded">
            <h1 class="text-success"><%=DataBase.getInstance().getOtherText("win1")%> <br>
                <%=DataBase.getInstance().getOtherText("win2")%>
            </h1>
        </div>
        <% } else { %>
        <div class="p-4 mb-4 border border-dark bg-warning text-dark rounded">
            <h1 class="text-danger"><%=DataBase.getInstance().getOtherText("lose1")%><br>
                <%=DataBase.getInstance().getOtherText("lose2")%>
            </h1>
        </div>
        <% } %>
    </div>

    <div>
        <form action="index.jsp" method="get" class="justify-content-center align-items-center text-center">
            <button type="submit" class="btn btn-success"><%="ПОБРОБОВАТЬ СНОВА"%>
            </button>
        </form>
    </div><br><br>
</div>

<h5 class="text-warning">Имя пользователя: <%=session.getAttribute("username")%></h5><br>
<h5 class="text-warning">Сессия: <%=session.getId()%></h5>
</body>
</html>
