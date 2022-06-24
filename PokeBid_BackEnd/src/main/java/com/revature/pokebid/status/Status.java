package com.revature.pokebid.status;

import com.revature.pokebid.util.annotations.Inject;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
public class Status {
    @Id
    private String status_id;
    @Column(name = "status", nullable = false)
    private String status;

    @Inject
    @Autowired
    public Status(String status_id, String status) {
        this.status_id = status_id;
        this.status = status;
    }

    public Status(){}

    public String getStatus_id() {
        return status_id;
    }

    public void setStatusId(String statusId) {
        this.status_id = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status_id='" + status_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
