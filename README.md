# 📅 Microsserviço de Gerenciamento de Eventos
Este projeto é uma aplicação web simples para cadastrar eventos associados a cidades, listar eventos e cidades, e excluir registros com base no nome. Ele utiliza JavaScript (frontend) e uma API backend para fornecer as funcionalidades principais.


## 🚀 Tecnologias Utilizadas
- Java 17+
- Spring Boot 3.3.9
- Spring Web
- Spring Data JPA
- H2 Database (ambiente de testes)
- Bean Validation (JSR 380)
- Git
- Maven

## ⚙️ Funcionalidades
- 🔍 Listagem de Eventos e Cidades (GET /eventos, GET /cidades)
- 📄 Consultas por ID (GET /eventos/{id}, GET /cidades/{id})
- ➕ Criação (POST /eventos, POST /cidades)
- ✏️ Atualização (PUT /eventos/{id}, PUT /cidades/{id})
- ❌ Remoção (DELETE /eventos/{id}, DELETE /cidades/{id})

## 🛠️ Validações Implementadas
- Nome:	3-100 caracteres
- URL: 10-255 caracteres
- Estado:	3-100 caracteres
- UF: Exatamente 2 caracteres
- Data: Formato: yyyy-mm-dd

## 💾 Banco de Dados
- Banco em memória H2 configurado para ambiente de testes
- Arquivo data.sql para carga inicial com 5 registros de exemplo por entidade

## Acessar a aplicação para teste do BD:
API: http://localhost:8080  Console H2: http://localhost:8080/h2-console

## 👩‍💻 Desenvolvedora
Heloísa Santos
helosantosdesousa@gmail.com
