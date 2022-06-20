package com.revature.pokebid.user;

import com.revature.pokebid.history.History;
import com.revature.pokebid.cardlisting.CardListing;
import com.revature.pokebid.pinned.Pinned;
import com.revature.pokebid.review.Review;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //region Attributes
    @Id
    private String id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    List<Review> reviews;

    //@OneToMany(mappedBy ="user")
    //List<Pinned> pinned;

    @OneToMany(mappedBy ="user")
    List<History> history;

    @OneToMany(mappedBy ="user")
    List<CardListing> listings;
    //endregion

    //region Constructors
    public User() {
    }

    public User(String id, String username, String password, String address, String role, String email, List<Review> reviews, /*List<Pinned> pinned,*/ List<History> history, List<CardListing> listings) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.role = role;
        this.email = email;
        this.reviews = reviews;
        //this.pinned = pinned;
        this.history = history;
        this.listings = listings;
    }

    public User(String id, String username, String password, String address, String email, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.role = role;
    }

    public User(String username, String email, String address){
        this.username = username;
        this.address = address;
        this.email = email;
    }
    //endregion

    //region Gets and Sets
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    /*
    public List<Pinned> getPinned() {
        return pinned;
    }

    public void setPinned(List<Pinned> pinned) {
        this.pinned = pinned;
    } */

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public List<CardListing> getListings() {
        return listings;
    }

    public void setListings(List<CardListing> listings) {
        this.listings = listings;
    }
    //endregion


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", reviews=" + reviews +
                //", pinned=" + pinned +
                ", history=" + history +
                ", listings=" + listings +
                '}';
    }
}
