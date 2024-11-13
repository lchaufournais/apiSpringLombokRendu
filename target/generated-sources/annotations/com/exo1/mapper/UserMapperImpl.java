package com.exo1.mapper;

import com.exo1.dto.ProjectDTO;
import com.exo1.dto.UserDTO;
import com.exo1.entities.Project;
import com.exo1.entities.User;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-13T16:42:47+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setName( user.getName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setProjects( projectSetToProjectDTOList( user.getProjects() ) );

        return userDTO;
    }

    @Override
    public User toUserEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );
        user.setProjects( projectDTOListToProjectSet( dto.getProjects() ) );

        return user;
    }

    @Override
    public List<UserDTO> toUsersDTOs(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( toUserDTO( user ) );
        }

        return list;
    }

    protected List<ProjectDTO> projectSetToProjectDTOList(Set<Project> set) {
        if ( set == null ) {
            return null;
        }

        List<ProjectDTO> list = new ArrayList<ProjectDTO>( set.size() );
        for ( Project project : set ) {
            list.add( projectMapper.toProjectDTO( project ) );
        }

        return list;
    }

    protected Set<Project> projectDTOListToProjectSet(List<ProjectDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Project> set = new LinkedHashSet<Project>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( ProjectDTO projectDTO : list ) {
            set.add( projectMapper.toProjectEntity( projectDTO ) );
        }

        return set;
    }
}
