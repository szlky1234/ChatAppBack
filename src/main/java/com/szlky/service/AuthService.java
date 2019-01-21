package com.szlky.service;


import com.szlky.DTO.UserDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class AuthService {

    @Inject
    private ConstantService constantService;

    public Boolean authenticate(UserDTO userDTO) {
        for (UserDTO user:constantService.userList) {
            return userDTO.getUsername().equals(user.getUsername()) && user.getPassword().equals(userDTO.getPassword());
            }

        return false;
        }
    }
