package com.revature.pokebid.condition.dtos;

public class NewConditionRequest {
    private String condition;

    public NewConditionRequest(String condition) {
        this.condition = condition;
    }

    public NewConditionRequest() { }

    public String getCondition() {
        return condition;
    }


    public void setCondition(String condition) {
        this.condition = condition;
    }
}
