package com.revature.pokebid.history.dtos.requests;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.history.History;
import com.revature.pokebid.status.Status;
import com.revature.pokebid.user.User;

import java.sql.Timestamp;

public class NewHistoryRequest {

    private Status status;
    private User user;
    private CardListing listing;

    public NewHistoryRequest(String id, Timestamp time, Status status, User user, CardListing listing) {
        this.status = status;
        this.user = user;
        this.listing = listing;
    }

    public NewHistoryRequest() { }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public CardListing getListing() {
        return listing;
    }
    public void setListing(CardListing listing) {
        this.listing = listing;
    }


}
