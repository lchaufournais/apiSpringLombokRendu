package com.exo1.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private List<ProjectDTO> projects;
}
