package com.szlky.service;

import com.szlky.DTO.ChatDTO;
import com.szlky.DTO.MessageDTO;
import com.szlky.DTO.UserDTO;
import com.szlky.Utils.NotFoundException;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class ChatService {

    @Inject
    private ConstantService constantService;

    @Inject
    private UserService userService;

    public List<MessageDTO> getChat(Integer id) {
        for (ChatDTO chat: constantService.chatList) {
            if (chat.getId().equals(id)) {
                return chat.getMessages();
            }
        }
        throw new NotFoundException("No chat found by that id");
    }

    public List<ChatDTO> getUserConvos(String userId) {
        UserDTO user = userService.findUserById(userId);
        List<ChatDTO> convos = constantService.convoMap.get(user.getUsername());
        if (convos != null) {
            return convos;
        } else {
            return new ArrayList<>();
        }
    }

    public MessageDTO sendMessage(MessageDTO messageDTO) {
        List<ChatDTO> chatList = constantService.chatList;
        for (int i = 0; i < chatList.size(); i++) {
            if (chatList.get(i).getId().equals(Integer.valueOf(messageDTO.getConvoId()))) {
                List<MessageDTO> temp = chatList.get(i).getMessages();
                temp.add(messageDTO);
                ChatDTO newChat = new ChatDTO(chatList.get(i).getId(),temp);
                chatList.set(i,newChat);
                constantService.chatList = chatList;
                return messageDTO;
            }
        }

        throw new NotFoundException("That convo ID does not exist");
    }
}
