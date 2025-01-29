# Sistema de Cinema - Orientação a Objetos

## Descrição

Este é um sistema de cinema desenvolvido utilizando a abordagem de Programação Orientada a Objetos (POO). O sistema permite o gerenciamento de filmes, sessões e usuários, com funcionalidades diferenciadas para usuários e funcionários, incluindo um sistema de login, cadastro de filmes e sessões, e funções de gerenciamento de filmes, restritas ao administrador.

## Funcionalidades

- **Login de Usuário**: Os usuários podem fazer login para visualizar filmes e sessões. As informações de login são armazenadas em um banco de dados MySQL.
- **Login de Funcionário**: Os funcionários podem se logar, com diferentes permissões dependendo de sua função (administrador pode adicionar filmes, por exemplo).
- **Cadastro de Filmes**: O administrador pode cadastrar filmes, informando nome, duração, classificação, gênero e data de lançamento.
- **Cadastro de Sessões**: Cada filme terá sessões com informações como data, horário, preço do ingresso e funcionário responsável.
- **Cadastro de Usuário e Funcionário**: O sistema permite o cadastro de usuários e funcionários, com validação de dados como CPF e idade.

## Estrutura de Classes

### 1. **Classe `Usuario`**
Representa um usuário do sistema.

- `nome: String`
- `senha: String`
- `idade: int`
- `cpf: String (11)`
- `filmeQueGosta(): List<String>`

### 2. **Classe `Funcionario`**
Representa um funcionário do cinema, que pode ter uma função de administrador ou atendente.

- `nome: String`
- `senha: String`
- `idade: int`
- `cpf: String (11)`
- `funcao: String` (ex.: "Administrador", "Atendente")

### 3. **Classe `Filme`**
Representa um filme no cinema.

- `nome: String`
- `duracao: int` (em minutos)
- `classificacao: String`
- `genero: String`
- `dataLancamento: String` (ex.: "2025-02-01")

### 4. **Classe `Sessao`**
Representa uma sessão de filme, com informações sobre horário, preço e funcionário responsável.

- `nomeFilme: String`
- `data: String` (ex.: "2025-02-01")
- `horario: String` (ex.: "15:30")
- `precoIngresso: double`
- `funcionarioResponsavel: String`

## Banco de Dados

### Tabelas

- **Tabela `usuarios`**
    - `id`: INT
    - `nome`: VARCHAR
    - `senha`: VARCHAR
    - `idade`: INT
    - `cpf`: VARCHAR(11)
    - `filmes_que_gosta`: TEXT (JSON ou outro formato de serialização)
  
- **Tabela `funcionarios`**
    - `id`: INT
    - `nome`: VARCHAR
    - `senha`: VARCHAR
    - `idade`: INT
    - `cpf`: VARCHAR(11)
    - `funcao`: VARCHAR

- **Tabela `filmes`**
    - `id`: INT
    - `nome`: VARCHAR
    - `duracao`: INT
    - `classificacao`: VARCHAR
    - `genero`: VARCHAR
    - `data_lancamento`: DATE

- **Tabela `sessoes`**
    - `id`: INT
    - `nome_filme`: VARCHAR
    - `data`: DATE
    - `horario`: TIME
    - `preco_ingresso`: DOUBLE
    - `funcionario_responsavel`: VARCHAR

## Requisitos

- Java 8 ou superior
- MySQL
- JDBC para integração com o banco de dados

## Como Rodar o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```

2. Configure o banco de dados MySQL com as tabelas mencionadas acima.

3. Edite o arquivo de configuração do banco de dados para fornecer suas credenciais.

4. Compile e execute o projeto.

## Contribuição

Se você deseja contribuir com este projeto, siga os passos abaixo:

1. Faça um fork deste repositório.
2. Crie uma nova branch (`git checkout -b feature/nome-da-feature`).
3. Faça suas alterações e commit (`git commit -am 'Adicionando nova feature'`).
4. Push para a branch (`git push origin feature/nome-da-feature`).
5. Abra um pull request.

## Licença

Este projeto está licenciado sob a licença MIT - consulte o arquivo [LICENSE](LICENSE) para mais detalhes.
Desenvolvido com 💻 e ☕ durante o curso Tecnico de Infromatica IFSP(2024): Mergulhe em Programação com Java Orientada a objeto.
