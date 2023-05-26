<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="BackEnd.RideRequest, BackEnd.RideRequestDAO, java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listagem de Boleias</title>
</head>
<body>
<h1>Listagem de Boleias</h1>
<table>
    <tr>
        <th>Request ID</th>
        <th>Username</th>
        <th>Ride Date</th>
        <th>Event ID</th>
        <th>Requested Seats</th>
        <th>Is Accepted</th>
        <th>Pickup Location</th>
    </tr>
    <%
        List<RideRequest> rideRequests = RideRequestDAO.getAllRideRequests();
        for (RideRequest rideRequest : rideRequests) {
    %>
    <tr>
        <td><%= rideRequest.getRequestID() %></td>
        <td><%= rideRequest.getUsername() %></td>
        <td><%= rideRequest.getRideDate() %></td>
        <td><%= rideRequest.getEventID() %></td>
        <td><%= rideRequest.getRequestedSeats() %></td>
        <td><%= rideRequest.getIsAccepted() %></td>
        <td><%= rideRequest.getPickupLocation() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
