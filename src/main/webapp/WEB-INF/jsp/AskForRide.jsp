<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Eventos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/AskForRide.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>

</head>

<body>
<div class="nav-container">
    <nav>
        <div class="nav-header"></div>
        <a href="#" class="logo">
            <img src="./Logo-512x512-1.png" alt="Vitória SC Logo">
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
                <i class="fas fa-sign-out-alt"></i>
                <span class="nav-item">Sair</span>
            </a></li>
        </ul>
    </nav>
    <script>
        var toggleMenu = document.getElementById('nav-links');
        var nav = document.querySelector('nav');

        toggleMenu.addEventListener('click', function() {
            nav.classList.toggle('show');
        });
    </script>
</div>

<div class="container">

    <div class="header">
        <h1>Pedir Boleia</h1>
        <h2>Selecione o evento desejado</h2>
    </div>

    <div class="options">

        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 1</span>
            </div></a>
        </div>

        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 2</span>
            </div></a>
        </div>
        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 3</span>
            </div></a>
        </div>
        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 4</span>
            </div></a>
        </div>
        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 5</span>
            </div></a>
        </div>
        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 6</span>
            </div></a>
        </div>
        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 7</span>
            </div></a>
        </div>
        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 8</span>
            </div></a>
        </div>
        <div class="option"><a href="#">
            <div class="nameCat">
                <span class="catName">Evento 9</span>
            </div></a>
        </div>
    </div>
</div>
<button id="back-button" onclick="goBack()"><i class="fa-solid fa-arrow-left"></i></button>
</body>
</html>