package com.example.debonex.pojo;

/**
 * @author Debonet
 */
public class GResponse {

    private String message;
    private Object content;

    public GResponse(String message, Object content) {
        this.message = message;
        this.content = content;
    }

    public GResponse() {
    }

    public GResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
