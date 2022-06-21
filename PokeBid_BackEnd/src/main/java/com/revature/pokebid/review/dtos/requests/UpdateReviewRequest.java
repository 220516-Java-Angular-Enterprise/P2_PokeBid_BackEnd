package com.revature.pokebid.review.dtos.requests;

public class UpdateReviewRequest {
    private String listingId;
    private String newReview;

    public UpdateReviewRequest(String listingId, String newReview) {
        this.listingId = listingId;
        this.newReview = newReview;
    }

    public UpdateReviewRequest() {
    }

    public String getListingId() {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getNewReview() {
        return newReview;
    }

    public void setNewReview(String newReview) {
        this.newReview = newReview;
    }

    @Override
    public String toString() {
        return "UpdateReviewRequest{" +
                "id='" + listingId + '\'' +
                ", newReview='" + newReview + '\'' +
                '}';
    }
}
