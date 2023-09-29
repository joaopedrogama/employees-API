# Employee-API 🪐

Esta é uma api proposta pelo desafio da SSYS com o objetivo de gerenciar melhor seus usuarios e obter relatórios sobre os mesmos.

# Instruções para Executar o Projeto Java Spring Boot 📚
## Requisitos 👨‍🚀

- Java 17
- Maven
- Docker
- Docker Compose

## Clone do Repositório 🔭

Para começar, faça um clone deste repositório para sua máquina local usando o seguinte comando:

```bash
git clone https://github.com/joaopedrogama/employee-API.git
```

## Executar com Docker Compose 🚀
Navegue até o diretório raiz do projeto clonado e execute o seguinte comando para iniciar o ambiente com Docker Compose:

```bash
docker compose up --build -d
```
Isso irá iniciar o banco de dados para o ambiente de desenvolvimento :)

# Executar o Projeto Spring Boot 🕹️
Agora que o ambiente Docker está em execução, você pode iniciar o projeto Spring Boot. Certifique-se de estar no diretório raiz do projeto e execute o seguinte comando:

```bash
mvn spring-boot:run
```

## Acessar a Documentação das Rotas 🛰️
Para acessar a documentação das rotas e testá-las, abra seu navegador da web e vá para:

```http
http://localhost:8080/swagger-ui.html
```

Isso abrirá a interface Swagger UI, onde você pode visualizar e testar todas as rotas disponíveis no projeto.
