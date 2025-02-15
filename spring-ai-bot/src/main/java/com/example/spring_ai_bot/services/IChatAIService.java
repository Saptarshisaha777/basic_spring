package com.example.spring_ai_bot.services;

import reactor.core.publisher.Flux;

public interface IChatAIService {
    String askToDeepAI(String message);
    Flux<String> askToDeepAIStream(String message);
}
