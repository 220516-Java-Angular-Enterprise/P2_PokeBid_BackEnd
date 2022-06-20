package com.revature.pokebid.user.dtos.requests;

public class ChangePasswordRequest {
    //Attributes
    private String id;

    private String password;


    //Constructors
    public ChangePasswordRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public ChangePasswordRequest() {
    }


    //Gets and Sets
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ChangePasswordRequest{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
