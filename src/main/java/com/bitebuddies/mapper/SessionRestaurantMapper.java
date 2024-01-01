package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionRestaurantEntity;
import com.bitebuddies.dto.SessionRestaurantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {SessionMapper.class, RestaurantMapper.class})
public interface SessionRestaurantMapper {
    @Mapping(target = "sessionId", source = "session.id")
    @Mapping(target = "submittedByUserId", source = "submittedBy")
    SessionRestaurantDto map(SessionRestaurantEntity entity);

    Set<SessionRestaurantDto> map(Set<SessionRestaurantEntity> entities);
}
