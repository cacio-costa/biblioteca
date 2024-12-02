# Desafio - Sistema de Gerenciamento de Biblioteca 📚

## 🎯 Objetivo
Desenvolver um sistema de gerenciamento de biblioteca em Java, aplicando **Orientação a Objetos**.

## 📝 Requisitos Básicos

### Menu Principal
O sistema deve apresentar um menu interativo com as seguintes opções:
```
1 - Consultar acervo
2 - Emprestar livro
3 - Devolver livro
4 - Calcular multa
5 - Sair
```

## 🛠️ Funcionalidades Obrigatórias

## 📋 Modelo da Classe Livro
- String codigo
- String titulo
- String autor
- double preco
- double valorMulta
- int quantidadeExemplares

## 📚 Acervo Inicial
Para iniciar o projeto, crie um acervo com 3 livros que você gosta. Exemplo:

1. Harry Potter e a Pedra Filosofal
    - Código: "HP001"
    - Autor: "J.K. Rowling"
    - Preço: R$ 45.90
    - Valor Multa: R$ 2.00
    - Quantidade: 3 exemplares

2. Percy Jackson e o Ladrão de Raios
    - Código: "PJ001"
    - Autor: "Rick Riordan"
    - Preço: R$ 39.90
    - Valor Multa: R$ 2.00
    - Quantidade: 2 exemplares

3. O Hobbit
    - Código: "HB001"
    - Autor: "J.R.R. Tolkien"
    - Preço: R$ 55.90
    - Valor Multa: R$ 2.00
    - Quantidade: 2 exemplares

## 🛠️ Funcionalidades Obrigatórias

### 1. Consultar Acervo
- Exibir todos os livros cadastrados com:
    - Código e título do livro
    - Nome do autor
    - Preço do livro
    - Quantidade de exemplares disponíveis
- Mostrar total de livros no acervo
- Apresentar informações de forma organizada

### 2. Emprestar Livro
- Solicitar código do livro
- Verificar se o livro existe no acervo
- Verificar se há exemplares disponíveis
- Diminuir quantidade de exemplares
- Exibir mensagem com dados do empréstimo

### 3. Devolver Livro
- Solicitar código do livro
- Verificar se o livro existe no acervo
- Aumentar quantidade de exemplares
- Validar quantidade máxima de exemplares
- Exibir mensagem de confirmação

### 4. Calcular Multa
- Solicitar código do livro
- Verificar valor da multa do livro
- Receber quantidade de dias de atraso
- Calcular valor total (valorMulta × dias)
- Exibir detalhes do cálculo

## 🌟 Desafio Extra
Crie uma classe Biblioteca que:
- Possua um array de 5 posições para armazenar livros
- Inicialize com os 3 livros do acervo inicial
- Implemente um método para cadastrar até 2 novos livros
- Valide se ainda há espaço no array
    - Se não tiver espaço, altere o tamanho do array, sem perder os dados
- Não permita cadastrar livros com mesmo código
- Exiba mensagem de sucesso ou erro no cadastro
---

# 📚 Sistema de Biblioteca v2.0

## 🎯 Desafio de Implementação
Evoluir o sistema de biblioteca atual aplicando conceitos de orientação a objetos e estruturas de dados.

## 📋 Novas Classes

### Classe Emprestimo
Criar classe para registrar empréstimos com os atributos:
- Livro livro
- LocalDateTime dataEmprestimo
- boolean devolvido

### Classe Biblioteca
Criar classe para gerenciar o sistema com:
- HashMap<String, Livro> acervo
- List<Emprestimo> emprestimos

## 🛠️ Funcionalidades a Implementar

### 1. Gestão de Livros com HashMap
- Converter o acervo atual para usar HashMap<String, Livro>
- Usar o código do livro como chave do Map
- Implementar métodos para:
    - Adicionar livro
    - Buscar livro por código
    - Remover livro
    - Listar todo o acervo

### 2. Sistema de Empréstimos
- Criar registro de empréstimo com data atual
- Armazenar empréstimos em uma lista
- Implementar métodos para:
    - Registrar novo empréstimo
    - Marcar empréstimo como devolvido
    - Listar empréstimos ativos
    - Buscar empréstimo por livro

### 3. Relatórios
Adicionar novos comandos no menu:
- "6 - Listar empréstimos ativos"
- "7 - Histórico de empréstimos"

### 4. Validações
- Impedir empréstimo de livro sem exemplares disponíveis
- Validar existência do livro no acervo
- Verificar se livro já está emprestado
- Confirmar devolução apenas de livros emprestados

## ⭐️ SUPER DESAFIO: Padrão Command

Implementar o padrão Command para as operações do menu:

2. Implementar um comando para cada operação:
- ConsultarAcervoCommand
- EmprestarLivroCommand
- DevolverLivroCommand
- CalcularMultaCommand
- ListarEmprestimosCommand

Consulte o material de referência: [Command Pattern](https://refactoring.guru/pt-br/design-patterns/command)

---
Boa sorte! 🍀