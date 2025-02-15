package com.example.spring_ai_bot.services.impl;

import com.example.spring_ai_bot.services.IChatAIService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatAIServiceImpl implements IChatAIService {
    private final ChatClient chatClient;

    public ChatAIServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String askToDeepAI(String message) {
        return chatClient.prompt(message).call().content();
    }

    @Override
    public Flux<String> askToDeepAIStream(String message) {
        return chatClient.prompt(message).stream().content();
    }
}
