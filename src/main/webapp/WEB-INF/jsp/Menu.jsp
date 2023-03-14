<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        .container {
            display: flex;
            flex-direction: row;
            height: 100vh;
            width: 100%;
        }
        .dashboard {
            background-color: #000;
            border-radius: 25px;
            margin: 20px 10px 20px 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            color: #fff;
            padding: 10px;
            width: 90px;
        }
        .dashboard img {
            max-width: 60px;
            margin-top: 10px;
        }
        .dashboard ul {
            list-style: none;
            margin-top: 10px;
            padding: 0;
            width: 100%;
            text-align: center;
        }
        .dashboard li {
            margin-bottom: 10px;
        }
        .dashboard li a {
            color: #fff;
            text-decoration: none;
            font-size: 12px;
        }
        .search-box {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: flex-end;
            margin: 10px 20px;
        }
        .search-box input[type="text"] {
            border: none;
            border-radius: 5px;
            padding: 8px;
            background-color: #eee;
            margin-right: 5px;
            width: 200px;
        }
        .search-box button {
            border: none;
            border-radius: 5px;
            padding: 8px 15px;
            background-color: rgb(201, 200, 200);
            color: #fff;
            cursor: pointer;
        }
        .menu-items {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            justify-content: flex-start;
            margin-top: 10px;
            margin-left: 20px;
            width: calc(100% - 20px);
        }
        .menu-items a {
            display: block;
            margin-bottom: 10px;
            color: #000;
            text-decoration: none;
            font-size: 16px;
        }
        .menu-items a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="dashboard">
        <img src="./logo-vsc-300x300-1.png" alt="Vitória Sport Clube">
        <ul>
            <li><a href="#"><i class="fas fa-home"></i></a></li>
            <li><a href="#"><i class="fas fa-user"></i></a></li>
            <li><a href="#"><i class="fas fa-video"></i></a></li>
        </ul>
        <a href="#"><i class="fas fa-cog"></i></a>
        <a href="#"><i class="fas fa-sign-out-alt"></i></a>
    </div>
    <div class="menu-items">
        <div class="search-box">
            <input type="text" placeholder="Pesquisar...">
            <button>Pesquisar</button>
