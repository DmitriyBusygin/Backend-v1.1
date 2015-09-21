package com.busdmv.backend.beans;

public class Messages {

    private int id;
    private String clientId;
    private String message;

    // Id
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // ClientId
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    // Message
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
