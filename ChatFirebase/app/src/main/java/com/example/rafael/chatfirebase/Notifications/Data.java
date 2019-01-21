package com.example.rafael.chatfirebase.Notifications;

public class Data {

    private String user;
    private int icon;
    private String Body;
    private String title;
    private String sented;

    public Data(String user, int icon, String body, String title, String sented) {
        this.user = user;
        this.icon = icon;
        Body = body;
        this.title = title;
        this.sented = sented;
    }

    public Data() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSented() {
        return sented;
    }

    public void setSented(String sented) {
        this.sented = sented;
    }
}
