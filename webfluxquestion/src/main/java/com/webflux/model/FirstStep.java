package com.webflux.model;

public class FirstStep {

    private String thingNeededInTheFinalResponse;
    private String thingNeededInOrderToGetTheSecondStepObject;

    public FirstStep() {
    }

    public FirstStep(String thingNeededInTheFinalResponse, String thingNeededInOrderToGetTheSecondStepObject) {
        this.thingNeededInTheFinalResponse = thingNeededInTheFinalResponse;
        this.thingNeededInOrderToGetTheSecondStepObject = thingNeededInOrderToGetTheSecondStepObject;
    }

    public String getThingNeededInTheFinalResponse() {
        return thingNeededInTheFinalResponse;
    }

    public void setThingNeededInTheFinalResponse(String thingNeededInTheFinalResponse) {
        this.thingNeededInTheFinalResponse = thingNeededInTheFinalResponse;
    }

    public String getThingNeededInOrderToGetTheSecondStepObject() {
        return thingNeededInOrderToGetTheSecondStepObject;
    }

    public void setThingNeededInOrderToGetTheSecondStepObject(String thingNeededInOrderToGetTheSecondStepObject) {
        this.thingNeededInOrderToGetTheSecondStepObject = thingNeededInOrderToGetTheSecondStepObject;
    }

    @Override
    public String toString() {
        return "FirstStep{" +
                "thingNeededInTheFinalResponse='" + thingNeededInTheFinalResponse + '\'' +
                ", thingNeededInOrderToGetTheSecondStepObject='" + thingNeededInOrderToGetTheSecondStepObject + '\'' +
                '}';
    }

}
