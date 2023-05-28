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
                <li><a href="http://localhost:8080/coach">
                    <i class="fas fa-home"></i>
                    <span class="nav-item">Menu</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="http://localhost:8080/profile">
                    <i class="fas fa-user"></i>
                    <span class="nav-item">Perfil</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="http://localhost:8080/userSettingsCoach">
                    <i class="fas fa-cog"></i>
                    <span class="nav-item">Definições</span>
                </a></li>
            </div>
            <li><a href="http://localhost:8080/login" class="logout">
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

        <div class="option"><a href="http://localhost:8080/listPlayers">
            <div class="nameCat">
                <i class="icon fa-solid fa-arrow-trend-up text-center mr-1"></i>
                <span class="catName">Físico dos Atletas</span>
            </div></a>
        </div>

        <div class="option"><a href="http://localhost:8080/coachGamesSubMenu">
            <div class="nameCat">
                <i class=" icon fa-solid fa-volleyball"></i>
                <span class="catName">Jogos</span>
            </div></a>
        </div>

        <div class="option"><a href="http://localhost:8080/calendar">
            <div class="nameCat">
                <i class="icon fa-regular fa-calendar"></i>
                <span class="catName">Calendarização de Treinos e Jogos</span>
            </div></a>
        </div>

        <div class="option">
            <a href="http://localhost:8080/coachQuestionnaries">
                <div class="nameCat">
                    <i class="icon fa-regular fa-pen-to-square"></i>
                    <span class="catName">Questionários</span>
                </div>
            </a>
        </div>

        <div class="option"><a href="/ridesSubMenu">
            <div class="nameCat">
                <i class=" icon fa-solid fa-car"></i>
                <span class="catName">Boleias</span>
            </div></a>
        </div>
    </div>
</div>
</body>
</html>