package com.szlky.rest;

import com.google.gson.Gson;
import com.szlky.DTO.MessageDTO;
import com.szlky.DTO.UserDTO;
import com.szlky.Utils.NotFoundException;
import com.szlky.service.ChatService;
import com.szlky.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
// TODO fix cross origin
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Inject
    private UserService userService;

    @Inject
    private ChatService chatService;


    @RequestMapping(value = "/users",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity getUsers() {
        List<UserDTO> users = userService.getUsers();
        Gson gson = new Gson();
        return new ResponseEntity<>( gson.toJson(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/user",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity getUser(@RequestParam String userId) {
        try {
            UserDTO user = userService.findUserById(userId);
            Gson gson = new Gson();
            return new ResponseEntity<>(gson.toJson(user), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("User with that ID does not exist", HttpStatus.BAD_REQUEST);
        }
    }


}
