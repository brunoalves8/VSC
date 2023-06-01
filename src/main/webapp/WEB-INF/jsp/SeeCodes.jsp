<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver Jogadas - Voleibol</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/RegisterCodes.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>
    <script src="/static/js/plyr.js"></script>
</head>
<body>
<div class="main-content">
    <form id="jogadaForm">
    <!-- Adicionar o campo para inserir a URL da transmissão -->
    <label for="streamUrl">URL da Transmissão:</label>
    <input type="text" id="streamUrl" name="streamUrl">
    <br>
    <button id="loadStream">Carregar Transmissão</button>
    <br>
    <!-- Adicionar a tag video para exibir o vídeo -->
    <video id="videoStream" class="plyr" controls>
        <source src="src/main/resources/static/videos/videoVSCvsSLB.webm" type="video/webm">
        Seu navegador não suporta a tag de vídeo.
    </video>
    <div id="resultado">
        <p id="codigoJogada"></p>
        <div id="listaJogadas">Lista de Jogadas:</div>
    </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<div class="nav-container">
    <nav>
        <div class="nav-header"></div>
        <a href="http://localhost:8080/coach" class="logo">
            <img src="static/images/Logo-512x512-1.png" alt="Vitória SC Logo">
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
                <li><a href="#">
                    <i class="fas fa-tasks"></i>
                    <span class="nav-item">Tarefas</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="http://localhost:8080/userSettingsCoach">
                    <i class="fas fa-cog"></i>
                    <span class="nav-item">Definições</span>
                </a></li>
            </div>
            <li><a href="http://localhost:8080/login" class="logout">
                <i class="fas fa-sign-out-alt"></i>
                <span class="nav-item">Sair</span>
            </a></li>
        </ul>
    </nav>
    <script>
        var toggleMenu = document.querySelector('.nav-links');
        var nav = document.querySelector('nav');

        toggleMenu.addEventListener('click', function() {
            nav.classList.toggle('show');
        });
    </script>
</div>
<script src="${pageContext.request.contextPath}/static/js/seeCodes.js"></script>
<script>
    const player = new Plyr('#videoStream');
</script>

</body>
</html>