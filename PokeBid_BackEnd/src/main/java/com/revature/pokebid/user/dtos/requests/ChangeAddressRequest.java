package com.revature.pokebid.user.dtos.requests;

public class ChangeAddressRequest {
    //Address
    private String id;
    private String address;

    //Constructor
    public ChangeAddressRequest(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public ChangeAddressRequest() {
    }

    //Gets and Sets
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ChangeAddressRequest{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
