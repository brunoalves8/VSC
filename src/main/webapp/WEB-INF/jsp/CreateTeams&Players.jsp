<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Criar Equipas e Jogadores</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CreateTeams&Players.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>

</head>
<body>

<div class="container">
    <div class="team"> Equipa 1
        <input type="text" placeholder="Nome da Equipa 1" id="teamName1">
        <div id="playersTeam1">Jogador:
            <!-- Jogadores serão adicionados aqui dinamicamente -->
        </div>
        <button onclick="addPlayer('playersTeam1')">Adicionar jogador à Equipa 1</button>
    </div>
    <div class="team"> Equipa 2
        <input type="text" placeholder="Nome da Equipa 2" id="teamName2">
        <div id="playersTeam2">
            <!-- Jogadores serão adicionados aqui dinamicamente -->
        </div>
        <button onclick="addPlayer('playersTeam2')">Adicionar jogador à Equipa 2</button>
    </div>
    <button id="saveBtn">Salvar e Registrar Códigos</button>
    <div class="progress-text" id="progress-text">
        Vitória SC
    </div>
</div>
<div class="nav-container">
    <nav>
        <div class="nav-header"></div>
        <a href="#" class="logo">
            <img src="static/images/Logo-512x512-1.png" alt="Vitória SC Logo">
            <span class="nav-item">Voleibol VSC</span>
        </a>
        <ul class="nav-links" id="nav-links">
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/createTeams&Players.js"></script>
</body>
</html>
