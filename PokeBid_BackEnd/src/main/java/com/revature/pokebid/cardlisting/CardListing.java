package com.revature.pokebid.cardlisting;

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
    @JoinColumn(name="lister")
    private User lister;
    @ManyToOne
    @JoinColumn(name="auction_bidder")
    private User auction_bidder;

    @Column(name="card", nullable = false)
    private String card;
    @Column (name="auction_bid")
    private int auction_bid;

    @OneToMany
    @JoinColumn(name="status")
    private Status status;

    @OneToMany
    @JoinColumn(name="condition")
    private Condition condition;

    @Column(name = "card_description")
    private String card_description;

    @Column(name = "time_end")
    private Timestamp time_end;


    //<editor-fold desc="Get/Set">

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getLister() {
        return lister;
    }

    public void setLister(User lister) {
        this.lister = lister;
    }

    public User getAuction_bidder() {
        return auction_bidder;
    }

    public void setAuction_bidder(User auction_bidder) {
        this.auction_bidder = auction_bidder;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
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
