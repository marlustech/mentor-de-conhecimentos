<div align="center">

# 🤖 Mentor de Conhecimentos
### *AI-Powered Software Architecture & Engineering Mentor*

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 25" />
  <img src="https://img.shields.io/badge/Spring_Boot-4.1.2-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/Spring_AI-2.0.1-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring AI" />
  <img src="https://img.shields.io/badge/Google_Gemini-Flash_2.5-4285F4?style=for-the-badge&logo=google&logoColor=white" alt="Google Gemini" />
  <img src="https://img.shields.io/badge/Three.js-3D_Viewport-black?style=for-the-badge&logo=three.js&logoColor=white" alt="Three.js" />
</p>

<p align="center">
  Aplicação full-stack inteligente com retenção de contexto via <b>ChatMemory</b>, integrada à LLM do Google e envolvida por uma interface interativa <b>Glassmorphism 3D</b>.
</p>

[Visão Geral](#-visão-geral) •
[Tecnologias](#-stack-tecnológica) •
[Arquitetura](#-arquitetura--fluxo-de-dados) •
[Pré-requisitos](#-pré-requisitos) •
[Instalação](#-instalação-e-configuração) •
[Execução](#-como-executar) •
[Estrutura](#-estrutura-de-diretórios) •
[Subir no GitHub](#-como-subir-no-github-passo-a-passo)

---

</div>

## 📌 Visão Geral

O **Mentor de Conhecimentos** foi desenvolvido para acelerar a aprendizagem em arquitetura de microsserviços, boas práticas e desenvolvimento de software moderno com Java. Através de um *System Prompt* rigorosamente configurado, o agente assume a postura de um Arquiteto de Software Sénior, eliminando saudações desnecessárias e fornecendo respostas técnicas estruturadas com exemplos práticos de código.

### ✨ Destaques
- **Memória de Conversação Ativa:** Utilização do `MessageChatMemoryAdvisor` com `ChatMemory` injetado pelo Spring, associando as mensagens ao identificador da sessão (`chat_memory_conversation_id`).
- **Engine Gráfica em Background:** Cenário 3D interativo com grelha neon de perspetiva e partículas em órbita geradas com **Three.js** e resposta suave ao rato.
- **Renderização Sintática:** Suporte a realce de código Markdown para blocos Java, XML, JSON e YAML.

---

## 🛠 Stack Tecnológica

| Camada | Tecnologia | Função Principal |
| :--- | :--- | :--- |
| **Linguagem** | `Java 25` | Plataforma moderna de execução e sintaxe atualizada |
| **Framework Base** | `Spring Boot 4.1.2` | Injeção de dependências, Spring MVC e Tomcat 11 embutido |
| **Integração de IA** | `Spring AI 2.0.1` | Módulo `spring-ai-starter-model-google-genai` |
| **Modelo LLM** | `Google Gemini 2.5 Flash` | Modelo de linguagem para inferência e raciocínio técnico |
| **Memória de Chat** | `ChatMemory (In-Memory)` | Repositório em memória para reter o histórico da sessão |
| **Interface 3D** | `Three.js` | Renderização espacial via WebGL no plano de fundo |
| **Estilização** | `CSS3 Glassmorphism` | Efeito acrílico fosco (`backdrop-filter`) com acentos neon |

---

## 🧠 Arquitetura & Fluxo de Dados

```text
[Cliente / Navegador Web]
         │ (POST /api/mentor/perguntar)
         ▼
 ┌─────────────────────────────────────────────────────────┐
 │                   MentorController                      │
 └──────────────────────────┬──────────────────────────────┘
                            ▼
 ┌─────────────────────────────────────────────────────────┐
 │                  MentorAgentService                     │
 │  ┌───────────────────────────────────────────────────┐  │
 │  │        Advisor Chain: MessageChatMemory           │  │
 │  │ (Injeta histórico da sessão no prompt ativo)      │  │
 │  └───────────────────────────────────────────────────┘  │
 └──────────────────────────┬──────────────────────────────┘
                            ▼
 ┌─────────────────────────────────────────────────────────┐
 │            Google Gemini (GenAI Service API)            │
 │               Modelo: gemini-2.5-flash                  │
 └──────────────────────────┬──────────────────────────────┘
                            ▼
        [Resposta técnica entregue à UI com Markdown]


📋 Pré-requisitos •
⚙️ Instalação •
▶️ Execução •
📂 Estrutura •
📄 Licença📋 Pré-requisitos:
Antes de iniciar, certifique-se de que o seu ambiente possua as seguintes ferramentas instaladas e configuradas:FerramentaVersão MínimaFinalidadeJDK25+Compilação e execução da aplicação moderna com JavaApache Maven3.9+Gerenciamento de dependências e automação de buildGoogle AI Studio API Keygemini-2.5-flashCredencial de acesso para inferência dos modelos de IA[!TIP]
Você pode obter uma chave de API gratuitamente em: Google AI Studio.⚙️ Instalação e Configuração1. Clonar o Repositóriogit clone https://github.com/marlustech/mentor-de-conhecimentos.git
cd mentor-de-conhecimentos
2. Configurar a Chave da API (Segurança)[!CAUTION]
Nunca comite chaves de API literais. Mantenha suas credenciais isoladas em variáveis de ambiente para evitar bloqueios do GitHub Push Protection ou exposição indevida.No Windows (PowerShell):$env:GEMINI_API_KEY="AIzaSySUA_CHAVE_AQUI"
No Linux / macOS:export GEMINI_API_KEY="AIzaSySUA_CHAVE_AQUI"
No arquivo local (src/main/resources/application.yml):server:
  port: 8080

spring:
  ai:
    google:
      genai:
        api-key: ${GEMINI_API_KEY}
        chat:
          options:
            model: gemini-2.5-flash
▶️ Como ExecutarOpção 1: Via Linha de Comando (Maven)mvn clean spring-boot:run
Opção 2: Pelo IntelliJ IDEAAbra o IntelliJ IDEA e carregue o projeto a partir do arquivo pom.xml.Aguarde a sincronização das dependências no painel lateral do Maven.Configure a variável de ambiente na execução:Abra o menu superior: Run > Edit Configurations...No campo Environment variables, insira: GEMINI_API_KEY=sua_chave_aquiLocalize a classe principal em src/main/java/com/mentor/agente/AgenteApplication.java.Clique com o botão direito e selecione Run 'AgenteApplication' (ou pressione Shift + F10).[!NOTE]
Quando o servidor Tomcat inicializar na porta 8080, acesse a aplicação em seu navegador:🔗 http://localhost:8080📂 Estrutura de Diretóriosmentor-de-conhecimentos/
├── src/
│   ├── main/
│   │   ├── java/com/mentor/agente/
│   │   │   ├── controller/
│   │   │   │   └── MentorController.java       # Endpoint REST (/api/mentor/perguntar)
│   │   │   ├── service/
│   │   │   │   └── MentorAgentService.java     # ChatClient configurado com ChatMemory
│   │   │   └── AgenteApplication.java          # Ponto de partida do Spring Boot
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html                  # Interface Glassmorphism 3D (Three.js)
│   │       └── application.yml                 # Mapeamento do Spring AI e Gemini
│   └── test/                                   # Testes unitários e de integração
├── .gitignore                                  # Regras de exclusão do Git
├── pom.xml                                     # Dependências Maven (Spring Boot e Gemini)
└── README.md                                   # Documentação técnica do projeto

📄 LicençaDistribuído sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.
