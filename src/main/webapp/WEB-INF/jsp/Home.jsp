<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Side Menu Bar</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>
</head>

<body>
<div class="nav-container">
    <nav>
        <div class="nav-header"></div>
        <a href="#" class="logo">
            <img src="/static/images/Logo-512x512-1.png" alt="Vitória SC Logo"/>
            <span class="nav-item">Voleibol VSC</span>
        </a>
        <ul class="nav-links">
            <div class="navOPT">
                <li><a href="#">
                    <i class="fas fa-home"></i>
                    <span class="nav-item">Menu</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="#">
                    <i class="fas fa-user"></i>
                    <span class="nav-item">Perfil</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="#">
                    <i class="fas fa-tasks"></i>
                    <span class="nav-item">Tarefas</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="#">
                    <i class="fas fa-cog"></i>
                    <span class="nav-item">Definições</span>
                </a></li>
            </div>
            <li><a href="#" class="logout">
                <form action="/login" method="post">
                <i class="fas fa-sign-out-alt"></i>
                <button type="submit" class="nav-item">Sair</button>
                </form>
            </a></li>
            <style>
                .logout button{
                    background-color: transparent;
                }
            </style>
        </ul>
    </nav>
</div>

<div class="container">

    <div class="header">
        <h1>Vitória Sport Clube</h1>
    </div>

    <div class="options">

        <div class="option">
            <a href="https://docs.google.com/forms/d/e/1FAIpQLSfI4fsAj2ZfjwQn8V8np1kAuOtJQpH6322ZqjjT0LQzd1UJ_w/viewform?usp=sf_link">
                <div class="nameCat">
                    <i class="icon fa-solid fa-arrow-trend-up"></i>
                    <span class="catName">Responder Questionários</span>
                </div>
            </a>
        </div>



        <div class="option"><a href="#">
            <div class="nameCat">
                <i class=" icon fa-regular fa-clipboard"></i>
                <span class="catName">Relatório de Estatísticas</span>
            </div></a>
        </div>

        <div class="option"><a href="#">
            <div class="nameCat">
                <i class="icon fa-regular fa-calendar"></i>
                <span class="catName">Calendarização de Treinos e Jogos</span>
            </div></a>
        </div>

        <div class="option"><a href="#">
            <div class="nameCat">
                <i class="fa fa-user-plus"></i>
                <span class="catName">Registar Utilizador</span>
            </div></a>
        </div>
    </div>
</div>
</body>
</html>