<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%--    Bootstrap import--%>
    <%@ include file="header.jsp" %>
    <link rel="stylesheet" href="styles.css">
    <title>JSP - STAR WARS QUIZ</title>
    <style>
        .full-height {
            height: 100vh;
        }
    </style>
</head>

<body class="d-flex justify-content-center align-items-center full-height text-center">
<div>
    <div class="container">
        <div class="p-4 mb-4 border border-dark bg-warning text-dark rounded">
            <h1><%= "Тебя ждет путешествие по вселенной Star Wars!" %>
            </h1>
            <h4>Готов ли ты проверить свои знания о легендарных персонажах Star Wars?<br>
                Этот квиз испытает твою память и интуицию, но будь внимателен ,<br>
                на каждый вопрос есть только два варианта ответа.<br>
                Выбери правильный и ты продолжишь свой путь к победе.<br>
                Ошибись и твое приключение закончится преждевременно.<br>
                Сможешь ли ты дойти до конца и доказать свое мастерство?<br>
                Или же падешь жертвой тьмы незнания?</h4><br>
            <h3>Выбирай с умом!<br>
                Да пребудет с тобой Сила!</h3>
        </div>
    </div>

    <form action="question-servlet" method="get">
        <label for="name" class="text-warning">Введите свое имя!</label><br>
        <input type="text" id="name" name="username" class="bg-dark text-warning"><br><br>
        <button type="submit" class="btn btn-primary"><%="НАЧАТЬ"%></button>
    </form><br>

</div>
</body>
</html>