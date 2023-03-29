# Guia para a execução do Testes
Este guia tem como objetivo fornecer informações para que você possa testar a migração de dados de um arquivo 
csv para o MySQL.

### Pré-requisitos
O seu computador deve conter os seguintes software instalados:
- __Java 17__
- __Maven 3.6.8__
- __Git__
- __Docker__
- __Docker compose__

### Configuração do Ambiente
Antes de iniciar os testes, é necessário realizar a configuração do ambiente. Feito isso, siga os passos abaixo:

Clone o repositorio do projeto em sua maquina.

 ```bash
git clone https://github.com/MateusAlves01/desafio-java.git
```
A execução do MySQL em um container docker.
 ```bash
cd desafio-java
```
 ```bash
docker-compose -f mysql-docker-compose.yml up -d
```
- O docker composer que é executado com o comando anterior vai disponilizar um banco de dados MySQL na porta __3307__ e o 
nome da data base é __movie_db__ que será utilizado pela aplicação, caso você já possua uma base de dados você precisa alterar
a url do banco no arquivo __aplication.yml do projeto__.

## Migração de arquivo csv
 ```bash
 mvn spring-boot:run
```
- Ao executar o comando acima, vai ser exibida no console uma mensagem solicitando o nome do arquivo csv,
conforme o exemplo, onde o usuario vai informar o nome do arquivo e em seguida precionar ENTER:
  * Informe o nome do arquivo CSV: test01.csv
  
## Verificar os dados migrados
- Ao realizar o comando docker compose acima foi disponibilizado uma interface grafica do PhpMyAdmim na porta __8000__
- Para a verificação dos dados migrados abra o navegador e preencha com a seguinte URL: http://localhost:8000
- Utilize o usuario root e a senha que se encontra no arquivo __application.yml__ do projeto, nessa interface você poderá fazer
a consulta dos dados migrados.
- Se preferir você pode utilizar o gerenciador do banco de dados de sua preferência utilizando a seguinte URL: localhost:3307
e direcionar para o banco: __movie_db__

## Considerações Finais
A migração de dados e filmes com arquivos csv pode ser vista neste projeto. Portanto,
este projeto tem muitas oportunidades de melhorias tais como: Criação de Endpoint para consultar filmes por genero, ano e titulo. 
Além disso, pode-se criar rotas para alterar/incluir dados dos filmes. 