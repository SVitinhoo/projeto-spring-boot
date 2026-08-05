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
