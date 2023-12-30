package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionEntity;
import com.bitebuddies.dto.SessionDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SessionMapper {
    SessionDto map(SessionEntity entity);
    List<SessionDto> map(List<SessionEntity> entities);
}
