<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="BackEnd.RemoveAndListUser, BackEnd.User, java.util.List"%>
<%@ page import="BackEnd.Player" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/UserList.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>
</head>

<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box clearfix">
                <% String successMessage = (String) request.getAttribute("successMessage");
                    String errorMessage = (String) request.getAttribute("errorMessage");
                    if (successMessage != null) { %>
                <p class="success-message"><%= successMessage %></p>
                <% }
                    if (errorMessage != null) { %>
                <p class="error-message"><%= errorMessage %></p>
                <% } %>
                <div class="table-responsive">
                    <table class="table user-list">
                        <thead>
                        <tr>
                            <th><span>Nome</span></th>
                            <th><span>Número Camisola</span></th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody>
                <%
                    List<Player> listPlayers = RemoveAndListUser.listAllPlayers();
                    for (Player player : listPlayers){
                       String p=player.getUsername();
                %>
                <tr>
                    <td>
                        <img src="" alt="">
                        <span class="user-link"><%= player.getName()%></span>
                        <span class="user-subhead"></span>
                    </td>
                    <td>
                        <span><%= player.getShirtNumber() %></span>
                    </td>
                    <td style="width: 20%;">
                        <form action="${pageContext.request.contextPath}/profile2?usernamePlayer=<%=p%>" method="post">
                            <input type="hidden" name="username" value="<%= p %>"/>
                            <button type="submit" class="table-link danger">
                                        <span class="fa-stack">

                                            <i class="fa-solid fa-link"></i>
                                        </span>
                            </button>
                        </form>
                    </td>
                </tr>
                <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="nav-container">
    <nav>
        <div class="nav-header"></div>
        <a href="http://localhost:8080/director" class="logo">
            <img src="static/images/Logo-512x512-1.png" alt="Vitória SC Logo">
            <span class="nav-item">Voleibol VSC</span>
        </a>
        <ul class="nav-links">
            <div class="navOPT">
                <li><a href="http://localhost:8080/director">
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
</body>
</html>