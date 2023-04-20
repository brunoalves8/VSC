<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/RemoveUser.css">
    <title>Introduzir Username</title>
</head>
<body>
<div class="container">
    <h1>Remover Utilizador</h1>
    <%--@elvariable id="user" type=""--%>
    <form:form action="/removeUser" modelAttribute="user" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <button type="submit">Remover</button>
    </form:form>
    <% if (request.getAttribute("error") != null) { %>
    <span id="error-message" class="error-message"><%= request.getAttribute("error") %></span>
    <% } %>
    <% if (request.getAttribute("success") != null) { %>
    <span id="success-message" class="success-message"><%= request.getAttribute("success") %></span>
    <% } %>
</div>
</body>
</html>