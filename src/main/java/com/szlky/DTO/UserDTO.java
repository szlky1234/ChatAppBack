package com.szlky.DTO;

public class UserDTO {

    private String username;
    private String id;
    private String password;
    private String message;

    public UserDTO(String username, String id, String password) {
        this.username = username;
        this.id = id;
        this.password = password;
    }


    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
