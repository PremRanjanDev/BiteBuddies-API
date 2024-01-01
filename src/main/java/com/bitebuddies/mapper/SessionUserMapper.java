package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionUserEntity;
import com.bitebuddies.dto.SessionUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SessionUserMapper {
    @Mapping(target = "sessionId", source = "session.id")
    SessionUserDto map(SessionUserEntity entity);
}
