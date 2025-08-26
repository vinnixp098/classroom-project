# 📋 Reserva de Salas - API REST

Este projeto tem como finalidade organizar as salas de modo que seja possível reservar uma sala, visualizar as salas reservadas, editar o horário de reserva e excluir uma reserva.

-----

## 🚀 Tecnologias Utilizadas

  - ☕ **Java 17**
  - 🌱 **Spring Boot (Web, Data JPA, Validation)**
  - 🗃️ **PostgreSQL**
  - 📦 **Maven**
  - ✍️ **Lombok**

-----

## 📂 Estrutura do Projeto

O projeto segue uma arquitetura simples com os pacotes organizados em:

  - `controller`: Responsável por expor os endpoints da API.
  - `entity`: Entidade `AUla`.
  - `DTOs`: Interfaces de objeto de transferência de dados.
  - `repository`: Interface JPA para comunicação com o banco.
  - `service` (opcional): Regras de negócio (se aplicável).

-----

# 📑 Rotas da API 

Esta API disponibiliza os seguintes endpoints para gerenciamento de **reservas de salas**:

-----

## 🔍 Listar reservas por **dia** e **turno**

  - **GET** `http://localhost:8080/aulas?dia=SEXTA&turno=MATUTINO`

**Query Params (opcionais):**

  - `dia` → Dia da semana (SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA, SABADO)
  - `turno` → Turno (MATUTINO, VESPERTINO, NOTURNO)

-----

## 📋 Listar **todas** as reservas

  - **GET** `http://localhost:8080/aulas/reservados`

-----

## ➕ Cadastrar uma reserva

  - **POST** `http://localhost:8080/aulas`
  - ### Objeto de Cadastro (`POST`)

```json
{
	"sala": "123",
	"horario": "00:01:00",
	"andar": "1",
	"dia": "QUINTA",
	"professor": "Vinícius",
	"curso": "Ciencia",
	"aula": "aula 1",
	"bloco": "A",
	"turno": "MATUTINO",
	"disciplina": "POO"
}
```
      
-----

## ✍️ Editar uma reserva

  - **PUT** `http://localhost:8080/aulas/{id}`

  - ### Objeto de Edição (`PUT`)

```json
{
	"horario": "00:01:00",
	"dia": "QUINTA",
	"sala": "101",
	"turno": "MATUTINO"
}
```

-----

## 🗑️ Excluir uma reserva

  - **DELETE** `http://localhost:8080/aulas/{id}`

**Path Param:**

  - `{id}` → ID da reserva a ser excluída.

-----


## ▶️ Como executar o projeto

1.  **Clone o repositório:**
   `  
   git clone https://github.com/vinnixp098/classroom-project.git    
   cd classroom-project
   `
