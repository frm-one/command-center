# Guia de Ajuda - Command Center

## Solução de Problemas Comuns

### 1. Erro de Conexão com o Banco de Dados

**Problema:** A aplicação não consegue conectar ao banco de dados MySQL.

**Solução:**
- Verifique se o MySQL está em execução.
- Certifique-se de que as credenciais de acesso no `application.properties` estão corretas.
- Teste a conexão manualmente com o comando:
    ```bash
    mysql -u root -p
    ```

### 2. Problemas de Compilação ou Execução

**Problema:** O projeto não compila ou não executa corretamente.

**Solução:**
- Certifique-se de que você está usando o JDK 21.
- Rode `mvn clean install` para garantir que todas as dependências estão atualizadas.
- Verifique se todas as dependências do Maven estão corretamente definidas no `pom.xml`.

### 3. Como Configurar um Ambiente de Desenvolvimento

- **IDE:** Recomenda-se o uso do IntelliJ IDEA para o desenvolvimento com Java.
- **Plugin Lombok:** Certifique-se de que o plugin Lombok está habilitado na sua IDE.
- **Testes:** Rode os testes unitários com:
    ```bash
    mvn test
    ```

### 4. Extensão e Personalização

Se você deseja estender as funcionalidades da API, siga os passos:

- **Adicionando Novos Endpoints:**
    - Crie novos métodos no `PedidoController.java` e defina as rotas necessárias.
    - Adicione a lógica de negócios correspondente no `PedidoService.java`.

- **Adicionando Novas Entidades:**
    - Crie novas classes no pacote `model` e mapeie-as com JPA.
    - Crie repositórios para as novas entidades em `repository`.