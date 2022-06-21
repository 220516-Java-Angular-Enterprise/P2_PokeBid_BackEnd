package com.revature.pokebid.review;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    private String id;

    @OneToOne
    @ManyToOne
    @JoinColumns ({
            @JoinColumn(name = "listing_id", referencedColumnName = "id"),
            @JoinColumn(name="seller_id", referencedColumnName = "auction_bidder")
                })
    private CardListing listing;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private User user;

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name ="date", nullable = false)
    private Timestamp timestamp;

    //region Constructors
    public Review(String id, CardListing listing, User user, String review, Timestamp timestamp) {
        this.id = id;
        this.listing = listing;
        this.user = user;
        this.review = review;
        this.timestamp = timestamp;
    }

    public Review() {
    }


    //endregion

    //region Gets and Sets

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CardListing getListing() {
        return listing;
    }

    public void setListing(CardListing listing) {
        this.listing = listing;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    //endregion
    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", listing=" + listing +
                ", user=" + user +
                ", review='" + review + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
