package com.webflux.model;

public class SecondStep {

    private String thingNeededInTheFinalResponse;
    private String thingNeededInOrderToGetTheThirdStepObject;

    public SecondStep() {
    }

    public SecondStep(String thingNeededInTheFinalResponse, String thingNeededInOrderToGetTheThirdStepObject) {
        this.thingNeededInTheFinalResponse = thingNeededInTheFinalResponse;
        this.thingNeededInOrderToGetTheThirdStepObject = thingNeededInOrderToGetTheThirdStepObject;
    }

    public String getThingNeededInTheFinalResponse() {
        return thingNeededInTheFinalResponse;
    }

    public void setThingNeededInTheFinalResponse(String thingNeededInTheFinalResponse) {
        this.thingNeededInTheFinalResponse = thingNeededInTheFinalResponse;
    }

    public String getThingNeededInOrderToGetTheThirdStepObject() {
        return thingNeededInOrderToGetTheThirdStepObject;
    }

    public void setThingNeededInOrderToGetTheThirdStepObject(String thingNeededInOrderToGetTheThirdStepObject) {
        this.thingNeededInOrderToGetTheThirdStepObject = thingNeededInOrderToGetTheThirdStepObject;
    }

    @Override
    public String toString() {
        return "SecondStep{" +
                "thingNeededInTheFinalResponse='" + thingNeededInTheFinalResponse + '\'' +
                ", thingNeededInOrderToGetTheThirdStepObject='" + thingNeededInOrderToGetTheThirdStepObject + '\'' +
                '}';
    }

}
