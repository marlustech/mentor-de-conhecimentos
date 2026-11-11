package com.mentor.agente.controller;

import com.mentor.agente.service.MentorAgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {

    private final MentorAgentService mentorService;

    public MentorController(MentorAgentService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/perguntar")
    public ResponseEntity<String> perguntarAoMentor(@RequestBody String duvida) {
        String resposta = mentorService.interagirComMentor(duvida);
        return ResponseEntity.ok(resposta);
    }
}