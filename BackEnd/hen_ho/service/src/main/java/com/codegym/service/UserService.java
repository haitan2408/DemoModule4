package com.codegym.service;

import com.codegym.dao.DTO.UserDTO;
import com.codegym.dao.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

public interface UserService {
    UserDetails loadUserByUsername(String userName);
    List<UserDTO> findAll();

}
