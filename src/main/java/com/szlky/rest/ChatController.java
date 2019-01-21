package com.szlky.rest;

import com.google.gson.Gson;
import com.szlky.DTO.ChatDTO;
import com.szlky.DTO.MessageDTO;
import com.szlky.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
// TODO fix cross origin
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    @Inject
    private ChatService chatService;

    private final Logger log = LoggerFactory.getLogger(ChatController.class);

    @RequestMapping(value = "/chat",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity getChat(@RequestParam String id) {
        List<MessageDTO> listOfMessages = chatService.getChat(Integer.valueOf(id));
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(listOfMessages), HttpStatus.OK);
    }

    @RequestMapping(value = "/chats",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity getChatsForUser(@RequestParam String userId) {
        List<ChatDTO> convos = chatService.getUserConvos(userId);
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(convos), HttpStatus.OK);
    }

    @RequestMapping(value = "/message",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
//        produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity sendMessage(@RequestBody MessageDTO messageDTO) {
        MessageDTO response = chatService.sendMessage(messageDTO);
        Gson gson = new Gson();
        return new ResponseEntity<>( gson.toJson(response), HttpStatus.OK);
    }
}
