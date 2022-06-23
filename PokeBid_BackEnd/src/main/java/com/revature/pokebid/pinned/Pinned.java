package com.revature.pokebid.pinned;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.pinned.dtos.requests.AddPinnedRequest;
import com.revature.pokebid.user.User;

import javax.persistence.*;

@Entity
@Table(name = "pinned_cards")
public class Pinned {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    private User user; // Person that has the review on them.

    @ManyToOne
    @JoinColumn(name ="listing_id", nullable = false)
    private CardListing cardListing; // Person that has the review on them.

    public Pinned() { }

    public Pinned(String id, User user, CardListing cardListing) {
        this.id = id;
        this.user = user;
        this.cardListing = cardListing;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CardListing getCardListing() {
        return cardListing;
    }

    public void setCardListing(CardListing cardListing) {
        this.cardListing = cardListing;
    }

    @Override
    public String toString() {
        return "Pinned{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", cardListing=" + cardListing +
                '}';
    }
}
