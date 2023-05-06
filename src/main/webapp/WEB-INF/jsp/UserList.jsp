<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="BackEnd.FormsDAO, BackEnd.Form, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Formulários</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Lista de Formulários</h1>
<table>
    <thead>
    <tr>
        <th>Link</th>
        <th>Nome</th>
        <th>Data de término</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Form> forms = FormsDAO.getAllForms();
        for (Form form : forms) {
    %>
    <tr>
        <td><%= form.getLink() %></td>
        <td><%= form.getName() %></td>
        <td><%= form.getEndDate() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
