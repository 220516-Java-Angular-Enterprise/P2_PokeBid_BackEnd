package com.revature.pokebid.cardlisting.dtos.cardlisting;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.condition.Condition;
import com.revature.pokebid.condition.ConditionRepository;
import com.revature.pokebid.condition.ConditionService;
import com.revature.pokebid.status.Status;
import com.revature.pokebid.status.StatusService;
import com.revature.pokebid.user.User;

import java.sql.Timestamp;

public class NewCardListingRequest {

    String lister_id;
    String card_id;
    int auction_bid;
    String condition_id;
    String status_id;
    String description;
    Timestamp endTime;

    public NewCardListingRequest(){}

    public NewCardListingRequest(String lister_id, String card_id, int auction_bid, String condition_id, String status_id, String description, Timestamp endTime){
        this.lister_id = lister_id;
        this.card_id = card_id;
        this.auction_bid = auction_bid;
        this.condition_id = condition_id;
        this.status_id = status_id;
        this.description = description;
        this.endTime = endTime;
    }

    public String getLister_id() {
        return lister_id;
    }
    public void setLister(String lister_id) {
        this.lister_id = lister_id;
    }
    public int getAuction_bid() {
        return auction_bid;
    }
    public void setAuction_bid(int auction_bid) {
        this.auction_bid = auction_bid;
    }
    public String getCondition_id() {
        return condition_id;
    }
    public void setCondition_id(String condition_id) {
        this.condition_id = condition_id;
    }
    public String getStatus_id() {
        return status_id;
    }
    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Timestamp getEndTime() {
        return endTime;
    }
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getCard_id() { return card_id; }

    public void setCard_id(String card_id) { this.card_id = card_id; }
}
