# Command Center

## Descrição

O **Command Center** é uma solução em Java que permite a recepção e manipulação de pedidos de clientes (comandos). A API aceita comandos em formato JSON e XML, calcula descontos com base na quantidade de produtos e armazena os comandos em um banco de dados MySQL.

## Funcionalidades

- Recepção de comandos em formatos JSON e XML.
- Validação de número de controle para evitar duplicatas.
- Aplicação automática de descontos baseados na quantidade de produtos.
- Persistência dos comandos em um banco de dados MySQL.
- API RESTful para consulta de comandos.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.1
- Spring Data JPA
- MySQL
- Lombok

## Como Configurar e Executar o Projeto

### Pré-requisitos

- JDK 21 instalado
- Maven instalado
- MySQL instalado e em execução

### Passos para Configuração

1. **Clone o repositório:**
    ```bash
    git clone https://github.com/seuusuario/command-center.git
    cd command-center
    ```

2. **Configure o Banco de Dados:**

    - Crie o banco de dados MySQL necessário e ajuste as credenciais no arquivo `application.properties`:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/command_center_db
      spring.datasource.username=root
      spring.datasource.password=root
      ```

    - Execute o script SQL localizado em `src/main/resources/schema.sql` para criar as tabelas necessárias:
      ```bash
      mysql -u root -p command_center_db < src/main/resources/schema.sql
      ```

3. **Compile e execute a aplicação:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. **Acesse a API:**
    - A API estará disponível em `http://localhost:8080/api/commands`.

## Endpoints Principais

- `POST /api/commands`: Criar um novo comando.
- `GET /api/commands`: Consultar comandos existentes.

## Contribuições

Contribuições são bem-vindas! Por favor, faça um fork do repositório e envie um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Contato

- Email: seuemail@exemplo.com
- LinkedIn: [Seu LinkedIn](https://www.linkedin.com/in/seulinkedin/)
