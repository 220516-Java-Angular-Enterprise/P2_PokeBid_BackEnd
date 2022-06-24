package com.revature.pokebid.cardlisting.dtos.cardlisting;

public class UpdateBidderRequest {
    private String id;
    private String bidder_id;
    private int bid;

    public UpdateBidderRequest(String id, String bidder_id, int bid) {
        this.id = id;
        this.bidder_id = bidder_id;
        this.bid = bid;
    }

    public UpdateBidderRequest() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBidder_id() {
        return bidder_id;
    }

    public void setBidder_id(String bidder_id) {
        this.bidder_id = bidder_id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
