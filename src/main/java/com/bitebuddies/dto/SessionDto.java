package com.bitebuddies.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime startsAt;
    private Long initiatedByUserId;
    private UserDto initiatedBy;
    private Long pickedRestaurantId;
    private boolean active;
    private List<SessionUserDto> sessionUsers;
    private List<SessionRestaurantDto> sessionRestaurant;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime updatedAt;
}
