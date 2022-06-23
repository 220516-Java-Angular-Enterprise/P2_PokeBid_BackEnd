package com.revature.pokebid.pinned.dtos.requests;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.pinned.Pinned;
import com.revature.pokebid.user.User;
import javax.smartcardio.Card;

public class AddPinnedRequest {

    private String listing_id;
    private String user_id;

    public AddPinnedRequest(String id, String listing, String user) {
        this.listing_id = listing;
        this.user_id = user;
    }

    public AddPinnedRequest() { }


    public String getListing_id() {
        return listing_id;
    }
    public void setListing_id(String listing_id) {
        this.listing_id = listing_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
