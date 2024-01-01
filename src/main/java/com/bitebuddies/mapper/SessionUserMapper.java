package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionUserEntity;
import com.bitebuddies.dto.SessionUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {SessionMapper.class, UserMapper.class})
public interface SessionUserMapper {
    @Mapping(target = "sessionId", source = "session.id")
    SessionUserDto map(SessionUserEntity entity);

    Set<SessionUserDto> map(Set<SessionUserEntity> entities);
}
