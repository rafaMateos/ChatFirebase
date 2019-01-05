package com.example.rafael.chatfirebase.Model;

public class User {

    private String Id;
    private String username;
    private String imageUrl;

    public User(String id, String username, String imageUrl) {
        Id = id;
        this.username = username;
        this.imageUrl = imageUrl;
    }

    public User(){}

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
