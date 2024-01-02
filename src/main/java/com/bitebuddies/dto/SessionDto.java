package com.bitebuddies.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SessionDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startsAt;
    private Long initiatedByUserId;
    private UserDto initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    private List<SessionUserDto> sessionUsers;
    private List<SessionRestaurantDto> sessionRestaurant;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
