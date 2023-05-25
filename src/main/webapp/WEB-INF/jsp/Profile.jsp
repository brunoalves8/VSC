<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Perfil</title>
    <!-- Import font icon (fontawesome) -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>
    <!-- Import CSS file (style.css) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}css/Profile.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="profile">
    <div class="profile-header">
        <img src="static/images/channels4_profile.png" alt="Profile Image" class="profile-image">
    </div>
    <div class="profile-info">
        <div class="profile-details">
            <h2>Username</h2>
            <p class="data-label">Tipo de utilizador</p>
        </div>
        <div class="data-row">
            <p>Nome<br><span class="data-label">Nome</span></p>
            <p>20<br><span class="data-label">Idade</span></p>
        </div>
        <div class="data-row">
            <p>1.75m<br><span class="data-label">Altura</span></p>
            <p>65 Kg<br><span class="data-label">Peso</span></p>
        </div>

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
