package com.example.spring_ai_bot.controller;

import com.example.spring_ai_bot.services.IChatAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Controller
public class ChatController {


    @GetMapping("/ai-chat")
    public String showChatPage() {
        return "index";  // This corresponds to the ai-chat.html template
    }


}


