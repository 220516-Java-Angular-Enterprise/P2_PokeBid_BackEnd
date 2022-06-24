package com.revature.pokebid.user.dtos.requests;

import com.revature.pokebid.user.User;

public class NewUserRequest {
    //region <attributes>
    private String username;
    private String password;

    private String address;
    private String email;

    //endregion

    //region <constructors>
    public NewUserRequest() {
        super();
    }

    public NewUserRequest(String username, String password, String address, String email) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
    }

    public NewUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

//endregion

    //region <Accessors and Mutators>

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //endregion

    public User extractUser(){
        return new User(username, address, email);
    }

    //region <methods>

    @Override
    public String toString() {
        return "NewUserRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


//endregion
}
