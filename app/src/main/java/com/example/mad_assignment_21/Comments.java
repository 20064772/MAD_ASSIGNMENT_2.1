package com.example.mad_assignment_21;

public class Comments {
    private int id;
    private int commentId;
    private String title;
    private String body;

    public Comments(int id, int commentId, String title, String body){
        this.id = id;
        this.commentId = commentId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String commentAsString(){
        String x = "Title: " + this.title + "\n" + "Body: " + this.body;
        return x;
    }
}
