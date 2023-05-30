<%@ page import="java.sql.*" %>
<%@ page import="com.sun.java.accessibility.util.EventID" %>
<%@ page import="BackEnd.Event" %>
<%@ page import="BackEnd.Coach" %>
<%@ page import="BackEnd.User" %>
<%@ page import="BackEnd.Player" %>
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
        <%
            String type = "";
            String questions = "";
            User user1 = (User)session.getAttribute("user"); //Assuming user data is stored in session
            if(user1 instanceof Coach) {
                Coach coach = (Coach) user1;
                type = "coach";
                questions = "coachQuestionnairies";
            } else if(user1 instanceof Player) {
                Player player = (Player) user1;
                type = "player";
                questions = "playerQuestionnairies";
            }

        %>
        <a href="http://localhost:8080/<%=type%>" class="logo">
            <img src="static/images/Logo-512x512-1.png" alt="Vitória SC Logo">
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
                <li><a href="http://localhost:8080/<%=questions%>">
                    <i class="fas fa-tasks"></i>
                    <span class="nav-item">Tarefas</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="http://localhost:8080/userSettings">
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

    <div class="header">
        <h1>Pedir Boleia</h1>
        <h2>Selecione o evento desejado</h2>
    </div>

    <div class="options">
        <%
            // Estabelecer a conexão com o banco de dados

            String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
            String user = "IntelliJ";
            String dbPassword = "vsc.DAI23";

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                conn = DriverManager.getConnection(url, user, dbPassword);

                // Consultar os eventos da tabela "Events"
                stmt = conn.createStatement();
                String query = "SELECT * FROM Events";
                rs = stmt.executeQuery(query);

                // Gerar dinamicamente a lista de eventos
                while (rs.next()) {
                    String eventName = rs.getString("nameOfEvent");
                    String eventID = rs.getString("EventID");
        %>

        <div class="option">
            <a href="http://localhost:8080/pickUpSpot?eventName=<%=eventName%>&eventID=<%=eventID%>">
                <div class="nameCat">
                    <span class="catName"><%= eventName %></span>
                </div>
            </a>
        </div>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Fechar a conexão com o banco de dados
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        %>


    </div>
</div>

</body>
</html>