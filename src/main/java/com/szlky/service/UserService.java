package com.szlky.service;


import com.szlky.DTO.UserDTO;
import com.szlky.Utils.NotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserService {

    @Inject
    private ConstantService constantService;


    public List<UserDTO> getUsers() {

        return constantService.userList;
    }

    public UserDTO findUserById(String id) {
        for (UserDTO user: constantService.userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new NotFoundException("User with that id does not exist");
    }

    public UserDTO createUser(UserDTO userDTO) {
        constantService.userList.add(userDTO);
        return userDTO;
    }

    public UserDTO findUserByUsername(String username) {
        for (UserDTO user: constantService.userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new NotFoundException("User with that id does not exist");
    }


}
