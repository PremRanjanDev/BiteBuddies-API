package com.bitebuddies.dto;

import com.bitebuddies.model.InviteStatus;
import lombok.Data;

@Data
public class SessionUserDto {
    private Long sessionId;
    private UserDto user;
    private InviteStatus status;
}
