package com.szlky.DTO;

import java.util.HashMap;
import java.util.List;

public class ChatDTO {

    private HashMap<Integer,MessageDTO> content;
    private List<String> participants;
    private Integer id;
    private List<MessageDTO> messages;

    public ChatDTO(Integer id, List<MessageDTO> messages) {
        this.id = id;
        this.messages = messages;
    }

    public ChatDTO(List<String> participants, Integer id, List<MessageDTO> messages) {
        this.participants = participants;
        this.id = id;
        this.messages = messages;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }

    public HashMap<Integer, MessageDTO> getContent() {
        return content;
    }

    public void setContent(HashMap<Integer, MessageDTO> content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "ChatDTO{" +
                "content=" + content +
                ", id='" + id + '\'' +
                '}';
    }
}
