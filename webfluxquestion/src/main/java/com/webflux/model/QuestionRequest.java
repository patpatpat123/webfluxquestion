package com.webflux.model;

public class QuestionRequest {

    private String thing;

    public QuestionRequest() {
    }

    public QuestionRequest(String thing) {
        this.thing = thing;
    }

    public String getThing() {
        return thing;
    }

    @Override
    public String toString() {
        return "QuestionRequest{" +
                "thing='" + thing + '\'' +
                '}';
    }

}
