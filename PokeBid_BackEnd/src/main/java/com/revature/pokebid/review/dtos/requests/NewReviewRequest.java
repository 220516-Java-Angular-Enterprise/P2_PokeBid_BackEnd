package com.revature.pokebid.review.dtos.requests;

public class NewReviewRequest {
    private String listingId;
    private int rating;
    private String review;
    private String reviewerId;


    //region Constructors
    public NewReviewRequest(String listingId, int rating, String review, String reviewerId) {
        this.listingId = listingId;
        this.rating = rating;
        this.review = review;
        this.reviewerId = reviewerId;
    }

    public NewReviewRequest(){

    }
    //endRegion

    //region Gets and Sets
    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    //endRegion
}
