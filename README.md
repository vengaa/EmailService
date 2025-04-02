
# Microservice de Envio de E-mails

Este repositório contém uma API desenvolvida com Spring Boot que oferece funcionalidades para envio de e-mails em formatos de texto simples e HTML, com suporte a anexos. A API também inclui endpoints para realizar testes de integridade do serviço.

## Funcionalidades

- Envio de e-mails de texto simples.
- Envio de e-mails em formato HTML com templates.
- Envio de e-mails HTML com arquivos anexados.
- Teste de integridade da API com requisições GET e POST.

## Tecnologias

- **Spring Boot** - Framework para construção de APIs RESTful.
- **JavaMailSender** - Para envio de e-mails.
- **Swagger** - Para documentação da API.
- **Maven** - Gerenciador de dependências e construção do projeto.
- **Docker** - Para containerização da aplicação.
- **ModelMapper** - Para conversão entre objetos (DTOs e Entidades).

## Endpoints

### 1. Enviar E-mail de Texto
Envie um e-mail simples em formato de texto.

- **URL:** `/api/emails/send-text`
- **Método:** `POST`
- **Parâmetros:**
  - `recipient`: E-mail do destinatário.
  - `subject`: Assunto do e-mail.
  - `message`: Conteúdo do e-mail.

- **Exemplo de Requisição:**

  ```http
  POST /api/emails/send-text?recipient=exemplo@dominio.com&subject=Assunto&message=Olá,%20mundo!
  ```

- **Respostas:**
  - **200 OK:** E-mail enviado com sucesso.
  - **400 Bad Request:** Erro na requisição.

### 2. Enviar E-mail HTML
Envie um e-mail em formato HTML utilizando um template.

- **URL:** `/api/emails/send-html`
- **Método:** `POST`
- **Parâmetros:**
  - `recipient`: E-mail do destinatário.
  - `subject`: Assunto do e-mail.
  - `message`: Conteúdo da mensagem em HTML.

- **Exemplo de Requisição:**

  ```http
  POST /api/emails/send-html?recipient=exemplo@dominio.com&subject=Teste%20HTML&message=Esta%20é%20uma%20mensagem%20de%20teste
  ```

- **Respostas:**
  - **200 OK:** E-mail HTML enviado com sucesso.
  - **400 Bad Request:** Erro na requisição.

### 3. Enviar E-mail HTML com Anexos
Envie um e-mail HTML com arquivos anexados.

- **URL:** `/api/emails/send-html-attachments`
- **Método:** `POST`
- **Parâmetros:**
  - `recipient`: E-mail do destinatário.
  - `subject`: Assunto do e-mail.
  - `messageContent`: Conteúdo da mensagem em HTML.
  - `files`: Arquivos a serem anexados.

- **Exemplo de Requisição:**

  ```http
  POST /api/emails/send-html-attachments?recipient=exemplo@dominio.com&subject=Teste%20HTML&messageContent=Esta%20é%20uma%20mensagem%20de%20teste&files=@file1,@file2
  ```

- **Respostas:**
  - **200 OK:** E-mail HTML com anexos enviado com sucesso.
  - **400 Bad Request:** Erro na requisição.

### 4. Teste de Integridade da API (GET)
Verifica se a API está funcionando corretamente.

- **URL:** `/api/test/getstatusapp`
- **Método:** `GET`

- **Resposta:**

  ```json
  {
    "status": "up"
  }
  ```

### 5. Teste de Integridade da API (POST)
Verifica se a API está funcionando corretamente com uma requisição POST.

- **URL:** `/api/test/poststatusapp`
- **Método:** `POST`

- **Resposta:**

  ```json
  {
    "status": "up"
  }
  ```

## Configuração

### Configurações do E-mail
No arquivo `application.properties`, você precisa configurar as credenciais do e-mail e o servidor SMTP:

```properties
spring.mail.host=${smtp_host}
spring.mail.port=${smtp_port}
spring.mail.username=${smtp_username}
spring.mail.password=${smtp_password}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Docker
Este projeto inclui um `Dockerfile` para facilitar a construção e o deployment do serviço em containers Docker.

Para construir a imagem Docker, use o seguinte comando:

```bash
docker build -t email-service .
```

E para rodar a aplicação em um container:

```bash
docker run -p 8080:8080 email-service
```

A aplicação estará disponível na porta `8080`.

## Como Rodar Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/vengaa/Microservice-sendEmail.git
   cd Microservice-sendEmail
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Execute o aplicativo:
   ```bash
   mvn spring-boot:run
   ```

4. A API estará rodando em `http://localhost:8080`.

## Swagger

A documentação da API está disponível em Swagger, acessível através de `http://localhost:8080/swagger-ui.html`.

## Contribuições

Contribuições são bem-vindas! Se você deseja adicionar novas funcionalidades ou corrigir problemas, por favor, faça um fork do repositório, crie uma nova branch e envie um pull request.

## Licença

Distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
