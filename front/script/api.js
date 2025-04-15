const API_BASE_URL = "http://localhost:8080";

function buscarEventos() {
  return fetch(`${API_BASE_URL}/eventos`)
    .then(response => response.json());
}

function buscarEventoPorId(id) {
  return fetch(`${API_BASE_URL}/eventos/${id}`)
    .then(response => response.json());
}

function cadastrarEvento(evento) {
  return fetch(`${API_BASE_URL}/eventos`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(evento)
  }).then(response => response.json());
}


function atualizarEvento(id, eventoAtualizado) {
  return fetch(`${API_BASE_URL}/eventos/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(eventoAtualizado)
  }).then(response => response.json());
}

function deletarEvento(id) {
  return fetch(`${API_BASE_URL}/eventos/${id}`, {
    method: "DELETE"
  });
}

// CIDADES

function buscarCidades() {
  return fetch(`${API_BASE_URL}/cidades`)
    .then(response => response.json());
}


function excluir(id, tipo) {
  let endpoint = tipo === 'evento' ? 'eventos' : 'cidades';
  return fetch(`${API_BASE_URL}/${endpoint}/${id}`, {
    method: 'DELETE'
  }).then(response => {
    if (response.ok) {
      alert(`${tipo} excluído com sucesso!`);
    } else {
      alert(`Erro ao excluir ${tipo}`);
    }
  });
}


function buscarCidadePorId(id) {
  return fetch(`${API_BASE_URL}/cidades/${id}`)
    .then(response => response.json());
}

function cadastrarCidade(cidade) {
  return fetch(`${API_BASE_URL}/cidades`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(cidade)
  }).then(response => response.json());
}


function atualizarCidade(id, cidadeAtualizada) {
  return fetch(`${API_BASE_URL}/cidades/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(cidadeAtualizada)
  }).then(response => response.json());
}

function deletarCidade(id) {
  return fetch(`${API_BASE_URL}/cidades/${id}`, {
    method: "DELETE"
  });
}

export {
  buscarEventos,
  buscarEventoPorId,
  cadastrarEvento,
  atualizarEvento,
  deletarEvento,
  buscarCidadePorId,
  cadastrarCidade,
  atualizarCidade,
  deletarCidade,
  buscarCidades,
  excluir  
};
