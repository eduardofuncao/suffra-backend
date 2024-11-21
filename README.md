# Suffra Backend Server
API REST desenvolvida com Java Springboot para o aplicativo Suffra, 
desenvolvido como solução de gerenciamento de campanhas de concientização relacionadas com energial sustentável.
link Github: https://github.com/eduardofuncao/suffra-backend

## Equipe
- Artur Lopes Fiorindo         53481 
- Eduardo Felipe Nunes Função  553362 
- Jhoe Yoshio Kochi Hashimoto  553831

## Contextualização

## Modelagem do projeto

### Diagrama de Classes
```mermaid
classDiagram
    class Campanha {
        id_campanha : long
        nome : String
        categoria : String
        data_inicio : LocalDatetime
        data_fim : LocalDateTime
        variavel_contabilizada : String
        id_regiao_vencedora : long
        beneficio_concedido : String
    }

    class Regiao {
        id_regiao : long
        nome : String
        descricao : String
        contador : long
        campanha : Campanha
    }

    class Usuario {
        id_usuario : long
        nome : String
        cpf : String
        email : String
        telefone : String
    }

    class Voto {
        id_voto : long
        data_voto : LocalDateTime
        peso : long
        regiao : Regiao
        usuario : Usuario
    }

    Campanha --|> Regiao
    Usuario --|> Voto
    Regiao --|> Voto
```

### Diagrama Entidade Relacionamento
![suffra-der-fisico drawio](https://github.com/user-attachments/assets/84106369-ebe5-4055-bb41-9a667a2c8f58)

### Diagrama de Infraestrutura em nuvem
![ArquiteturaAzureSufradev](https://github.com/user-attachments/assets/e914f9eb-aa84-4715-be03-bf2a1fba1def)

### Fluxo HATEOAS
Será implementado o seguinte fluxo HATEOAS, incluindo o caso de uso de inclusão de voto e encerramento de campanha:
![image](https://github.com/user-attachments/assets/e4ba7923-0677-4789-8bb9-7ecf0b071fc8)
Caso um dos endpoints representados seja chamado, os link para a sequência do fluxo serão retornados na resposta.

## Testes
Para testar o projeto, pode ser utilizada a collection postman fornecida em `suffra-collection/`. Ela contém todos os endpoints que podem ser chamados pela aplicação. 
Em endpoints POST e PUT, foram incluídos exemplos de request body com atributos que passam em todas as validações.

O Swagger também foi habilitado para a aplicação, sendo acessível em `http://localhost:8080/swagger-ui/index.html`

Devido às constraints nas tabelas, é indicado a criação das entidades na seguinte ordem: 
Campanha -> Regiao -> Usuario -> Voto

## TODO
- complementar com diagramas entidade relacionamento, diagrama de infra de rede
- documentação
  - texto explicativo do projeto, contextatualizando segundo a ótica da energia sustentável
  - Um arquivo ReadMe no Github, incluindo descrição do sistema desenvolvido, com imagens,
    textos explicativos e exemplos de testes (com exemplos JSON para CRUD via Postman).
- Link do Vídeo demonstrando o software funcionando (não é o vídeo do Pitch) com áudio e
  com duração máxima de 10 minutos (YouTube ou equivalente).
- endpoints para rodar procedures db
- exceção para caso em que usuário tenta encerrar uma campanha sem regiões associadas

## DONE
- implementar endpoints para pegar total de contadores de regioes (geral e individual) OK
- implementar endpoint para encerrar campanha OK
- exceções personalizadas OK
- deploy em nuvem OK
- collection do postman OK
- fluxo hateoas OK
- diagrama de classes OK
