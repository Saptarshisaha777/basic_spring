package com.example.spring_ai_bot.controller;

import com.example.spring_ai_bot.constants.ConstantPrompts;
import com.example.spring_ai_bot.entity.ChatRequest;
import com.example.spring_ai_bot.entity.ChatResponse;
import com.example.spring_ai_bot.services.IChatAIService;
import com.example.spring_ai_bot.services.impl.ChatAIServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;

@RestController
@RequestMapping("/chatai")
public class ChatAIController {

    @Autowired
    private IChatAIService chatAIService;

    @PostMapping("/ask")
    public Mono askToAI(@RequestBody ChatRequest chatRequest) {
        String aiResponse =chatAIService.askToDeepAI(chatRequest.getMessage()).replace("<think>","").replace("</think>","");  // Replace this with actual AI logic

        ChatResponse response = new ChatResponse();
        response.setResponse(aiResponse);
        return Mono.just(response);
    }

    @PostMapping(value = "/askStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> askToAIStream(@RequestBody ChatRequest chatRequest) {
        System.out.println("Inside as AI stream:: "+chatRequest.getMessage());
        String type = chatRequest.getType();
        String aiRequest = "";
        switch (type) {
            case "helpMe":
                aiRequest = ConstantPrompts.HelpPrompt.replace("[insert text]",chatRequest.getMessage());
                break;
            case "Summarize":
                aiRequest = ConstantPrompts.SummarizePrompt.replace("[insert text]",chatRequest.getMessage());
                break;
            default:
                aiRequest = chatRequest.getMessage();
        }
        System.out.println(type + "\n AI Request " +aiRequest);

        return chatAIService.askToDeepAIStream(aiRequest);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("jobDescription") String jobDescription) {
        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("File is empty");
        } else {
            try(InputStream inputStream=file.getInputStream();
                PDDocument document=PDDocument.load(inputStream);){
                PDFTextStripper pdfTextStripper=new PDFTextStripper();
                String text=pdfTextStripper.getText(document);
                String aiResponse =checkATSDeepAI(text,jobDescription).replace("<think>","").replace("</think>","");  // Replace this with actual AI logic
                System.out.println(aiResponse);
                return ResponseEntity.ok(aiResponse);
        } catch (Exception e) {
                return ResponseEntity.status(500).body(e.getMessage());
            }
        }
    }

    public String checkATSDeepAI(String text,String jobDescription) {
        System.out.println("Inside  AI PDF Checker:: "+text);
         String aiResponse =chatAIService.askToDeepAI(ConstantPrompts.prompt.replace("{resume_text}",text).replace("{job_description}",jobDescription));
        System.out.println(aiResponse);// Replace this with actual AI logic
       // aiResponse = aiResponse.split("```json")[1].split("```")[0];
        return aiResponse;
    }
}
