package com.revature.pokebid.review.dtos.requests;

public class UpdateReviewRequest {
    private String Id;
    private int newRating;
    private String newReview;

    public UpdateReviewRequest(String Id, int newRating, String newReview) {
        this.Id = Id;
        this.newRating = newRating;
        this.newReview = newReview;
    }

    public UpdateReviewRequest() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNewReview() {
        return newReview;
    }

    public void setNewReview(String newReview) {
        this.newReview = newReview;
    }

    public int getNewRating() {
        return newRating;
    }

    public void setNewRating(int newRating) {
        this.newRating = newRating;
    }

    @Override
    public String toString() {
        return "UpdateReviewRequest{" +
                "id='" + Id + '\'' +
                ", newReview='" + newReview + '\'' +
                '}';
    }
}
