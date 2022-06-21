package com.revature.pokebid.review.dtos.requests;

public class NewReviewRequest {
    private String listingId;
    private String review;
    private String reivewerId;


    //region Constructors
    public NewReviewRequest(String listingId, String review, String reivewerId) {
        this.listingId = listingId;
        this.review = review;
        this.reivewerId = reivewerId;
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

    public String getReivewerId() {
        return reivewerId;
    }

    public void setReivewerId(String reivewerId) {
        this.reivewerId = reivewerId;
    }
    //endRegion
}
