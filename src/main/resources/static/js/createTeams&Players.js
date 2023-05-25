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
    var progressText = document.getElementById("progress-text");
    progressText.style.backgroundPosition = '0%';


    setTimeout(function() {
        window.location.href = "http://localhost:8080/registerCodes"; // mude para a URL desejada
    }, 3500);  // Redireciona após 2 segundos, o mesmo tempo que definimos para a transição do texto.
});