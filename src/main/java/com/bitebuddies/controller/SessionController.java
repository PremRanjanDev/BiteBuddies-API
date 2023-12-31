package com.bitebuddies.controller;

import com.bitebuddies.dto.SessionDto;
import com.bitebuddies.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping("/all")
    public List<SessionDto> getAllSessions(){
        return sessionService.getAllSessions();
    }

    @GetMapping("/active")
    public List<SessionDto> getActiveSessions(){
        return sessionService.getActiveSessions();
    }

    @GetMapping("/{id}")
    public SessionDto getSession(@PathVariable Long id){
        return sessionService.getSession(id);
    }

    @PostMapping
    public SessionDto createSession(@RequestBody SessionDto req){
        return sessionService.createSession(req);
    }
    
    @PutMapping
    public SessionDto updateSession(@RequestBody SessionDto req){
        return sessionService.updateSession(req);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id){
        sessionService.deleteSession(id);
    }
}
