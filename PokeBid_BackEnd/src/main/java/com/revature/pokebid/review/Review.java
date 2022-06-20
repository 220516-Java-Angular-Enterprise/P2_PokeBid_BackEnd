package com.revature.pokebid.review;

import com.revature.pokebid.user.User;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id //Composite
    @OneToOne
    @JoinColumn (name = "listing_id")
    private CardListing listing;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @ManyToOne
    @JoinColumn(name ="reviewer_id", nullable = false)
    private User reviewer;

    @Column(name = "review", nullable = false)
    private String review;

    //Constructors
    public Review(CardListing listing, User seller, User reviewer, String review) {
        this.listing = listing;
        this.seller = seller;
        this.reviewer = reviewer;
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

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
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
                ", seller=" + seller +
                ", reviewer=" + reviewer +
                ", review='" + review + '\'' +
                '}';
    }
}
