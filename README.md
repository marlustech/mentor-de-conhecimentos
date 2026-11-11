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