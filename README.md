![image](https://github.com/user-attachments/assets/80105000-b21e-4306-9881-bba26e4d187e)

# 🌐 Suffra Backend Server  
API REST desenvolvida com Java Springboot para o aplicativo Suffra, desenvolvido como solução de gerenciamento de campanhas de conscientização relacionadas com energia sustentável.  
Link GitHub: https://github.com/eduardofuncao/suffra-backend  

## 👥 Equipe  
- Artur Lopes Fiorindo         53481  
- Eduardo Felipe Nunes Função  553362  
- Jhoe Yoshio Kochi Hashimoto  553831  

## 📖 Contextualização  
**Suffra** é um projeto que implementa uma competição gamificada para introdução de campanhas de conscientização para a população.  

### 📊 Compreendendo as entidades do sistema  
De forma genérica, para cada **campanha**, os **usuários** contribuirão por meio de **votos** para alguma **região**. Ao final do período de campanha, a região com maior quantidade de votos será determinada a vencedora, sendo contemplada com algum benefício.  

> REGIÃO  -> Torres de um condomínio  
> VOTO    -> Entradas de gastos energéticos por Torre  
> USUÁRIO -> Morador do condomínio  

### ⚡ Como será utilizado nessa Entrega
Especificamente, a proposta apresentada será uma campanha de conscientização sobre redução no consumo energético de torres de um condomínio residencial.  



Ao final do período da campanha, a torre com menores gastos energéticos será a vencedora, garantindo aos seus moradores um desconto na conta de condomínio.  

### 🚀 Extensões futuras  
Como o sistema foi idealizado para ser utilizado em outras categorias que não o consumo energético, seria possível adaptá-lo para campanhas como:  
- 💧 Redução do consumo de água  
- ♻️ Incentivo à reciclagem de lixo  
- 🤝 Doações para causas sociais relacionadas à energia sustentável  

---

## 🛠️ Modelagem do projeto  

### 📐 Diagrama de Classes  
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

### 🔗 Diagrama Entidade Relacionamento  
![suffra-der-fisico drawio](https://github.com/user-attachments/assets/84106369-ebe5-4055-bb41-9a667a2c8f58)  

### ☁️ Diagrama de Infraestrutura em nuvem  
![ArquiteturaAzureSufradev](https://github.com/user-attachments/assets/e914f9eb-aa84-4715-be03-bf2a1fba1def)  

### 🔄 Fluxo HATEOAS  
Será implementado o seguinte fluxo HATEOAS, incluindo o caso de uso de inclusão de voto e encerramento de campanha:  
![image](https://github.com/user-attachments/assets/e4ba7923-0677-4789-8bb9-7ecf0b071fc8)  

Caso um dos endpoints representados seja chamado, os links para a sequência do fluxo serão retornados na resposta.  

---

## 🧪 Testes  
Para testar o projeto, pode ser utilizada a **collection Postman** fornecida em `suffra-collection/`.  
- Inclui todos os endpoints disponíveis, com exemplos de request body.  
- O Swagger pode ser acessado em: `http://localhost:8080/swagger-ui/index.html`.  

**Ordem sugerida para criação das entidades no banco de dados**:  
Campanha → Região → Usuário → Voto  

---

## ✅ TODO  
- 🎥 Link para vídeo demonstrativo (máximo de 10 minutos)
- Informações do deploy em nuvem
- 🛠️ Implementar endpoints para rodar procedures no banco de dados  
- ⚠️ Exceções para campanhas sem regiões associadas  

---

## 🎉 DONE  
- Endpoints para total de contadores por região ✅  
- Endpoint para encerrar campanha ✅  
- Exceções personalizadas ✅  
- Deploy em nuvem ✅  
- Collection do Postman ✅  
- Fluxo HATEOAS ✅  
- Diagramas (classes, entidade-relacionamento, infraestrutura) ✅
- 📚 Documentação ✅

