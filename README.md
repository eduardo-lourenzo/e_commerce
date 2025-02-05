# E-Commerce
Sistema básico de E-Commerce que permita o cadastro de produtos, clientes e a realização de compras.

## Endpoints da API - Clientes

Abaixo estão os endpoints disponíveis para gerenciar clientes na API REST do e-commerce.

### **Clientes**

| Método | Endpoint         | Descrição                     | Parâmetros                                                                 |
|--------|------------------|-------------------------------|----------------------------------------------------------------------------|
| POST   | `/clientes`      | Cria um novo cliente          | Corpo da requisição: JSON com os detalhes do cliente                       |
| GET    | `/clientes/{cpf}`| Retorna um cliente pelo CPF   | `cpf` (obrigatório): CPF válido do cliente                                 |
| PUT    | `/clientes/{cpf}`| Atualiza um cliente pelo CPF  | `cpf` (obrigatório): CPF válido do cliente<br>Corpo da requisição: JSON atualizado |

### Observações

- O CPF deve ser válido e seguir o formato brasileiro (ex.: `12345678909`).
- O endpoint de criação e atualização exige um corpo de requisição no formato JSON com os campos obrigatórios.

#### Exemplo de JSON para criação de um cliente
```json
{
   "cpf": "59497790457",
   "name": "Fulano da Silva",
   "email": "fs@gmail.com"
}
```

```json
{
"cpf": "87948624600",
"name": "Beltrano de Sousa",
"email": "bs@gmail.com"
}
```
        
```json
{
   "cpf": "64054387080",
   "name": "Sicrano Rodrigues",
   "email": "sr@gmail.com"
}
```

## Endpoints da API - Produtos

Abaixo estão os endpoints disponíveis para gerenciar produtos na API REST do e-commerce.

### **Produtos**

| Método | Endpoint           | Descrição                  | Parâmetros                                           |
|--------|--------------------|----------------------------|------------------------------------------------------|
| POST   | `/produtos`        | Cria um novo produto       | Corpo da requisição: JSON com os detalhes do produto |
| GET    | `/produtos`        | Retorna todos os produtos  | Nenhum                                               |
| DELETE | `/produtos/{nome}` | Remove um produto pelo nome | `nome` (obrigatório): Nome do produto a ser removido |

#### Exemplo de JSON para criação de um produto

```json
{
    "name": "Pera",
    "price": "12.49",
    "quantity": 36
}
```

```json
{
"name": "Uva",
"price": 25.99,
"quantity": 40
}
```

```json
{
    "name": "Maçã",
    "price": 14.99,
    "quantity": 60
}
```

## Endpoints da API - Compras

Abaixo está o endpoint disponível para gerenciar compras na API REST do e-commerce.

### **Compras**

| Método | Endpoint   | Descrição                     | Parâmetros                                                                 |
|--------|------------|-------------------------------|----------------------------------------------------------------------------|
| PUT    | `/compras` | Atualiza os dados de uma compra | Corpo da requisição: JSON com os detalhes da compra a ser atualizada       |

#### Exemplo de JSON para criação de um compra

```json
{
  "cpf": "59497790457",
  "produtos": [
    { "nome": "Uva" },
    { "nome": "Maçã" }
  ]
}
```

### Observações e anotações:

PUT /clientes/{cpf}
O cliente tem Id que será mantido ao atualizar o cliente.
O CPF da url será considerado um dado antigo.
E o CPF do body será considerado um dado novo.
Considerando que o cliente possa corrigir/alterar o CPF. 

O produto não tem um método de atualizar os produtos.
E como o Id do banco de dados é o próprio nome do produto.
Isso gera uma sobrescrita do produto passado um Id existente.
Sobrescreve id(nome) repetido por faltar o método update.

A classe utilitária CPFValidator foi substituída pela anotação ```@CPF``` do Hibernate Validator.
