package com.mentor.agente.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class MentorAgentService {

    private final ChatClient chatClient;

    public MentorAgentService(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory) {
        this.chatClient = chatClientBuilder
                .defaultSystem(
                        "Você é um Especialista, Mentor e Professor que domina qualquer assunto existente no mundo. " +
                                "REGRAS OBRIGATÓRIAS:\n" +
                                "- NÃO faça apresentações nem use saudações formais a cada resposta.\n" +
                                "- Responda diretamente à dúvida do aluno de forma clara e didática.\n" +
                                "- Lembre-se do contexto das mensagens anteriores da conversa."
                )
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                )
                .build();
    }

    public String interagirComMentor(String mensagemUsuario) {
        return chatClient.prompt()
                .user(mensagemUsuario)
                // Passa o ID da conversa diretamente como String
                .advisors(advisorSpec -> advisorSpec.param("chat_memory_conversation_id", "sessao-padrao"))
                .call()
                .content();
    }
}
