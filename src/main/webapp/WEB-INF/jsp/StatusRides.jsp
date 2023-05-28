<%@ page import="java.sql.*" %>
<%@ page import="BackEnd.RideRequest" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Eventos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/StatusRides.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>

</head>

<body>
<div class="nav-container">
    <nav>
        <div class="nav-header"></div>
        <a href="#" class="logo">
            <img src="/static/images/Logo-512x512-1.png" alt="Vitória SC Logo">
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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <div class="header">
        <h1>Estado de Boleias</h1>
    </div>

    <div class="options">
        <c:forEach var="request" items="${requests}">
            <div class="option">
                <div class="nameCat">
                    <span class="catName">${request.nameEvent}</span>
                </div>
                <div class="athleteName">
                    <span>${request.username}</span>
                </div>
                <div class="pickupLocation">
                    <span>${request.pickupLocation}</span>
                </div>
                <div class="estado">
                    <span>${request.isAccepted ? 'Atribuida' : 'Não Atribuida'}</span>
                </div>
            </div>
        </c:forEach>
    </div>

</div>


<button id="back-button" onclick="goBack()"><i class="fa-solid fa-arrow-left"></i></button>
</body>
</html>