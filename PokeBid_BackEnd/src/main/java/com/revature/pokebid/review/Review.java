package com.revature.pokebid.review;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.user.User;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id //Composite
    private String id;

    @OneToOne
    @JoinColumn (name = "listing_id")
    private CardListing listing;

    //@ManyToOne
    //@JoinColumn(name = "user_id", nullable = false)
    //private User seller;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private User user;

    @Column(name = "review", nullable = false)
    private String review;

    //Constructors
    public Review(CardListing listing, User seller, User reviewer, String review) {
        this.listing = listing;
        //this.seller = seller;
        this.user = reviewer;
        this.review = review;
    }

    public Review() {
    }


    //Gets and Sets
    public CardListing getListing() {
        return listing;
    }

    public void setListing(CardListing listing) {
        this.listing = listing;
    }

    //public User getSeller() {
    //    return seller;
    //}

    //public void setSeller(User seller) {
    //    this.seller = seller;
    //}

    public User getReviewer() {
        return user;
    }

    public void setReviewer(User reviewer) {
        this.user = reviewer;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "listing=" + listing +
                //", seller=" + seller +
                ", reviewer=" + user +
                ", review='" + review + '\'' +
                '}';
    }
}
