package com.webflux.model;

public class ThirdStep {

    private String thingNeededInTheFinalResponse;

    public ThirdStep() {
    }

    public ThirdStep(String thingNeededInTheFinalResponse) {
        this.thingNeededInTheFinalResponse = thingNeededInTheFinalResponse;
    }

    public String getThingNeededInTheFinalResponse() {
        return thingNeededInTheFinalResponse;
    }

    public void setThingNeededInTheFinalResponse(String thingNeededInTheFinalResponse) {
        this.thingNeededInTheFinalResponse = thingNeededInTheFinalResponse;
    }

    @Override
    public String toString() {
        return "ThirdStep{" +
                "thingNeededInTheFinalResponse='" + thingNeededInTheFinalResponse + '\'' +
                '}';
    }

}
