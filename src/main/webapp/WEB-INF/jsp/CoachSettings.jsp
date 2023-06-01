<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Settings UI Design</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}css/UserSettings.css">
</head>
<body>
<section class="py-5 my-5">
    <div class="container">
        <h1 class="mb-5">Definições Utilizador</h1>
        <div class="bg-white shadow rounded-lg d-block d-sm-flex">
            <div class="profile-tab-nav border-right">
                <div class="p-4">
                    <div class="img-circle text-center mb-3">
                        <img src="static/images/channels4_profile.jpg" alt="Image" class="shadow">
                    </div>
                    <h4 class="text-center">${sessionScope.user.username} </h4>
                </div>
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="account-tab" data-toggle="pill" href="#account" role="tab" aria-controls="account" aria-selected="true">
                        <i class="fas fa-solid fa-person text-center mr-1"></i>
                        Ficha de Treinador
                    </a>
                    <a class="nav-link" id="password-tab" data-toggle="pill" href="#password" role="tab" aria-controls="password" aria-selected="false">
                        <i class="fa fa-key text-center mr-1"></i>
                        Password
                    </a>
                </div>
            </div>
            <div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                    <h3 class="mb-4">Ficha de Treinador</h3>
                    <%--@elvariable id="player" type=""--%>
                    <form:form action="/userSettings" modelAttribute="player" method="post" class = "userSettings-form">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" class="form-control" value="${sessionScope.user.username}" name="username"required>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Número de telemóvel</label>
                                <input type="text" class="form-control" value="912345678" name="phoneNumber"required>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" class="form-control" value="exemplo@email.com" name="email"required>
                            </div>
                        </div>
                    <div>
                        <button class="btn btn-primary">Atualizar</button>
                        <a href="http://localhost:8080/coach" class="btn btn-light">Cancelar</a>
                    </div>
                </div>
                </form:form>
                <div class="tab-pane fade" id="password" role="tabpanel" aria-labelledby="password-tab">
                    <h3 class="mb-4">Alterar Password</h3>
                    <%--@elvariable id="passwordform" type=""--%>
                    <form:form id="form2" action="/changePassword" modelAttribute="passwordform" method="post" class = "userSettings-form2">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Password antiga</label>
                                    <input type="password" class="form-control" name="currentPassword">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Nova password</label>
                                    <input type="password" class="form-control" name="newPassword">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Confirmar nova password</label>
                                    <input type="password" class="form-control" name="confirmPassword">
                                </div>
                            </div>
                        </div>
                        <div>
                            <button type="submit" form="form2" class="btn btn-primary">Atualizar</button>
                            <a href="http://localhost:8080/coach" class="btn btn-light">Cancelar</a>
                        </div>
                    </form:form>
                </div>

            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>