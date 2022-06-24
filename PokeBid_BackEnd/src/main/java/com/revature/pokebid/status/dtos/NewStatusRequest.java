package com.revature.pokebid.status.dtos;

public class NewStatusRequest {

    private String status;

    public NewStatusRequest(String status) { this.status = status; }

    public NewStatusRequest() { }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
