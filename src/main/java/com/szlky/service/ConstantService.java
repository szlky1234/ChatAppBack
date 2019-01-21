package com.szlky.service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.szlky.DTO.ChatDTO;
import com.szlky.DTO.MessageDTO;
import com.szlky.DTO.UserDTO;
import org.springframework.stereotype.Service;


@Service
public class ConstantService {

    public List<UserDTO> userList = new ArrayList<>();
    public List<ChatDTO> chatList = new ArrayList<>();
    public HashMap<String,List<ChatDTO>> convoMap = new HashMap<>();


    /*
    *   //TODO make repository layer instead of storing in memory
    * */
    @PostConstruct
    private void init() {

        UserDTO user1 =  new UserDTO("Alice","1","password");
        UserDTO user2 =  new UserDTO("Bob","2","password");
        UserDTO user3 =  new UserDTO("Steve","3","password");
        UserDTO user4 =  new UserDTO("Randall","4","password");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        List<MessageDTO> messageList = new ArrayList<>();
        messageList.add(new MessageDTO("Alice","Bob","hello",1));
        messageList.add(new MessageDTO("Alice","Bob","how r u",2));
        messageList.add(new MessageDTO("Bob","Alice","v good",3));

        ChatDTO chat1 = new ChatDTO(1,messageList);

        chatList.add(chat1);

        List<MessageDTO> messageList1 = new ArrayList<>();
        messageList1.add(new MessageDTO("Alice","Steve","hello",1));
        messageList1.add(new MessageDTO("Alice","Steve","how r u",2));
        messageList1.add(new MessageDTO("Steve","Alice","v good",3));

        ChatDTO chat2 = new ChatDTO(2,messageList1);
        chatList.add(chat2);


        List<ChatDTO> temp = new ArrayList<>();
        temp.add(chat1);
        temp.add(chat2);

        convoMap.put("Alice",temp);


    }
}
