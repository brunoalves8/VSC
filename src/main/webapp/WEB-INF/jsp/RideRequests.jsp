<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Pedidos de Carona</title>
</head>
<body>
<h1>Pedidos de Carona</h1>

<table border="1">
    <thead>
    <tr>
        <th>Request ID</th>
        <th>Username</th>
        <th>Event ID</th>
        <th>Aceito</th>
        <th>Local de Recolha</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${rideRequests}" var="rideRequest">
        <tr>
            <td>${rideRequest.requestID}</td>
            <td>${rideRequest.username}</td>
            <td>${rideRequest.eventID}</td>
            <td>${rideRequest.isAccepted ? 'Sim' : 'Não'}</td>
            <td>${rideRequest.pickupLocation}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
