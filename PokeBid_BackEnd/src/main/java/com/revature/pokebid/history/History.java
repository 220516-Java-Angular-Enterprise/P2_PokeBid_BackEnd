package com.revature.pokebid.history;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.status.Status;
import com.revature.pokebid.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order_history")
public class History {

    @Id //Primary Key
    private String id;

    @Column(name = "time", nullable = false)
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private CardListing listing;

    public History() { }

    public History(String id, Timestamp time, Status status, User users_id, CardListing listing) {
        this.id = id;
        this.time = time;
        this.status = status;
        this.user = users_id;
        this.listing = listing;
    }

    //<editor-fold desc="Get/Set">
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUsers_id() {
        return user;
    }

    public void setUsers_id(User users_id) {
        this.user = users_id;
    }

    public CardListing getListing_id() {
        return listing;
    }

    public void setListing_id(CardListing listing) {
        this.listing = listing;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "History{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", status_id='" + status + '\'' +
                ", user_id=" + user +
                ", listing_id=" + listing +
                '}';
    }

}
