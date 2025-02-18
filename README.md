# CRUD de Clientes - Spring Boot

## Descrição

Este projeto é um CRUD completo de clientes desenvolvido com Spring Boot. Ele expõe web services REST para gerenciar clientes, incluindo operações de:

- Busca paginada de clientes

- Busca de cliente por ID

- Inserção de um novo cliente

- Atualização de cliente

- Deleção de cliente

O banco de dados utilizado é o H2, configurado para ambiente de testes. O projeto também trata exceções de ID inexistente e erros de validação.

## Tecnologias Utilizadas

- Java 17

- Spring Boot 3

- Spring Data JPA

- Banco de Dados H2 (ambiente de testes)

- Maven

- Postman (para testes de API)

## Instalação e Execução

Pré-requisitos

Certifique-se de ter instalado em seu ambiente:

- Java 17

- Maven

- Uma IDE como IntelliJ ou Eclipse

## Passos para executar o projeto

- Clone o repositório:

    git clone https://github.com/gustavolucenadev/java_spring_CRUD

- Acesse a pasta do projeto:

    cd nome-do-repositorio

- Execute o projeto com o Maven:

    mvn spring-boot:run

- O projeto estará rodando em http://localhost:8080

## Endpoints da API

1. Busca paginada de clientes

    ```GET /clients?page=0&size=6&sort=name ```

  Retorna uma lista paginada de clientes

2. Busca de cliente por ID

```GET /clients/{id}```

  Retorna um cliente específico pelo ID

  Retorna 404 caso o ID não seja encontrado

3. Inserção de novo cliente

POST /clients

Exemplo de requisição:

```json

 {
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}

```

Retorna 422 caso existam erros de validação, como nome vazio ou data de nascimento futura

4. Atualização de cliente

PUT /clients/{id}

Exemplo de requisição:

```json

{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```

  Retorna 404 caso o ID não seja encontrado

  Retorna 422 caso existam erros de validação

5. Deleção de cliente

  ```DELETE /clients/{id}```

  Retorna 404 caso o ID não seja encontrado

 # Regras de Validação

  Nome: não pode ser vazio

  Data de nascimento: não pode ser uma data futura

## Seed de Clientes

  O projeto inclui um seed de pelo menos 10 clientes com dados significativos no banco H2.

  Contato

## Caso tenha dúvidas ou sugestões, entre em contato:

GitHub: gustavolucenadev

Email: gus_duarte8@hotmail.com

