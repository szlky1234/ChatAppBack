package com.szlky.DTO;

import java.util.HashMap;
import java.util.List;

public class MessageDTO {
    private String sender;
    private String receiver;
    private String body;
    private Integer order;
    private String convoId;

    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setId(Integer order) {
        this.order = order;
    }

    public MessageDTO() {
    }


    public MessageDTO(String sender, String receiver, String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.body = body;
    }

    public MessageDTO(String sender, String receiver, String body, Integer order) {
        this.sender = sender;
        this.receiver = receiver;
        this.body = body;
        this.order = order;
    }

    public MessageDTO(String sender, String receiver, String body, String convoId) {
        this.sender = sender;
        this.receiver = receiver;
        this.body = body;
        this.convoId = convoId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", body='" + body + '\'' +
                ", order=" + order +
                '}';
    }
}
