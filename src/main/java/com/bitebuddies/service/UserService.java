package com.bitebuddies.service;

import com.bitebuddies.dto.UserDto;
import com.bitebuddies.exception.ResourceNotFoundException;
import com.bitebuddies.exception.UserAuthenticationException;
import com.bitebuddies.mapper.UserMapper;
import com.bitebuddies.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDto login(UserDto loginUser) {
        return userMapper.map(userRepository.findByUsernameAndPasswordHash(loginUser.getUsername(), loginUser.getPasswordHash())
                .orElseThrow(() -> new UserAuthenticationException("Username or password is incorrect")));
    }


    public UserDto signUp(UserDto loginUser) {
        return null;
    }

    public UserDto getById(Long userId) {
        return userMapper.map(userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found")));
    }

    public List<UserDto> getAllUsers() {
        return userMapper.map(userRepository.findAll());
    }

    public List<UserDto> getAllUsers(List<Long> ids) {
        return userMapper.map(userRepository.findByIdIn(ids));
    }
}
