# Desafio Prático Java ☕

[![Java Version](https://img.shields.io/badge/Java-11%2B-blue.svg)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![Maven Build](https://img.shields.io/badge/Build-Maven-brightgreen.svg)](https://maven.apache.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Este é um projeto de teste prático desenvolvido em Java, com o objetivo de demonstrar a implementação de um sistema de folha de pagamento.

## 📝 Descrição

O projeto simula o cálculo da folha de pagamento de uma empresa. Ele inclui diferentes tipos de funcionários (Secretário, Vendedor, Gerente), cada um com regras específicas para cálculo de salário, benefícios e bônus.

## ✨ Funcionalidades

- Cálculo de salário e benefícios para Secretários.
- Cálculo de salário, benefícios e comissões para Vendedores.
- Cálculo de salário e benefícios para Gerentes.
- Cálculo do valor total da folha de pagamento, incluindo salários e benefícios.
- Cálculo do valor total pago em salários (sem benefícios).
- Cálculo do valor total pago em benefícios.
- Identificação do funcionário com maior remuneração em um determinado mês.
- Identificação do funcionário com maior valor em benefícios em um determinado mês.

## 🛠️ Tecnologias Utilizadas

- **Java:** Linguagem de programação principal.
- **Maven:** Ferramenta de automação de compilação e gerenciamento de dependências.
- **JUnit 5:** Framework para testes unitários.

## 🚀 Como Rodar o Projeto

1.  **Pré-requisitos:**

    - Java JDK 11 ou superior instalado.
    - Maven instalado.

2.  **Clone o repositório:**
    ```bash
    git clone https://github.com/Thiagonox/desafio-java.git
    ```
3.  **Navegue até o diretório do projeto:**
    ```bash
    cd desafio-java
    ```
4.  **Compile o projeto:**
    ```bash
    mvn compile
    ```
5.  **Execute a classe principal:**
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.Main"
    ```
    Isso executará o método `main` na classe `com.example.Main`, que demonstra as funcionalidades do sistema.

## ✅ Como Rodar os Testes

Para executar os testes unitários, utilize o seguinte comando Maven:

```bash
mvn test
```