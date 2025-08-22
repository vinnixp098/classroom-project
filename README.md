# 📋 Reserva de Salas - API REST

Este projeto tem como finalidade organizar as salas de modo que seja possível reservar uma sala, visualizar as salas reservadas, editar o horário de reserva e excluir uma reserva.

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot 3.5**
- 📦 **Maven**
- 🗃️ **Spring Data JPA**
- 💾 **H2 Database (em memória)**
- 🔧 **Spring Web**
- ✍️ **Lombok**

---

## 📂 Estrutura do Projeto

O projeto segue uma arquitetura simples com os pacotes organizados em:

- `controller`: Responsável por expor os endpoints da API.
- `entity`: Entidade `AUla`.
- `DTOs`: Interfaces de objeto de transferência de dados.
- `repository`: Interface JPA para comunicação com o banco.
- `service` (opcional): Regras de negócio (se aplicável).

---


## ▶️ Como executar o projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/vinnixp098/classroom-project.git
   cd cadastro-usuario
