package com.revature.pokebid.cardlisting.dtos.cardlisting;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.user.User;

import java.sql.Timestamp;

public class NewCardListingRequest {

    User lister; //UPDATE TO WORK BY GET USER BY ID!!! OR EXTRACT FROM TOKEN!
    String card_id
    int auction_bid;
    String condition_id;
    String description;
    //Timestamp endTime;

    public NewCardListingRequest(){}

    public NewCardListingRequest(User lister, String card_id, int auction_bid, String condition_id, String description){//, Timestamp endTime){
        this.lister = lister;
        this.card_id = card_id;
        this.auction_bid = auction_bid;
        this.condition_id = condition_id;
        this.description = description;
        //this.endTime = endTime;
    }



    //<editor-fold desc="Get/Set">

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

    public String getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(String condition_id) {
        this.condition_id = condition_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardListing ExtractCardListing() {
        CardListing cardListing = new CardListing();
        cardListing.setLister_id(lister); //UPDATE THIS!!!!
        cardListing.setCard_id(card_id);
        cardListing.setAuction_bidder(null);
        cardListing.setAuction_bid(auction_bid);
        cardListing.setStatus_id(); //SET TO BE LIKE SOMETHING!!!!
        cardListing.setCondition_id(condition_id); //SET TO BE LIKE SOMETHING!!!!
        cardListing.setCard_description(description);
        cardListing.setTime_end(null); //Set when register save listing!

    }

    /*
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
    */

    //</editor-fold desc="Get/Set">
}
