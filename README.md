<h1 align="center">🌸 Sistema de Controle de Pedidos 🌸</h1>

<p align="center">
  Projeto de estudo que conecta <b>Java</b> ao <b>PostgreSQL</b> usando <b>JDBC</b> 💖<br>
  Clientes, produtos, pedidos e itens, tudo conversando com o banco de dados ✨
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-FF85B3?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/PostgreSQL-B39DDB?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
  <img src="https://img.shields.io/badge/JDBC-F48FB1?style=for-the-badge" alt="JDBC">
  <img src="https://img.shields.io/badge/Git-CE93D8?style=for-the-badge&logo=git&logoColor=white" alt="Git">
  <img src="https://img.shields.io/badge/Status-em%20construção-FFB6C1?style=for-the-badge" alt="Status">
</p>

---

## 🎀 Sobre o projeto

Este projeto simula o controle de pedidos de uma loja. Ele nasceu enquanto eu estudo Java e banco de dados, e vai crescendo a cada etapa do meu aprendizado 🌷

## 🧁 Tecnologias

- ☕ Java
- 🐘 PostgreSQL 18
- 🔌 JDBC (driver `postgresql-42.7.14`)
- 💻 Eclipse (Spring Tools)
- 🐙 Git e GitHub

## 🗄️ Banco de dados

O banco `sistema_pedidos` possui 4 tabelas:

| Tabela | Descrição |
|--------|-----------|
| 👩 `cliente` | Nome e e-mail único dos clientes |
| 🛍️ `produto` | Nome e preço dos produtos |
| 🧾 `pedido` | Pedidos realizados, ligados a um cliente |
| 📦 `item_pedido` | Produtos de cada pedido, com a quantidade |

Os scripts ficam na pasta `database/`:

- `schema.sql`: criação das tabelas
- `dados_teste.sql`: dados de exemplo e consulta com `JOIN` de 4 tabelas

## 📁 Estrutura do projeto

```
src/
├── app/    -> classe principal (Programa)
├── dao/    -> acesso ao banco (ClienteDAO)
├── db/     -> conexão com o banco (ConexaoBanco)
└── model/  -> Cliente, Produto, Pedido e ItemPedido
database/   -> scripts SQL
```

## 🚀 Como executar

1. Instale o Java e o PostgreSQL.
2. Crie o banco `sistema_pedidos` e execute `database/schema.sql` (e, se quiser, `database/dados_teste.sql`).
3. Baixe o driver JDBC em https://jdbc.postgresql.org/download/ e adicione o `.jar` ao Build Path.
4. Crie, na raiz do projeto, o arquivo `db.properties` (ele não vai pro GitHub, pois guarda a senha 🔒):

```
url=jdbc:postgresql://localhost:5432/sistema_pedidos
usuario=postgres
senha=SUA_SENHA
```

5. Execute a classe `app.Programa`. Ela lista os clientes cadastrados no console 🎉

## 🌱 Próximos passos

-  [x] CRUD de clientes com ClienteDAO
- [ ] Cadastro de pedidos com itens
- [ ] Migração para Spring Boot e JPA

## 👩‍💻 Autora

**Larissa Gobbo** 💕
GitHub: [@larissagobbo](https://github.com/larissagobbo)