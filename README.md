# notifications-reative-webflux
Criado apis que usam o Webflux para receber e enviar 
- notificações reativas (Spring Weflux)
- controle de usuarios
- controle de JOB de execução do Envio

## Tecnologias Utilizadas
Este projeto foi desenvolvido com as seguintes tecnologias:

- Spring Webflux: Usado para criar um back-end reativo e não-bloqueante.
- MongoDB: Banco de dados NoSQL utilizado para armazenar os dados de forma eficiente e escalável.
- Dockerfile
- docker-compose.yml

Iniciando
Estas instruções fornecerão uma cópia do projeto em execução na sua máquina local para fins de desenvolvimento e testes.

## Pré-requisitos
Antes de começar, verifique se você possui os seguintes requisitos:
- Docker
- Docker Compose
- Instale o MongoDB
- Java na sua máquina. 

Veja instruções detalhadas no site oficial de 
- [MongoDB](https://docs.mongodb.com/manual/installation/)
- [Java](https://www.java.com/en/download/help/download_options.html)

## Clone o repositório para sua máquina local:
bash
git clone https://github.com/fahpsouza/notifications-reative-webflux.git
cd notifications-reative-webflux

##Construa o projeto com Maven:
bash
mvn clean install

##Execute o projeto:
bash
java -jar target/notifications-reative-webflux-0.0.1-SNAPSHOT.jar
O 
servidor iniciará na porta definida nas configurações.

Uso
Exemplos de como você pode utilizar as APIs criadas. Por exemplo:

http
## Para Testar importe a Collection do Json em seu Postman na razi do projeto
- [Notifications Webflux.postman_collection.json](https://github.com/fahpsouza/notifications-reative-webflux/blob/master/Notifications%20Webflux.postman_collection.json)

Contato
Fabio Henrique Piedade de Souza 
– Linkedin = https://www.linkedin.com/in/fabio-h-p-de-souza/ 
– Email = fabio.henrique.psouza@gmail.com

Link do Projeto: https://github.com/fahpsouza/notifications-reative-webflux