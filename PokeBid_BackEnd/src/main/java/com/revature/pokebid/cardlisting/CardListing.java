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
    @JoinColumn(name="lister_id")
    private User lister_id;
    @ManyToOne
    @JoinColumn(name="auction_bidder")
    private User auction_bidder;

    @Column(name="card_id", nullable = false)
    private String card_id;
    @Column (name="auction_bid")
    private int auction_bid;

    @OneToMany
    @JoinColumn(name="status_id")
    private Status status_id;

    @OneToMany
    @JoinColumn(name="condition_id")
    private Condition condition_id;

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

    public User getLister_id() {
        return lister_id;
    }

    public void setLister_id(User lister_id) {
        this.lister_id = lister_id;
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

    public Status getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Status status_id) {
        this.status_id = status_id;
    }

    public Condition getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(Condition condition_id) {
        this.condition_id = condition_id;
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
