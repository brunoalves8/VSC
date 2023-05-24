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
// Array de jogadores
const jogadores = ['Jogador 1', 'Jogador 2', 'Jogador 3'];

// Array de equipes
const equipes = ['Equipe 1', 'Equipe 2'];

// Array de números
const numeros = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10'];

// Array de sets
const sets = ['1', '2', '3'];

// Obtém as select boxes onde as opções dos jogadores, equipes, números e sets serão adicionadas
const jogadorSelect = document.getElementById('jogador');
const equipeSelect = document.getElementById('equipe');
const numeroSelect = document.getElementById('numeroJogadora');
const setSelect = document.getElementById('set');

// Cria as opções para cada jogador
jogadores.forEach(jogador => {
    const option = document.createElement('option');
    option.value = jogador;
    option.textContent = jogador;
    jogadorSelect.appendChild(option);
});

// Cria as opções para cada equipe
equipes.forEach(equipe => {
    const option = document.createElement('option');
    option.value = equipe;
    option.textContent = equipe;
    equipeSelect.appendChild(option);
});

// Cria as opções para cada número
numeros.forEach(numero => {
    const option = document.createElement('option');
    option.value = numero;
    option.textContent = numero;
    numeroSelect.appendChild(option);
});

// Cria as opções para cada set
sets.forEach(set => {
    const option = document.createElement('option');
    option.value = set;
    option.textContent = set;
    setSelect.appendChild(option);
});

// Função para gerar o código da jogada
function gerarCodigo() {
    const tipoJogada = document.getElementById('tipoJogada').value.charAt(0);
    const equipe = document.getElementById('equipe').value.charAt(0);
    const jogador = document.getElementById('jogador').value.charAt(0);
    const numeroJogadora = document.getElementById('numeroJogadora').value.charAt(0);
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

    const codigoJogada = `${tipoJogada}${equipe}${jogador}${numeroJogadora}(${minutos}:${segundos < 10 ? '0' : ''}${segundos})`;

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
