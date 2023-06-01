// Array de jogadores da team1
const playersTeam1 = [];

// Array de jogadores da team2
const playersTeam2 = [];

// Array de equipes
const teams = [];

// Array de números team1
const shirtNumTeam1 = [];

// Array de números team2
const shirtNumTeam2 = [];

// Array de sets
const sets = ['1', '2', '3'];

//Array de jogadas
const plays = [];


// Função para carregar a transmissão de vídeo ao vivo
function loadStream() {
    const streamUrl = document.getElementById('streamUrl').value;

    // A URL do vídeo deve ser uma URL válida
    if (streamUrl && streamUrl.trim() !== '') {
        const video = document.getElementById('videoStream');
        // Limpa quaisquer fontes de vídeo existentes
        while (video.firstChild) {
            video.removeChild(video.firstChild);
        }
        // Adiciona a nova fonte de vídeo
        const source = document.createElement('source');
        source.src = streamUrl;
        source.type = 'application/x-mpegURL'; // O tipo MIME para streams HLS (.m3u8)
        video.appendChild(source);
        video.load(); // Carrega o vídeo
    }
}

// Obtém o botão Carregar Transmissão e adiciona o evento de clique
const loadStreamButton = document.getElementById('loadStream');
loadStreamButton.addEventListener('click', function(event) {
    event.preventDefault(); // Evita a submissão do formulário
    loadStream(); // Carrega a transmissão de vídeo ao vivo
});

function getPlayersTeam1(){

    fetch('http://localhost:8080/playersTeam1')
        .then(response => response.json())
        .then(data => {
            playersTeam1.push(...data);
            console.log(playersTeam1);
        })
        .catch(error => {
            console.error('Erro:', error);
        });

}

function getPlayersTeam2(){

    fetch('http://localhost:8080/playersTeam2')
        .then(response => response.json())
        .then(data => {
            playersTeam2.push(...data);
            console.log(playersTeam2);
        })
        .catch(error => {
            console.error('Erro:', error);
        });

}

function getTeams(){

    fetch('http://localhost:8080/teams')
        .then(response => response.json())
        .then(data => {
            teams.push(...data);

            teams.forEach(equipe => {
                console.log('equipa ' + equipe);
                const option = document.createElement('option');
                option.value = equipe;
                option.textContent = equipe;
                teamSelect.appendChild(option);
            });

        })
        .catch(error => {
            console.error('Erro:', error);
        });

}

function getShirtNumbersTeam1(){

    fetch('http://localhost:8080/shirtNumbersTeam1')
        .then(response => response.json())
        .then(data => {
            shirtNumTeam1.push(...data);

        })
        .catch(error => {
            console.error('Erro:', error);
        });

}

function getShirtNumbersTeam2(){

    fetch('http://localhost:8080/shirtNumbersTeam2')
        .then(response => response.json())
        .then(data => {
            shirtNumTeam2.push(...data);

        })
        .catch(error => {
            console.error('Erro:', error);
        });

}

getPlayersTeam1();
getPlayersTeam2();
getTeams();
getShirtNumbersTeam1();
getShirtNumbersTeam2();


console.log(shirtNumTeam1);
console.log(shirtNumTeam2);




// Obtém as select boxes onde as opções dos jogadores, equipes, números e sets serão adicionadas
const teamSelect = document.getElementById('equipe');

// Cria as opções para cada equipe
document.addEventListener('DOMContentLoaded', function() {
    const teamSelect = document.getElementById('equipe');
    const playerSelect = document.getElementById('jogador');
    const shirtNumSelect = document.getElementById('numeroJogadora');
    const setSelect = document.getElementById('set');

    teamSelect.addEventListener('change', function () {
        playerSelect.innerHTML = '';
        shirtNumSelect.innerHTML = '';

        let selectedTeam = teamSelect.value;

        if (selectedTeam === teams[0]) {
            playersTeam1.forEach(player => {
                const option = document.createElement('option');
                option.value = player.name;
                option.textContent = player.name;
                playerSelect.appendChild(option);
            });

            shirtNumTeam1.forEach(shirtNumber => {
                const option = document.createElement('option');
                option.value = shirtNumber;
                option.textContent = shirtNumber;
                shirtNumSelect.appendChild(option);
            });

            sets.forEach(set => {
                const option = document.createElement('option');
                option.value = set;
                option.textContent = set;
                setSelect.appendChild(option);
            });

        } else if (selectedTeam === teams[1]) {
            playersTeam2.forEach(player => {
                const option = document.createElement('option');
                option.value = player.name;
                option.textContent = player.name;
                playerSelect.appendChild(option);
            });

            shirtNumTeam2.forEach(shirtNumber => {
                const option = document.createElement('option');
                option.value = shirtNumber;
                option.textContent = shirtNumber;
                shirtNumSelect.appendChild(option);
            });

            sets.forEach(set => {
                const option = document.createElement('option');
                option.value = set;
                option.textContent = set;
                setSelect.appendChild(option);
            });

        }
    });
});


// Função para gerar o código da jogada
    function gerarCodigo() {
        const tipoJogada = document.getElementById('tipoJogada').value.charAt(0);
        const tipoJogadaNome = document.getElementById('tipoJogada').value;
        //const equipe = document.getElementById('equipe').value.charAt(0);
        const equipe = teamSelect.value;
        const jogador = document.getElementById('jogador').value.charAt(0);
        const nomeJogador = document.getElementById('jogador').value;
        const numeroJogadora = document.getElementById('numeroJogadora').value;
        const set = document.getElementById('set').value;

        // Obtém o tempo atual do vídeo em minutos e segundos
        const video = document.getElementById('videoStream');
        let minutos = Math.floor(video.currentTime / 60);
        let segundos = Math.floor(video.currentTime % 60);

// Subtrair 10 segundos
        segundos = segundos - 10;
        if (segundos < 0) {
            segundos = 60 + segundos; // Recalcular os segundos
            minutos = Math.max(0, minutos - 1); // Decrementar os minutos, garantindo que seja pelo menos 0
        }
        let tempo = `${minutos < 10 ? '0' : ''}${minutos}:${segundos < 10 ? '0' : ''}${segundos}`;
        let tempo2 = '00:01:39';

        const codigoJogada = `${tipoJogada}${equipe}${jogador}${numeroJogadora}${set}(${tempo})`;

        const play = {
            tipoJogada: tipoJogadaNome,
            code: codigoJogada,
            equipe: equipe,
            jogador: nomeJogador,
            numeroJogadora: numeroJogadora,
            set: set,
            time: tempo
        };
        console.log(play);

        const xhr = new XMLHttpRequest();
        xhr.open("POST", "/adicionar-jogada", true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(JSON.stringify(play));

        document.getElementById('codigoJogada').textContent = codigoJogada;


// Cria uma nova div para o item da jogada
        const jogadaItem = document.createElement('div');
        jogadaItem.textContent = codigoJogada;
        jogadaItem.style.cursor = 'pointer';
        jogadaItem.classList.add('jogada-item'); // Adiciona a classe CSS
        jogadaItem.addEventListener('click', () => {
            video.currentTime = Math.max(0, minutos * 60 + segundos); // Redireciona para 10 segundos antes do minuto e segundo do vídeo
            video.play();
        });
        document.getElementById('listaJogadas').appendChild(jogadaItem);
    }




