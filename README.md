![image](https://github.com/user-attachments/assets/80105000-b21e-4306-9881-bba26e4d187e)

# 🌐 Suffra Backend Server  
API REST desenvolvida com Java Springboot para o aplicativo Suffra, desenvolvido como solução de gerenciamento de campanhas de conscientização relacionadas com energia sustentável.  
Link GitHub: https://github.com/eduardofuncao/suffra-backend  

## 👥 Equipe  
- Artur Lopes Fiorindo         53481  
- Eduardo Felipe Nunes Função  553362  
- Jhoe Yoshio Kochi Hashimoto  553831  

## 🎥 Vídeos
- Pitch: https://www.youtube.com/watch?v=3iFR-YL9nfE
- Funcionamento: https://youtu.be/f99T9J_rPqI

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

## 🚀 Instruções para operacionalização da infra e build do código:

### 1. Configuração do Grupo de Recursos no Azure

Crie o grupo de recursos:
```bash
az group create --name rg-sufradev-prd --location eastus
```

### 2. Criação das VMs:
VM Backend (Linux):
```bash
az vm create \
  --resource-group rg-sufradev-prd \
  --name vm-sufradev-linux-back-prd \
  --image UbuntuLTS \
  --size Standard_DS2_v2 \
  --admin-username admsufra \
  --admin-password sufra123@2024 \
  --authentication-type password \
  --storage-sku Standard_LRS \
  --os-disk-size-gb 30 \
  --custom-data cloud-init.txt \
  --public-ip-sku Standard \
  --tags Environment=Production
```

VM Frontend (Windows Server):
```bash
az vm create \
  --resource-group rg-sufradev-prd \
  --name vm-sufradev-windowsserver-front-prd \
  --image MicrosoftWindowsServer:windows-server:2022-datacenter-azure-edition:latest \
  --size Standard_D2s_v5 \
  --admin-username adm-sufra \
  --admin-password sufra123@2024 \
  --public-ip-sku Standard \
  --os-disk-size-gb 128 \
  --authentication-type password
```

### 3. Configuração de Portas
```bash
az vm open-port --port 80-100 --resource-group rg-sufradev-prd --name vm-sufradev-windowsserver-front-prd
az vm open-port --port 8080 --resource-group rg-sufradev-prd --name vm-sufradev-linux-back-prd
az vm open-port --port 22 --resource-group rg-sufradev-prd --name vm-sufradev-linux-back-prd
az vm open-port --port 443 --resource-group rg-sufradev-prd --name vm-sufradev-linux-back-prd
```


### 4. 🛠 Configuração do Backend (Linux)
Java 17:
```bash
sudo apt update && sudo apt install openjdk-17-jdk -y
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 export PATH=$JAVA_HOME/bin:$PATH
java -version
```

Gradle:
```bash
sudo apt install gradle
gradle wrapper
chmod +x ./gradlew
./gradlew wrapper --gradle-version 8.0
./gradlew clean build
```

### 5. Clonar o Projeto
```bash
cd /home/admsufra
git clone https://github.com/eduardofuncao/suffra-backend.git
cd suffra-backend
```


### 6. Build e Execução:
```bash
cd /home/admsufra/sufrajava/suffra-backend
 ./gradlew clean build
./gradlew bootRun

cd /home/admsufra/sufrajava/suffra-backend/build/libs
java -jar build/libs/suffra-0.0.1-SNAPSHOT.jar
```

```bash
ssh admsufra@191.233.254.131
sufra123@2024
```

---
