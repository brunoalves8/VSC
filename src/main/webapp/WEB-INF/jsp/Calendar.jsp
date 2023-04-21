<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>
        Calendar
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}calendar.css">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>
</head>

<body class="light">
<div class="container">
    <div class="left">
        <div class="calendar">
            <div class="month">
                <i class="fas fa-angle-left prev"></i>
                <a href="#" class="logo">
                    <img src="./Logo-512x512-1.png" alt="Vitória SC Logo">
                </a>
                <div class="date">dezembro 2015</div>
                <i class="fas fa-angle-right next"></i>
            </div>
            <div class="weekdays">
                <div>Dom</div>
                <div>Seg</div>
                <div>Ter</div>
                <div>Qua</div>
                <div>Qui</div>
                <div>Sex</div>
                <div>Sab</div>
            </div>
            <div class="days"></div>
            <div class="goto-today">
                <div class="goto">
                    <input type="text" placeholder="mm/aaaa" class="date-input" />
                    <button class="goto-btn">Ir</button>
                </div>
                <button class="today-btn">Hoje</button>
            </div>
        </div>
    </div>
    <div class="right">
        <div class="today-date">
            <div class="event-day">Qua</div>
            <div class="event-date">12 dezembro 2022</div>
        </div>
        <div class="events"></div>
        <div class="add-event-wrapper">
            <div class="add-event-header">
                <div class="title">Adicionar Evento</div>
                <i class="fas fa-times close"></i>
            </div>
            <div class="add-event-body">
                <div class="add-event-input">
                    <input type="text" placeholder="Nome Evento" class="event-name" />
                </div>
                <div class="add-event-input">
                    <input
                            type="text"
                            placeholder="Horas Inicio"
                            class="event-time-from"
                    />
                </div>
                <div class="add-event-input">
                    <input
                            type="text"
                            placeholder="Horas Fim"
                            class="event-time-to"
                    />
                </div>
            </div>
            <div class="add-event-footer">
                <button class="add-event-btn">Adicionar Evento</button>
            </div>
        </div>
    </div>
    <button class="add-event">
        <i class=" icon fa-regular fa-calendar-plus"></i>
    </button>

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

<script src="${pageContext.request.contextPath}/static/js/calendar.js"></script>
</body>
</html>
