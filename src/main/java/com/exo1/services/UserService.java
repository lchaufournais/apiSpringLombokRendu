package com.exo1.services;

import com.exo1.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    Page<UserDTO> getAllUsers(Pageable pageable);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getUsersByUsername(String username);
}