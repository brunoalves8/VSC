<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <!---<title> Responsive Registration Form | CodingLab </title>--->
    <link rel="stylesheet" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/UserRegistration.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>
</head>
<body>
<%--@elvariable id="coach" type=""--%>
<form th:action="@{/coachRegistration}" th:object="${coach}" method="post" class="coachRegistration-form">
<div class="container">
    <div class="title">Registration</div>
    <div class="content">
        <p th:if="${error}" th:text="${error}"></p>
        <div class="user-details">
            <div class="input-box">
                <span class="details">Full Name</span>
                <input type="text" placeholder="Enter your name" name ="name" th:field="*{name}" required>
            </div>
            <div class="input-box">
                <span class="details">Username</span>
                <input type="text" placeholder="Enter your username" name="username" th:field="*{username}" required>
            </div>
            <div class="input-box">
                <span class="details">Email</span>
                <input type="text" placeholder="Enter your email" name="email" th:field="*{email}" required>
            </div>
            <div class="input-box">
                <span class="details">Phone Number</span>
                <input type="text" placeholder="Enter your number" name="phoneNumber" th:field="*{phoneNumber}" required>
            </div>
            <div class="input-box">
                <span class="details">Password</span>
                <input type="password" placeholder="Enter your password" name="password" th:field="*{password}" required>
            </div>

        </div>
        <div class="gender-details">
            <input type="radio" name="type" id="dot-1" value="Head" th:field="*{type}" required>
            <input type="radio" name="type" id="dot-2" value="Assistant" th:field="*{type}" required>
            <span class="Type-title">Type</span>
            <div class="category">
                <label for="dot-1">
                    <span class="dot one"></span>
                    <span class="type">Head</span>
                </label>
                <label for="dot-2">
                    <span class="dot two"></span>
                    <span class="type">Assistant</span>
                </label>
            </div>
        </div>

        <button class="submit">Registar</button>
        </form>
    </div>
</div>
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
</body>
</html>