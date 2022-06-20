package com.revature.pokebid.history;

import com.revature.pokebid.listing.Listing;
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

    @OneToOne(mappedBy = "status_id")
    private String status_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing_id;

    public History() { }

    public History(String id, Timestamp time, String status_id, User users_id, Listing listing_id) {
        this.id = id;
        this.time = time;
        this.status_id = status_id;
        this.user_id = users_id;
        this.listing_id = listing_id;
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

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public User getUsers_id() {
        return user_id;
    }

    public void setUsers_id(User users_id) {
        this.user_id = users_id;
    }

    public Listing getListing_id() {
        return listing_id;
    }

    public void setListing_id(Listing listing_id) {
        this.listing_id = listing_id;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "History{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", status_id='" + status_id + '\'' +
                ", user_id=" + user_id +
                ", listing_id=" + listing_id +
                '}';
    }

}
