let playerCounter = 0;

function addPlayer(teamId) {
    let container = document.getElementById(teamId);
    let playerDiv = document.createElement('div');
    playerDiv.id = 'playerDiv' + playerCounter;

    let inputName = document.createElement('input');
    inputName.type = 'text';
    inputName.placeholder = 'Nome do Jogador';
    inputName.classList.add('playerName');
    inputName.id = 'playerName' + playerCounter;

    let inputNumber = document.createElement('input');
    inputNumber.type = 'number';
    inputNumber.placeholder = 'Número';
    inputNumber.classList.add('playerNumber');
    inputNumber.id = 'playerNumber' + playerCounter;

    let removeButton = document.createElement('button');
    removeButton.textContent = 'Remover Jogador';
    removeButton.classList.add('removeButton'); // adiciona a classe 'removeButton' ao botão
    removeButton.onclick = function() {
        container.removeChild(playerDiv);
    };

    playerDiv.appendChild(inputName);
    playerDiv.appendChild(inputNumber);
    playerDiv.appendChild(removeButton);

    container.appendChild(playerDiv);
    playerCounter++;
}
function enviarDados() {
    // Obtenha os dados do formulário ou outras informações relevantes
    var team1 = document.getElementById("team1").value;
    var team2 = document.getElementById("team2").value;
    var playersTeam1 = obterJogadores("team1");
    var playersTeam2 = obterJogadores("team2");

    // Crie um objeto com os dados a serem enviados
    var dados = {
        team1: team1,
        team2: team2,
        playersTeam1: playersTeam1,
        playersTeam2: playersTeam2
    };

    // Faça a chamada Ajax para enviar os dados para o servidor
    $.ajax({
        url: "/adicionarInfoGameVideo",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(dados),
        success: function(response) {
            // Manipule a resposta do servidor, se necessário
            alert("Dados introduzidos com sucesso");
            console.log(response);
        },
        error: function(xhr, status, error) {
            // Lide com erros de chamada Ajax, se necessário
            alert("Surgiu algum erro");
            console.error(error);
        }
    });
///EXEMPLO
    /*const xhr = new XMLHttpRequest();
    xhr.open("POST", "/adicionarInfoGameVideo", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                // Se a resposta do backend for bem sucedida exibe uma mensagem de sucesso
                alert("Dados adicionados com sucesso!");

                // Atualize a exibição do calendário, se necessário

            } else {
                // Se ocorrer algum erro no backend, exibe uma mensagem de erro adequada
                alert("Erro ao adicionar dados");
            }
        }
    };
    xhr.send(JSON.stringify(dados));
}*/

function obterJogadores(timeID) {
    var players = [];

    // Obtenha os dados dos jogadores do formulário ou outra fonte de dados
    var playerNames = document.getElementsByClassName(timeID + "-player-name");
    var playerShirts = document.getElementsByClassName(timeID + "-player-shirt");

    // Crie objetos PlayerOfGame para cada jogador
    for (var i = 0; i < playerNames.length; i++) {
        var playerName = playerNames[i].value;
        var playerShirt = parseInt(playerShirts[i].value);

        var player = {
            name: playerName,
            shirt: playerShirt,
            timeID: timeID
        };

        players.push(player);
    }

    return players;
}
document.getElementById('saveBtn').addEventListener('click', function() {
    let teamNames = [document.getElementById('teamName1').value, document.getElementById('teamName2').value];

    for (let i = 0; i < playerCounter; i++) {
        let playerName = document.getElementById('playerName' + i);
        let playerNumber = document.getElementById('playerNumber' + i);
        if (playerName && playerNumber) {
            let teamId = playerName.parentElement.parentElement.id;
            let teamName = teamId === 'playersTeam1' ? teamNames[0] : teamNames[1];
            console.log('Equipa: ' + teamName);
            console.log('Nome do Jogador: ' + playerName.value);
            console.log('Número: ' + playerNumber.value);
        }
    }

    });
}

