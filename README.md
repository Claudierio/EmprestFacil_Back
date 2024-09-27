# EmprestFacil Backend

Este repositório contém o backend do sistema **EmprestFacil**, uma aplicação para gerenciar empréstimos e usuários. O projeto utiliza Spring Boot para a construção da API.

## Tecnologias Utilizadas

- **Java**: Linguagem principal utilizada no backend.
- **Spring Boot**: Framework para a criação de aplicações Java com arquitetura baseada em microserviços.
- **Hibernate**: ORM para manipulação de banco de dados.
- **MySQL**: Banco de dados relacional para armazenar informações de usuários e empréstimos.

## Estrutura do Projeto

- `src/`: Contém o código-fonte principal do projeto.
  - `main/java/`: Implementação da aplicação e APIs.
  - `main/resources/`: Arquivos de configuração, como o `application.properties` para as definições de banco de dados.
  - `main/resources/storage/insomnia/`: Arquivo de testes de API do insomnia
- `pom.xml`: Arquivo de configuração do Maven, que gerencia as dependências do projeto.
- `target/`: Diretório gerado pelo Maven, contendo os artefatos do build.

## Funcionalidades

### 1. Gerenciamento de Usuários
- Listagem de usuários.
- Criação, edição e exclusão de usuários.
- Cadastro de novos usuários.

### 2. Gerenciamento de Empréstimos
- Registro de novos empréstimos.
- Edição e exclusão de empréstimos.
- Relacionamento de empréstimos com o usuário logado no sistema.

### 3. Autenticação
- Autenticação de usuários para acesso às funcionalidades protegidas.

## Instalação e Configuração

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repositorio>
   ```

2. **Configure o banco de dados:**
   - Certifique-se de ter o MySQL instalado e rodando.
   - No arquivo `src/main/resources/application.properties`, configure as credenciais de acesso ao banco de dados.
