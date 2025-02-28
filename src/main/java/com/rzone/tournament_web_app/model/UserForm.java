package com.rzone.tournament_web_app.model; // Change to match your package structure

public class UserForm {
    private String username;
    private String password;

    // Constructors
    public UserForm() {}

    public UserForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
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
}
