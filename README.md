![Java 17+](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot 4](https://img.shields.io/badge/Spring_Boot-4.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate 6](https://img.shields.io/badge/Hibernate-6.x-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

# 🛒 REST API Web Services com Spring Boot & JPA

API RESTful desenvolvida com **Spring Boot 4** e **Spring Data JPA** para gerenciamento de um domínio de e-commerce (Usuários, Pedidos, Produtos, Categorias e Pagamentos). 

O projeto conta com arquitetura em camadas bem definida, tratamento global de exceções, perfis de ambiente de desenvolvimento/teste e infraestrutura de banco de dados isolada via **Docker**.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Framework:** Spring Boot 4
- **Persistência & ORM:** Spring Data JPA / Hibernate
- **Banco de Dados:** 
  - PostgreSQL (Desenvolvimento via Docker)
  - H2 Database (Testes / Perfil `test`)
- **Containerização:** Docker & Docker Compose
- **Gerenciador de Dependências:** Maven

---

## 🏛️ Arquitetura e Estrutura do Projeto

O projeto segue o padrão de **Arquitetura em Camadas (Layered Architecture)**, separando responsabilidades de forma clara:

```text
├── resources --> Exposição das rotas e endpoints REST
├── services --> Regras de negócio e tratamento de exceções
├── repositories --> Camada de acesso a dados (Spring Data JPA)
├── entities --> Modelo de domínio, enums e chaves compostas
└── config --> Configurações de perfis e carga de dados de teste (Seeding)
```
## 📌 Endpoints da API

| Recurso | Método | Endpoint | Descrição | Status HTTP |
| :--- | :---: | :--- | :--- | :---: |
| **Usuários** | `GET` | `/users` | Lista todos os usuários | `200 OK` |
| | `GET` | `/users/{id}` | Busca usuário por ID | `200 OK` / `404` |
| | `POST` | `/users` | Cadastra um novo usuário | `201 Created` |
| | `PUT` | `/users/{id}` | Atualiza dados do usuário | `200 OK` / `404` |
| | `DELETE` | `/users/{id}` | Remove usuário por ID | `204 No Content` |
| **Pedidos** | `GET` | `/orders` | Lista todos os pedidos | `200 OK` |
| | `GET` | `/orders/{id}` | Busca pedido por ID | `200 OK` / `404` |
| **Produtos** | `GET` | `/products` | Lista todos os produtos | `200 OK` |
| | `GET` | `/products/{id}` | Busca produto por ID | `200 OK` / `404` |
| **Categorias** | `GET` | `/categories` | Lista todas as categorias | `200 OK` |
| | `GET` | `/categories/{id}` | Busca categoria por ID | `200 OK` / `404` |

---

## 🚨 Tratamento Global de Exceções

A API utiliza o padrão `@ControllerAdvice` (`ResourceExceptionHandler`) para interceptar erros da aplicação e retornar respostas HTTP limpas e padronizadas no objeto `StandardError`:

- **`ResourceNotFoundException` (`404 Not Found`)**: Disparada ao buscar, atualizar ou deletar um ID inexistente.
- **`DatabaseException` (`400 Bad Request`)**: Disparada ao tentar deletar um registro que possui vínculos com outras tabelas (violação de integridade referencial).

### Exemplo de Resposta de Erro (Payload):
```json
{
  "timestamp": "2026-08-01T02:15:00Z",
  "status": 404,
  "error": "Resource not found",
  "message": "Resource not found. Id 99",
  "path": "/users/99"
}
