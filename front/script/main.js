import { cadastrarEvento, buscarEventos, buscarCidades, excluir } from './api.js';

document.addEventListener('DOMContentLoaded', () => {
  buscarCidades().then(cidades => {
    const select = document.getElementById('evento-cidade');
    
    cidades.forEach(cidade => {
      const option = document.createElement('option');
      option.value = cidade.id;
      option.textContent = cidade.nome;
      select.appendChild(option);
    });
  });
});

function handleCadastrarEvento() {
  const nome = document.getElementById('evento-nome').value;
  const data = document.getElementById('evento-data').value; 
  const url = document.getElementById('evento-url').value;
  const cidadeId = document.getElementById('evento-cidade').value;

  if (nome && data && url && cidadeId) {
    const evento = {
      nome: nome,
      data: data,  
      url: url,
      cidade: {
        id: parseInt(cidadeId)  
      }
    };

    console.log("Evento a ser enviado:", evento);

    cadastrarEvento(evento)
      .then(() => {
        alert("Evento cadastrado com sucesso!");
      })
      .catch((error) => {
        console.error("Erro ao cadastrar evento:", error);
        alert("Erro ao cadastrar evento!");
      });
  } else {
    alert('Por favor, preencha todos os campos!');
  }
}

function procurarEventos() {
  buscarEventos().then((eventos) => {
    const listaEventos = document.getElementById('lista-eventos');
    listaEventos.innerHTML = ''; 

    eventos.forEach((evento) => {
      const li = document.createElement('li');
      
      const cidadeNome = evento.cidade && evento.cidade.nome ? evento.cidade.nome : 'Cidade desconhecida';

      li.textContent = `${evento.nome} - ${cidadeNome}`;
      listaEventos.appendChild(li);
    });

    // Alterna a visibilidade da lista
    const listaEventosContainer = document.getElementById('lista-eventos');
    listaEventosContainer.classList.toggle('d-none');
  });
}

function procurarCidades() {
  buscarCidades().then((cidades) => {
    const listaCidades = document.getElementById('lista-cidades');
    listaCidades.innerHTML = ''; 

    cidades.forEach((cidade) => {
      const li = document.createElement('li');
      li.textContent = `${cidade.nome} - ${cidade.uf}`;
      listaCidades.appendChild(li);
    });

    // Alterna a visibilidade da lista
    const listaCidadesContainer = document.getElementById('lista-cidades');
    listaCidadesContainer.classList.toggle('d-none');
  });
}

function handleExcluir() {
  const nome = document.getElementById('id-excluir').value.trim();
  const tipo = document.getElementById('tipo-excluir').value;

  if (!nome) {
    alert('Por favor, informe o nome para excluir!');
    return;
  }

  const buscar = tipo === 'evento' ? buscarEventos : buscarCidades;

  buscar().then(lista => {
    const itemEncontrado = lista.find(item => item.nome.toLowerCase() === nome.toLowerCase());

    if (itemEncontrado) {
      excluir(itemEncontrado.id, tipo); 
    } else {
      alert(`${tipo} com nome "${nome}" não encontrado.`);
    }
  }).catch(() => {
    alert(`Erro ao buscar ${tipo}s para exclusão`);
  });
}

document.getElementById('btn-excluir').addEventListener('click', handleExcluir);
document.getElementById('btn-cadastrar').addEventListener('click', handleCadastrarEvento);
document.getElementById('btn-procurar-eventos').addEventListener('click', procurarEventos);
document.getElementById('btn-procurar-cidades').addEventListener('click', procurarCidades);
