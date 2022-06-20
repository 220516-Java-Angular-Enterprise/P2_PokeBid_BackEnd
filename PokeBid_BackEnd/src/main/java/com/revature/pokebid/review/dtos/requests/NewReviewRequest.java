package com.revature.pokebid.review.dtos.requests;

public class NewReviewRequest {
    private String listingId;
    private String review;

    public NewReviewRequest(String listingId, String review) {
        this.listingId = listingId;
        this.review = review;
    }

    public NewReviewRequest() {
    }

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

    @Override
    public String toString() {
        return "NewReviewRequest{" +
                "listing_id='" + listingId + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
