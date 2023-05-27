<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Jogos</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CoachGamesSubMenu.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://kit.fontawesome.com/6132df651f.js" crossorigin="anonymous"></script>

</head>

<body>
<div class="nav-container">
    <nav>
        <div class="nav-header"></div>
        <a href="#" class="logo">
            <img src="/static/images/Logo-512x512-1.png" alt="Vitória SC Logo">
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

<div class="container">

    <div class="header">
        <h1>Jogos</h1>
    </div>

    <div class="options">

        <div class="option"><a href="#">
            <div class="nameCat">
                <i class="icon fa-solid fa-magnifying-glass text-center mr-1"></i>
                <span class="catName">Visualizar Momentos do Jogo</span>
            </div></a>
        </div>

        <div class="option"><a href="#">
            <div class="nameCat">
                <i class=" icon fa-solid fa-volleyball"></i>
                <span class="catName">Criar Jogo</span>
            </div></a>
        </div>
    </div>
</div>
</body>
</html>