<%@ page import="java.sql.*" %>
<%@ page import="com.sun.java.accessibility.util.EventID" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Oferecer Boleia</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/OfferRide.css">
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
        <h1>Oferecer Boleia</h1>
        <h2>Selecione o evento para o qual deseja oferecer boleia</h2>
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

                // Consultar os pedidos de boleia da tabela "RideRequests"
                stmt = conn.createStatement();
                String query = "SELECT * FROM RideRequests";
                rs = stmt.executeQuery(query);

                // Gerar dinamicamente a lista de pedidos de boleia
                while (rs.next()) {
                    int requestID = rs.getInt("requestID");
                    String eventName = rs.getString("nameEvent");
                    String username = rs.getString("username");
                    String pickupLocation = rs.getString("pickupLocation");
        %>

        <div class="option">
            <a href="/offerRide?requestID=<%=requestID%>">
                <div class="nameCat">
                    <span class="catName"><%= eventName %></span>
                </div>
            </a>
            <div class="athleteName">
                <span><%= username %></span>
            </div>
            <div class="pickupLocation">
                <span><%= pickupLocation %></span>
            </div>
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


<button id="back-button" onclick="goBack()"><i class="fa-solid fa-arrow-left"></i></button>
</body>
</html>