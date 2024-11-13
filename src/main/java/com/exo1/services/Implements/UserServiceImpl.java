package com.exo1.services.Implements;

import com.exo1.dto.UserDTO;
import com.exo1.mapper.ProjectMapper;
import com.exo1.mapper.UserMapper;
import com.exo1.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.exo1.repositories.UserRepository;
import com.exo1.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        return usersPage.map(userMapper::toUserDTO);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toUserEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.toUserDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());

        if (userDTO.getProjects() != null) {
            existingUser.setProjects(userDTO.getProjects().stream()
                    .map(ProjectMapper.INSTANCE::toProjectEntity)
                    .collect(Collectors.toSet()));
        }

        User updatedUser = userRepository.save(existingUser);
        return UserMapper.INSTANCE.toUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getUsersByUsername(String name) {
        return userMapper.toUsersDTOs(userRepository.findByUserName(name));
    }
}
