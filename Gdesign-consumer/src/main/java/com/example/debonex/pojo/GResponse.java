package com.example.debonex.pojo;

/**
 * @author Debonet
 */
public class GResponse {

    private String message;

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
}
