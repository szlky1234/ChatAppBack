package com.szlky.rest;

import com.google.gson.Gson;
import com.szlky.DTO.UserDTO;
import com.szlky.service.AuthService;
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
public class AuthenticationController {

    @Inject
    private AuthService authService;

    @Inject
    private UserService userService;

    @RequestMapping(value = "/authenticate",
            method = RequestMethod.GET,
//            produces = MediaType.TEXT_PLAIN_VALUE)
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity authenticate(@RequestParam String username, @RequestParam String password) {
        Gson gson = new Gson();
        UserDTO userDTO = new UserDTO(username,password);
        if (authService.authenticate(userDTO)) {
            return new ResponseEntity<>(gson.toJson(userService.findUserByUsername(username)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(gson.toJson("failure"), HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
