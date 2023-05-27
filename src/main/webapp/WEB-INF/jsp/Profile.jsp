<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Perfil</title>
    <!-- Import font icon (fontawesome) -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>
    <!-- Import CSS file (style.css) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Profile.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="profile">
    <div class="profile-header">
        <img src="static/images/channels4_profile.png" alt="Profile Image" class="profile-image">
    </div>
    <div class="profile-info">
        <div class="profile-details">
            <h2>${user.username}</h2>
            <p class="data-label">${user.userType}</p>
        </div>
        <div class="data-row">
            <p>Nome<br><span class="data-label">${user.name}</span></p>
            <p>Idade<br><span class="data-label">${user.age}</span></p>
        </div>
        <div class="data-row">
            <p>Altura<br><span class="data-label">${user.height}</span></p>
            <p>Peso<br><span class="data-label">${user.weight}</span></p>
        </div>

        <%-- Exibir informações específicas do jogador --%>
        <c:if test="${player != null}">
            <div class="data-row">
                <p>Posição<br><span class="data-label">${player.position}</span></p>
                <p>Número da camisola<br><span class="data-label">${player.shirtNumber}</span></p>
            </div>
        </c:if>

        <%-- Exibir informações específicas do treinador --%>
        <c:if test="${coach != null}">
            <div class="data-row">
                <p>Equipe<br><span class="data-label">${coach.team}</span></p>
            </div>
        </c:if>

        <%-- Exibir informações específicas do diretor --%>
        <c:if test="${director != null}">
            <div class="data-row">
                <%-- Exiba informações específicas do diretor --%>
            </div>
        </c:if>

        <a href="#" class="edit-button">Editar Perfil</a>
    </div>
</div>
</body>

<nav>
    <div class="nav-header"></div>
    <a href="#" class="logo">
        <img src="static/images/Logo-512x512-1.png" alt="Vitória SC Logo">
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

</html>