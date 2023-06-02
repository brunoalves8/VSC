<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="static java.lang.Integer.parseInt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="BackEnd.Coach" %>
<%@ page import="BackEnd.User" %>
<%@ page import="BackEnd.Player" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pedir Boleia</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/PickUpSpot.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>

</head>

<body>

<div class="nav-container">
    <nav>
        <div class="nav-header"></div>
        <%
            String type = "";
            String Type = "";
            String questions = "";
            User user1 = (User)session.getAttribute("user"); //Assuming user data is stored in session
            if(user1 instanceof Coach) {
                Coach coach = (Coach) user1;
                type = "coach";
                Type = "userSettingsCoach";
                questions = "coachQuestionnairies";
            } else if(user1 instanceof Player) {
                Player player = (Player) user1;
                type = "player";
                Type = "userSettings";
                questions = "playerQuestionnairies";
            }
        %>

        <a href="http://localhost:8080/<%=type%>" class="logo">
            <img src="/static/images/Logo-512x512-1.png" alt="Vitória SC Logo">
            <span class="nav-item">Voleibol VSC</span>
        </a>
        <ul class="nav-links">
            <div class="navOPT">
                <li><a href="http://localhost:8080/<%=type%>">
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
                <li><a href="<%=questions%>">
                    <i class="fas fa-tasks"></i>
                    <span class="nav-item">Tarefas</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="http://localhost:8080/<%=Type%>">
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
        var toggleMenu = document.getElementById('nav-links');
        var nav = document.querySelector('nav');

        toggleMenu.addEventListener('click', function() {
            nav.classList.toggle('show');
        });
    </script>
</div>

<div class="container">

    <div class="options">

        <div class="option">
            <a href="#">
                <div class="nameCat">
                    <%
                        String eventIdString = (String) request.getParameter("eventID");
                        String eventName = (String) request.getParameter("eventName");
                        int eventId = -1; // Definir um valor padrão
                        if (eventIdString != null) {
                            try {
                                eventId = Integer.parseInt(eventIdString);


                            } catch (NumberFormatException e) {
                                // Tratamento de erro aqui
                                e.printStackTrace();
                            }
                        } else {
                            // eventIdString é nulo. Lidar com isso aqui.
                            out.println("EventID não encontrado na sessão.");
                        }
                    %>
                    <%

                    %>
                    <span class="catName"><%= eventName%></span>
                </div>
            </a>
            <div class="location">
                <form action="/insertDataOfLocation" method="post">
                    <label for="local">Local de recolha:</label>
                    <input type="text" id="local" name="pickupLocation" required>
                    <input type="hidden" name="eventId" value="<%= eventId %>">
                    <input type="hidden" name="eventName" value="<%= eventName %>">
                    <button type="submit">Enviar</button>
                </form>

            </div>
        </div>

    </div>

</div>
</body>
</html>