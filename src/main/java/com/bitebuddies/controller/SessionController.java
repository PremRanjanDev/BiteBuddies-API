package com.bitebuddies.controller;

import com.bitebuddies.dto.RestaurantDto;
import com.bitebuddies.dto.SessionDto;
import com.bitebuddies.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping("/all")
    public List<SessionDto> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/active")
    public Collection<SessionDto> getActiveSessions() {
        return sessionService.getActiveSessions();
    }

    @GetMapping("/{id}")
    public SessionDto getSession(@PathVariable Long id) {
        return sessionService.getSession(id);
    }

    @PostMapping
    public SessionDto createSession(@RequestBody SessionDto req) {
        return sessionService.createSession(req);
    }

    @PutMapping
    public SessionDto updateSession(@RequestBody SessionDto req) {
        return sessionService.updateSession(req);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }

    @PutMapping("/{id}/invite")
    public SessionDto invite(@PathVariable Long id, @RequestBody List<Long> userIds) {
        return sessionService.invite(id, userIds);
    }

    @PutMapping("/{id}/join")
    public SessionDto join(@PathVariable Long id, @RequestBody Long userId) {
        return sessionService.join(id, userId);
    }

    @PutMapping("/{id}/add-restaurant")
    public SessionDto addRestaurant(@PathVariable Long id, @RequestBody RestaurantDto restaurantDto, @RequestParam Long requesterId) {
        return sessionService.addRestaurant(id, restaurantDto, requesterId);
    }

    @PutMapping("/{id}/end")
    public SessionDto endSession(@PathVariable Long id, @RequestParam Long requesterId) {
        return sessionService.endSession(id, requesterId);
    }
}
