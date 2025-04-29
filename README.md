# 📄 Português-BR

# Airbnb Searcher

Este repositório demonstra como integrar o MongoDB Atlas Search utilizando o Kotlin Sync Driver em uma aplicação Spring Boot REST. A proposta é criar uma solução de busca para explorar propriedades no estilo do Airbnb, aproveitando os recursos avançados de pesquisa textual do MongoDB Atlas (além do dataset de amostra disponibilizado).

## 🔎 Sobre o Atlas Search

O Atlas Search permite realizar pesquisas sofisticadas em documentos do MongoDB usando a infraestrutura de indexação do Lucene. Com ele, você pode criar índices personalizados, utilizar buscas de texto com fuzziness (tolerância a erros de digitação) e fazer consultas mais relevantes e performáticas.

Para utilizar o Atlas Search, é necessário criar um **índice de busca** no cluster MongoDB. Um índice define os campos pesquisáveis e o comportamento da busca (por exemplo, quais campos usar para buscas textuais).

Saiba mais na documentação oficial: [MongoDB Atlas Search](https://www.mongodb.com/docs/atlas/atlas-search/).

## 🎯 Demonstração
![Demonstração](./demonstration/demonstration.gif)

## ✅ Pré-requisitos

- Conta no [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) (gratuita)
- Java 21 ou superior ([Baixar](https://www.oracle.com/java/technologies/javase-downloads.html))
- Gradle 8.8 ou superior ([Baixar](https://gradle.org/install/))
- IDE Java de sua preferência (como [IntelliJ IDEA](https://www.jetbrains.com/idea/), [Eclipse](https://www.eclipse.org/), ou [Visual Studio Code](https://code.visualstudio.com/))

## 🚀 Como Começar

1. **Clone o projeto**

   ```bash
   git clone https://github.com/mongodb-developer/kotlin-driver-atlas-search.git
   cd kotlin-driver-atlas-search
   ```

2. **Construa o projeto**

   ```bash
   ./gradlew build
   ```

3. **Execute a aplicação**

   ```bash
   ./gradlew bootRun
   ```

4. **Acesse o endpoint de busca**

   Com a aplicação em execução, acesse:

   ```
   http://localhost:8080/airbnb/search
   ```

   **Parâmetros:**
   - `query`: Texto para busca full-text com correção de erros.
   - `minNumberReviews`: Número mínimo de avaliações que o anúncio deve possuir.

   Exemplo de chamada:

   ```bash
   curl --location 'http://localhost:8080/airbnb/search?query=Istambun&minNumberReviews=50'
   ```

---
# 📄 English

# Airbnb Searcher

This repository showcases how to integrate MongoDB Atlas Search using the Kotlin Sync Driver within a Spring Boot REST application. The project simulates a property search experience similar to Airbnb, utilizing the powerful full-text search capabilities of MongoDB Atlas (in addition to the sample dataset provided).

## 🔎 About Atlas Search

Atlas Search brings advanced search capabilities to MongoDB, powered by Apache Lucene's indexing technology. It allows you to define custom search indexes, perform fuzzy text searches, and run highly efficient and relevant queries.

To use Atlas Search, you first need to create a **search index** in your MongoDB Atlas cluster. The index specifies which fields are searchable and how queries should behave (e.g., text search, autocomplete, relevance boosting).

Learn more in the official documentation: [MongoDB Atlas Search](https://www.mongodb.com/docs/atlas/atlas-search/).

## 🎯 Demonstration
![Demonstration](./demonstration/demonstration.gif)

## ✅ Prerequisites

- A [MongoDB Atlas](https://www.mongodb.com/cloud/atlas) account (free tier available)
- Java 21 or newer ([Download](https://www.oracle.com/java/technologies/javase-downloads.html))
- Gradle 8.8 or newer ([Download](https://gradle.org/install/))
- A Java IDE of your choice (e.g., [IntelliJ IDEA](https://www.jetbrains.com/idea/), [Eclipse](https://www.eclipse.org/), or [Visual Studio Code](https://code.visualstudio.com/))

## 🚀 Getting Started

1. **Clone the repository**

   ```bash
   git clone https://github.com/mongodb-developer/kotlin-driver-atlas-search.git
   cd kotlin-driver-atlas-search
   ```

2. **Build the project**

   ```bash
   ./gradlew build
   ```

3. **Run the application**

   ```bash
   ./gradlew bootRun
   ```

4. **Access the search endpoint**

   Once running, the application exposes:

   ```
   http://localhost:8080/airbnb/search
   ```

   **Parameters:**
   - `query`: Text to perform a fuzzy full-text search.
   - `minNumberReviews`: Minimum number of reviews for the Airbnb listing to be included.

   Example request:

   ```bash
   curl --location 'http://localhost:8080/airbnb/search?query=Istambun&minNumberReviews=50'
   ```
