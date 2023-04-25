<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <div class="table-responsive">
                    <table class="table user-list">
                        <thead>
                        <tr>
                            <th><span>User</span></th>
                            <th><span>Email</span></th>
                            <th>&nbsp;</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">Mila Kunis</span>
                                <span class="user-subhead">Admin</span>
                            </td>

                            <td>
                                <span>mila@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">George Clooney</span>
                                <span class="user-subhead">Member</span>
                            </td>
                            <td>
                                <span>marlon@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">Ryan Gossling</span>
                                <span class="user-subhead">Registered</span>
                            </td>
                            <td>
                                <span>jack@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">Emma Watson</span>
                                <span class="user-subhead">Registered</span>
                            </td>
                            <td>
                                <span>humphrey@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">Robert Downey Jr.</span>
                                <span class="user-subhead">Admin</span>
                            </td>
                            <td>
                                <span>spencer@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">Mila Kunis</span>
                                <span class="user-subhead">Admin</span>
                            </td>
                            <td>
                                <span>mila@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">George Clooney</span>
                                <span class="user-subhead">Member</span>
                            </td>
                            <td>
                                <span>marlon@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">Ryan Gossling</span>
                                <span class="user-subhead">Registered</span>
                            </td>
                            <td>
                                <span>jack@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">Emma Watson</span>
                                <span class="user-subhead">Registered</span>
                            </td>
                            <td>
                                <span>humphrey@gmail.com</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="./channels4_profile.jpg" alt="">
                                <span class="user-link">Robert Downey Jr.</span>
                                <span class="user-subhead">Admin</span>
                            </td>
                            <td>
                                <span>spencer@gmail</span>
                            </td>
                            <td style="width: 20%;">
                                <a href="#" class="table-link danger">
									<span class="fa-stack">
										<i class="fa fa-square fa-stack-2x"></i>
										<i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
									</span>
                                </a>
                            </td>
                        </tr>
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