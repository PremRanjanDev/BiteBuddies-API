package com.bitebuddies.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startsAt;
    private UserDto initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    private Set<SessionUserDto> sessionUsers;
    private Set<SessionRestaurantDto> sessionRestaurant;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
