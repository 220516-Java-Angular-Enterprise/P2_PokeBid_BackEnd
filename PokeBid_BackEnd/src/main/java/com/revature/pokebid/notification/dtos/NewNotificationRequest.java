package com.revature.pokebid.notification.dtos;

public class NewNotificationRequest {

    private String user_id, auction_id, message;

    public NewNotificationRequest(String user_id, String auction_id, String message) {
        this.user_id = user_id;
        this.auction_id = auction_id;
        this.message = message;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
