# Desafio - Sistema de Gerenciamento de Biblioteca 📚

## 🎯 Objetivo
Desenvolver um sistema de gerenciamento de biblioteca em Java, aplicando conceitos fundamentais de programação.

## 📝 Requisitos Básicos

### Variáveis Iniciais
O sistema deve iniciar com as seguintes informações:
```java
String bibliotecario = "Nome do Bibliotecário";
int livrosDisponiveis = 150;
int livrosEmprestados = 0;
double multaPorDia = 2.50;
```

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

### 1. Consultar Acervo
- Exibir quantidade atual de livros disponíveis
- Exibir quantidade de livros emprestados
- Apresentar informações de forma organizada

### 2. Emprestar Livro
- Diminuir quantidade de livros disponíveis
- Aumentar contador de livros emprestados
- Validar se existem livros disponíveis para empréstimo
- Exibir mensagem de sucesso ou erro

### 3. Devolver Livro
- Aumentar quantidade de livros disponíveis
- Diminuir contador de livros emprestados
- Validar se existem livros para serem devolvidos
- Exibir mensagem de sucesso ou erro

### 4. Calcular Multa
- Receber quantidade de dias de atraso
- Calcular valor da multa (dias × multaPorDia)
- Exibir valor total da multa
- Validar entrada de dados

## 💻 Requisitos Técnicos
- Utilizar Scanner para entrada de dados
- Implementar loop com while para o menu
- Utilizar if/else para validações
- Incluir mensagens claras para o usuário
- Validar todas as entradas de dados

## 🌟 Desafio Bônus
Implementar uma ou mais funcionalidades extras:

### Sistema de Cadastro de Livros
- Título
- Autor
- Ano de publicação
- Categoria

### Sistema de Busca
- Busca por título
- Busca por categoria
- Busca por autor

### Sistema de Relatórios
- Ranking de livros mais emprestados
- Total de multas acumuladas
- Estatísticas por categoria

---
Boa sorte! 🍀
