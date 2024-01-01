package com.bitebuddies.service;

import com.bitebuddies.dao.SessionUserEntity;
import com.bitebuddies.dto.SessionDto;
import com.bitebuddies.exception.InvalidRequestException;
import com.bitebuddies.exception.ResourceNotFoundException;
import com.bitebuddies.mapper.SessionMapper;
import com.bitebuddies.model.InviteStatus;
import com.bitebuddies.repository.SessionRepository;
import com.bitebuddies.repository.SessionUserRepository;
import com.bitebuddies.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepo;

    @Autowired
    private SessionMapper sessionMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionUserRepository sessionUserRepository;

    public Collection<SessionDto> getActiveSessions() {
        log.info("getActiveSessions");
        return sessionMapper.map(sessionRepo.findByActive(true));
    }

    public Collection<SessionDto> getAllSessions() {
        log.info("getAllSessions");
        sessionUserRepository.findAll();
        return sessionMapper.map(sessionRepo.findAll());
    }

    public SessionDto getSession(Long id) {
        log.info("getSession : {}", id);
        return sessionMapper.map(sessionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Session not found")));
    }

    public SessionDto createSession(SessionDto req) {
        log.info("createSession : {}", req.getName());
        return sessionMapper.map(sessionRepo.save(sessionMapper.mapForCreate(req)));
    }

    public SessionDto updateSession(SessionDto req) {
        log.info("updateSession : {}", req.getId());
        var sessionInDb = sessionRepo.findById(req.getId()).orElseThrow(() -> new ResourceNotFoundException("Session not found"));
        sessionMapper.mapForUpdate(sessionInDb, req);
        return sessionMapper.map(sessionRepo.save(sessionInDb));
    }

    public void deleteSession(Long id) {
        log.info("deleteSession : {}", id);
        var sessionInDb = sessionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Session not found"));
        sessionRepo.delete(sessionInDb);
    }

    public SessionDto invite(Long sessionId, List<Long> userIds) {
        log.info("invite : sessionId {}, userIds {}", sessionId, userIds);
        var sessionInDb = sessionRepo.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session not found"));
        log.info("Session found: {}", sessionInDb.getName());
        var users = userRepository.findAllById(userIds);
        log.info("Total users found: {}", users.size());
        var invitees = users
                .stream()
                .map(user -> new SessionUserEntity(sessionInDb, user, InviteStatus.invited))
                .collect(Collectors.toSet());
        var invited = sessionUserRepository.saveAll(invitees);
        log.info("Users invited: {}", invited.size());
        return sessionMapper.map(sessionRepo.findById(sessionInDb.getId()).get());
    }

    public SessionDto join(Long sessionId, Long userId) {
        log.info("join : sessionId {}, userId {}", sessionId, userId);
        var session = sessionRepo.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session not found"));
        log.info("Session found: {}", session.getName());
        var user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        log.info("Users found: {}", user.getUsername());
        var invitee = sessionUserRepository.findBySessionIdAndUserId(session.getId(), user.getId()).orElseThrow(() -> new ResourceNotFoundException("User not invited for the session"));
        if (InviteStatus.joined.equals(invitee.getStatus())) {
            throw new InvalidRequestException("User already joined");
        }
        invitee.setStatus(InviteStatus.joined);
        var joined = sessionUserRepository.save(invitee);
        log.info("Users joined: {}", joined.getJoinedAt());
        return sessionMapper.map(sessionRepo.findById(session.getId()).get());
    }
}
