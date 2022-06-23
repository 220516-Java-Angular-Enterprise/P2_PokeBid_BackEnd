package com.revature.pokebid.cardlisting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.revature.pokebid.condition.Condition;
import com.revature.pokebid.status.Status;
import com.revature.pokebid.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "card_listings")
public class CardListing {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false) //Seller
    private User user;
    @ManyToOne
    @JoinColumn(name="auction_bidder") // Buyer
    private User auction_bidder;

    @Column(name="card_id", nullable = false)
    private String card_id;

    @Column (name="auction_bid")
    private int auction_bid;

    @ManyToOne
    @JoinColumn(name="status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name="condition", nullable = false)
    private Condition condition;

    @Column(name = "card_description")
    private String card_description;

    @Column(name = "time_end", nullable = false)
    private Timestamp time_end;


    public CardListing(String id, User user, User auction_bidder, String card_id, int auction_bid, Status status, Condition condition, String card_description, Timestamp time_end) {
        this.id = id;
        this.user = user;
        this.auction_bidder = auction_bidder;
        this.card_id = card_id;
        this.auction_bid = auction_bid;
        this.status = status;
        this.condition = condition;
        this.card_description = card_description;
        this.time_end = time_end;
    }

    public CardListing(String id, User user, String card_id, Status status, Condition condition, Timestamp time_end) {
        this.id = id;
        this.user = user;
        this.card_id = card_id;
        this.status = status;
        this.condition = condition;
        this.time_end = time_end;
    }

    public CardListing() { }

    //<editor-fold desc="Get/Set">

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getLister() {
        return user;
    }

    public void setLister(User lister) {
        this.user = lister;
    }

    public User getAuction_bidder() {
        return auction_bidder;
    }

    public void setAuction_bidder(User auction_bidder) {
        this.auction_bidder = auction_bidder;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public int getAuction_bid() {
        return auction_bid;
    }

    public void setAuction_bid(int auction_bid) {
        this.auction_bid = auction_bid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getCard_description() {
        return card_description;
    }

    public void setCard_description(String card_description) {
        this.card_description = card_description;
    }

    public Timestamp getTime_end() {
        return time_end;
    }

    public void setTime_end(Timestamp time_end) {
        this.time_end = time_end;
    }

    //</editor-fold desc="Get/Set">





}
