# Sistema de Gestão de Cursos (API REST)

##  Descrição do Projeto

API RESTful desenvolvida em Java com o framework Spring Boot para gerenciar o cadastro completo de Instrutores, Cursos e Alunos.

Este projeto foca na implementação do **Mapeamento Objeto-Relacional (JPA/Hibernate)**.

##  Funcionalidades (Endpoints CRUD)

* **Instrutor:** CRUD completo (`GET`, `POST`, `PUT`, `DELETE`).
* **Aluno:** CRUD completo (`GET`, `POST`, `PUT`, `DELETE`).
* **Curso:** CRUD completo (`GET`, `POST`, `PUT`, `DELETE`).
* **Matrícula (CursoAluno):** Criação (`POST`), Listagem (`GET`), e Desmatrícula (`DELETE`) via chave composta.

---

##  Tecnologias e Arquitetura

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3.x (Spring Web)
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** MySQL
* **Gerenciador:** Maven
* **Documentação:** Springdoc OpenAPI (Swagger)

### Estrutura em Camadas

O projeto segue a arquitetura de 3 Camadas:

1.  **Controller (`...controller`):** Gerencia as rotas REST (`/api/instrutores`).
2.  **Repository (`...repository`):** Acessa o banco de dados via `JpaRepository`.
3.  **Entity (`...entity`):** Modelos de dados (`@Entity`) e mapeamento de relações complexas (`@OneToMany`, `@ManyToOne`, `@EmbeddedId`).
   
---

## Setup e Configuração (Rodando Localmente)


Edite o arquivo **`src/main/resources/application.properties`**:

```properties
spring.application.name=gestao_cursos_api
server.port=8080 

# Conexão 
spring.datasource.url=jdbc:mysql://localhost:3306/gerenciador_cursos?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=dev
spring.datasource.password=dev123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true 
spring.jpa.hibernate.ddl-auto=update
