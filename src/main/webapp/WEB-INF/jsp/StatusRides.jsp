<%@ page import="java.sql.*" %>
<%@ page import="BackEnd.RideRequest" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="BackEnd.User" %>
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
    <title>Eventos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/StatusRides.css">
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
                Type = "Coach";
                questions = "coachQuestionnairies";
            } else if(user1 instanceof Player) {
                Player player = (Player) user1;
                type = "player";
                Type = "";
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
                <li><a href="#">
                    <i class="fas fa-tasks"></i>
                    <span class="nav-item">Tarefas</span>
                </a></li>
            </div>
            <div class="navOPT">
                <li><a href="http://localhost:8080/userSettings<%=Type%>">
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
        <h1>Estado de Boleias</h1>
    </div>

    <div class="options">
        <%

            // Estabelecer a conexão com o banco de dados
            String url = "jdbc:sqlserver://vsc23.database.windows.net:1433;database=VSC";
            String user = "IntelliJ";
            String dbPassword = "vsc.DAI23";

            User userLogado = (User) session.getAttribute("user");

            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                conn = DriverManager.getConnection(url, user, dbPassword);

                // Consultar os pedidos de boleia do utilizador logado na tabela "RideRequests"
                String query = "SELECT * FROM RideRequests WHERE username=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, userLogado.getUsername()); // Supondo que o username do usuário logado esteja na sessão
                rs = pstmt.executeQuery();

                // Gerar dinamicamente a lista de pedidos de boleia
                while (rs.next()) {
                    int requestID = rs.getInt("requestID");
                    String eventName = rs.getString("nameEvent");
                    String driverUsername = rs.getString("driverUsername");
                    String username = rs.getString("username");
                    String pickupLocation = rs.getString("pickupLocation");
                    boolean isAccepted = rs.getBoolean("isAccepted");
                    String isAcceptedStatus = isAccepted ? "Atribuida" : "Não Atribuida";
        %>
        <div class="option">
            <div class="nameCat">
                <span class="catName"><%= eventName %></span>
            </div>
            <div class="athleteName1">
                <%--@declare id="driver"--%>
                <label for="driver"  ><strong>Condutor:  </strong></label>
                <span><%= driverUsername %></span>
            </div>
            <div class="pickupLocation1">
                <%--@declare id="pickuplocation"--%>
                <label for="pickupLocation" ><strong>Localização:  </strong></label>
                <span><%= pickupLocation %></span>
            </div>
            <div class="estado">
                <span><%= isAcceptedStatus %></span>
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
                if (pstmt != null) {
                    try {
                        pstmt.close();
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