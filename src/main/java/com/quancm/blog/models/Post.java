package com.quancm.blog.models;

import java.sql.Timestamp;

public class Post {
    private int postId;
    private String title;
    private String description;
    private String content;
    private String author;
    private String imageUrl;
    private Timestamp createdAt;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Post() {
    }

    public Post(String title, String description, String content, String author, String imageUrl, Timestamp createdAt) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
