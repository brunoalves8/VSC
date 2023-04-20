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
    <form>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <button type="submit">Remover</button>
    </form>
</div>
</body>
</html>