package com.webflux.model;

public class QuestionResponse {

    private String thingFromTheFirstStep;
    private String thingFromTheSecondStep;
    private String thingFromTheThirdStep;

    public QuestionResponse() {
    }

    public QuestionResponse(String thingFromTheFirstStep, String thingFromTheSecondStep, String thingFromTheThirdStep) {
        this.thingFromTheFirstStep = thingFromTheFirstStep;
        this.thingFromTheSecondStep = thingFromTheSecondStep;
        this.thingFromTheThirdStep = thingFromTheThirdStep;
    }

    public String getThingFromTheFirstStep() {
        return thingFromTheFirstStep;
    }

    public void setThingFromTheFirstStep(String thingFromTheFirstStep) {
        this.thingFromTheFirstStep = thingFromTheFirstStep;
    }

    public String getThingFromTheSecondStep() {
        return thingFromTheSecondStep;
    }

    public void setThingFromTheSecondStep(String thingFromTheSecondStep) {
        this.thingFromTheSecondStep = thingFromTheSecondStep;
    }

    public String getThingFromTheThirdStep() {
        return thingFromTheThirdStep;
    }

    public void setThingFromTheThirdStep(String thingFromTheThirdStep) {
        this.thingFromTheThirdStep = thingFromTheThirdStep;
    }

    @Override
    public String toString() {
        return "QuestionResponse{" +
                "thingFromTheFirstStep='" + thingFromTheFirstStep + '\'' +
                ", thingFromTheSecondStep='" + thingFromTheSecondStep + '\'' +
                ", thingFromTheThirdStep='" + thingFromTheThirdStep + '\'' +
                '}';
    }

}
