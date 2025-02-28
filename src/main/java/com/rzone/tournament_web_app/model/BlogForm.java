package com.rzone.tournament_web_app.model; // Change to match your package structure

public class BlogForm {
    private String title;
    private String content;

    // Constructors
    public BlogForm() {}

    public BlogForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
