<h1 align="center">
  TODO List
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=GitHub&message=@DevEmannuelMorais&color=blue&labelColor=000000" alt="DevEmannuelMorais" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=blue&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar comidas levadas para um café da manhã (CRUD) que faz parte [desse desafio](https://github.com/unidac-grupo-wl/desafio-unidac-grupo-wl) para pessoas desenvolvedoras backend júnior, que se candidatam para o Grupo WL.


## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/organizecafe-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Coffee
```
$ http POST :8080/coffe/create coffeeDate="22/07/2023" coffeeItem="Paes" collaborator_id=1 realized=true

[
  {
    "coffeeDate": "22/07/2023",
    "coffeeItem": "Paes",
    "collaborator_id": 1,
    "realized": true
  }
]
```

- Listar Coffes
```
$ http GET :8080/coffee

[
  {
    "id": 1,
    "collaborator": {
      "id": 1,
      "cpf": "38240106072",
      "name": "Emannuel Morais"
    },
    "coffeeItem": "Paes",
    "coffeeDate": "22/07/2023",
    "realized": true
  }
]
```

- Atualizar Coffee
```
$ http PUT :8080/coffee/update/1 coffeeDate="22/07/2023" coffeeItem="Paes" realized=true

[
  {
    "id": 1,
    "collaborator": {
      "id": 1,
      "cpf": "38240106072",
      "name": "Emannuel Morais"
    },
    "coffeeItem": "Paes",
    "coffeeDate": "22/07/2023",
    "realized": true

  }
]
```

- Remover Coffee
```
http DELETE :8080/coffee/delete/1

[ ]
```