package com.revature.pokebid.cardlisting.dtos.cardlisting;

public class UpdateStatusRequest {

    private String id;
    private String status_id;

    public UpdateStatusRequest(String id, String status_id) {
        this.id = id;
        this.status_id = status_id;
    }

    public UpdateStatusRequest() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }
}
