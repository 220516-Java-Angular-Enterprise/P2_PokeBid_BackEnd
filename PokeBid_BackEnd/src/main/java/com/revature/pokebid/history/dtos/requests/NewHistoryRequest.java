package com.revature.pokebid.history.dtos.requests;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.history.History;
import com.revature.pokebid.status.Status;
import com.revature.pokebid.user.User;

import java.sql.Timestamp;

public class NewHistoryRequest {

    private String status_id;
    private String user_id;
    private String listing_id;

    public NewHistoryRequest(String id, Timestamp time, String status_id, String user_id, String listing_id) {
        this.status_id = status_id;
        this.user_id = user_id;
        this.listing_id = listing_id;
    }

    public NewHistoryRequest() { }
    public String getStatus_id() {
        return status_id;
    }
    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getListing_id() {
        return listing_id;
    }
    public void setListing_id(String listing_id) {
        this.listing_id = listing_id;
    }


}
