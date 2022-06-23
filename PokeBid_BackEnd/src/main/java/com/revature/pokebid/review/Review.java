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
    @JoinColumn(name = "listing_id", nullable = false)
    private CardListing listing;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private User user; // Person that has the review on them.

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name ="date", nullable = false)
    private Timestamp timestamp;

    //region Constructors
    public Review(String id, CardListing listing, User seller, User user, int rating, String review, Timestamp timestamp) {
        this.id = id;
        this.listing = listing;
        this.seller = seller;
        this.user = user;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
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
