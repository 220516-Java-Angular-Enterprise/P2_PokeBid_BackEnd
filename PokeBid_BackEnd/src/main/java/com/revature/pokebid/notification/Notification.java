package com.revature.pokebid.notification;

import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.user.User;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="cardListing_id", nullable = false)
    private CardListing cardListing;

    @Column(name="message")
    private String message;

    public Notification(String id, User user, CardListing cardListing, String message) {
        this.id = id;
        this.user = user;
        this.cardListing = cardListing;
        this.message = message;
    }

    public Notification() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
