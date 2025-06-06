#  Estoque - Microservice and Web Engineering Project

## Integrantes
- Bruno Henrique - RM: 87740
- Felipe Otto da Silva - RM: 89108
- João Henrique - RM: 86913
- Pedro Argentati - RM: 88246
- Rafael Tannous - RM: 87486

## Matéria e Professor
- Matéria: Microservice and Web Engineering
- Professor: José Romualdo da Costa Filho

## Tecnologias Utilizadas
O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java 17**: Versão da linguagem de programação Java utilizada no projeto.
- **Spring Boot 2.7.17**: Versão do Spring Boot utilizada no projeto.

## Dependências
O projeto utiliza as seguintes dependências, conforme especificadas no arquivo `pom.xml`:

- **Spring Data JPA**: Biblioteca que simplifica o acesso a dados com o Spring.
- **Spring JDBC**: Suporte para acesso a dados relacionais com o Spring.
- **Spring Validation**: Biblioteca para validação de dados em aplicações Spring.
- **Spring Web**: Suporte para desenvolvimento de aplicações web com o Spring.
- **Spring Devtools**: Ferramentas de desenvolvimento para o Spring (runtime).
- **Oracle JDBC (ojdbc8)**: Driver JDBC para conexão com o banco de dados Oracle.
- **Project Lombok**: Biblioteca que simplifica a criação de classes Java com menos código boilerplate.
- **Tomcat**: Servidor web embutido do Spring Boot.
- **Spring Boot Test**: Biblioteca de testes para aplicações Spring Boot.
- **Springdoc OpenAPI UI**: Biblioteca para geração de documentação OpenAPI e UI.

## Funcionalidades da API

- **/v1/estoque/verificaespaco**: Retorna o número de espaços disponíveis no estoque para a largura, altura e profundidade informada. Retornará 0 caso não tenha nenhuma.
- **/v1/estoque/movimentar**: Realiza a retirada ou inclusão no estoque.
- **/v1/estoque/verificaespaco/{codBarras}**: A partir de um código de barras informado via URL, o endpoint fará uma verificação no banco de dados para ver se já tem um produto cadastrado com o código informado.
- **/v1/estoque/**: Lista todos os produtos do estoque.

## Link da Aplicação
https://estoquefiap.azurewebsites.net/swagger-ui/index.html#/
