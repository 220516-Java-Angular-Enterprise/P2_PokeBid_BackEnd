package com.revature.pokebid.user.dtos.requests;

public class ChangeEmailRequest {
    //Attributes
    private String id;
    private String email;

    //Constructors
    public ChangeEmailRequest(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public ChangeEmailRequest() {
    }

    //Gets and Sets
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ChangeEmailRequest{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
