package com.exo1.mapper;

import com.exo1.dto.UserDTO;
import com.exo1.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", uses = {ProjectMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(User user);

    User toUserEntity(UserDTO dto);

    List<UserDTO> toUsersDTOs(List<User> users);
}
