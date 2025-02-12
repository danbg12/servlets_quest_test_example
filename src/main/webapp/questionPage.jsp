<%@ page import="com.javarush.com_javarush_buga_quest.entity.Question" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%--    Bootstrap import--%>
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" href="styles.css">
    <title>Quiz</title>
    <style>
        .custom-margin {
            margin-top: 13rem;
        }
    </style>
</head>

<body>
<div>
    <div class="custom-margin container d-flex justify-content-center align-items-center text-center">
        <div class="p-4 mb-4 border border-dark bg-warning text-dark rounded">
            <h1>
                <% Question question = (Question) request.getAttribute("question"); %>
                <%= question.getQuestionText() %>
            </h1>
        </div>
    </div>

    <div>
        <% Integer nextIndex = (Integer) request.getAttribute("nextIndex"); %>
        <% if (nextIndex != null) { %>
        <form action="question-servlet" method="get" class="justify-content-center align-items-center text-center">
            <input type="hidden" name="username" value="<%=session.getAttribute("username")%>">
            <input type="hidden" name="id" value="<%=nextIndex%>">
            <button type="submit" class="btn btn-primary"><%= question.getAnswerTrue() %>
            </button>
        </form>
        <% } else { %>
        <form action="restart.jsp" method="get" class="justify-content-center align-items-center text-center">
            <input type="hidden" name="username" value="<%=session.getAttribute("username")%>">
            <input type="hidden" name="id" value="1">
            <button type="submit" class="btn btn-primary"><%= question.getAnswerTrue()%>
            </button>
            <br>
        </form>
        <% } %>

        <form action="restart.jsp" method="get" class="justify-content-center align-items-center text-center">
            <input type="hidden" name="username" value="<%=session.getAttribute("username")%>">
            <input type="hidden" name="id" value="0">
            <button type="submit" class="btn btn-primary"><%= question.getAnswerFalse()%>
            </button>
        </form>
    </div><br><br>
</div>

<h5 class="text-warning">Имя пользователя: <%=session.getAttribute("username")%></h5><br>
<h5 class="text-warning">Сессия: <%=session.getId()%></h5>

</body>
</html>
