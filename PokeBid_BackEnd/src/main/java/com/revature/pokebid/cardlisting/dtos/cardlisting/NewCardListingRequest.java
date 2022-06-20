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

    User lister; //UPDATE TO WORK BY GET USER BY ID!!! OR EXTRACT FROM TOKEN!
    String card_id;
    int auction_bid;
    Condition condition;
    Status status;
    String description;
    Timestamp endTime;

    public NewCardListingRequest(){}

    public NewCardListingRequest(User lister, String card_id, int auction_bid, Condition condition, Status status, String description, Timestamp endTime){
        this.lister = lister;
        this.card_id = card_id;
        this.auction_bid = auction_bid;
        this.condition = condition;
        this.status = status;
        this.description = description;
        this.endTime = endTime;
    }

    public User getLister() {
        return lister;
    }
    public void setLister(User lister) {
        this.lister = lister;
    }
    public int getAuction_bid() {
        return auction_bid;
    }
    public void setAuction_bid(int auction_bid) {
        this.auction_bid = auction_bid;
    }
    public Condition getCondition() {
        return condition;
    }
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
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


    public CardListing ExtractCardListing() {
        CardListing cardListing = new CardListing();
        cardListing.setLister(lister); //UPDATE THIS!!!!
        cardListing.setCard(card_id);
        cardListing.setAuction_bidder(null);
        cardListing.setAuction_bid(auction_bid);
        cardListing.setStatus(status); //SET TO BE LIKE SOMETHING!!!!
        cardListing.setCondition(condition); //SET TO BE LIKE SOMETHING!!!!
        cardListing.setCard_description(description);
        cardListing.setTime_end(endTime); //Set when register save listing!
        return cardListing;
    }
}
