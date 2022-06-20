package com.revature.pokebid.condition;

import com.revature.pokebid.util.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card_conditions")
public class Condition {
    @Id
    private String condition_id;

    @Column(name = "condition")
    private String condition;

    @Inject
    @Autowired
    public Condition(String condition_id, String condition) {
        this.condition_id = condition_id;
        this.condition = condition;
    }

    public String getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(String condition_id) {
        this.condition_id = condition_id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
