//package com.webflux;
//
//import com.webflux.model.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.client.RestTemplate;
//
//@Controller
//@SpringBootApplication
//public class QuestionOldApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(QuestionOldApplication.class);
//    }
//
//    @PostMapping(path = "/question", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<QuestionResponse> refundCustomer(@RequestBody QuestionRequest questionRequest) {
//        FirstStep firstStep = getFirstStepObjectFromQuestionRequest(questionRequest);
//
//        SecondStep secondStep = getSecondStepObjectFromFirstStepObject(firstStep);
//
//        ThirdStep thirdStep = getThirdStepObjectFromSecondStepObject(secondStep);
//
//        QuestionResponse questionResponse = getQuestionResponseFromAllThreeSteps(firstStep, secondStep, thirdStep);
//
//        return ResponseEntity.ok(questionResponse);
//    }
//
//    private FirstStep getFirstStepObjectFromQuestionRequest(QuestionRequest questionRequest) {
//        String secretKey = getSecretKeyFromQuestionRequest(questionRequest);
//        return new RestTemplate().postForEntity("http://firstWebServer:8111/getFirstStep", secretKey, FirstStep.class).getBody();
//    }
//
//    private SecondStep getSecondStepObjectFromFirstStepObject(FirstStep firstStepObject) {
//        String something = getSomethingFromFirstStepObject(firstStepObject);
//        return new RestTemplate().postForEntity("http://secondWebServer:8222/getSecondStep", something, SecondStep.class).getBody();
//    }
//
//    private ThirdStep getThirdStepObjectFromSecondStepObject(SecondStep secondStepObject) {
//        String somethingElse = getSomethingElseFromSecondStepObject(secondStepObject);
//        return new RestTemplate().postForEntity("http://thirdWebServer:8333/getThirdStep", somethingElse, ThirdStep.class).getBody();
//    }
//
//    private QuestionResponse getQuestionResponseFromAllThreeSteps(FirstStep firstStep, SecondStep secondStep, ThirdStep thirdStep) {
//        return new QuestionResponse(firstStep.getThingNeededInTheFinalResponse(), secondStep.getThingNeededInTheFinalResponse(), thirdStep.getThingNeededInTheFinalResponse());
//    }
//
//    private String getSecretKeyFromQuestionRequest(QuestionRequest questionRequest) {
//        System.out.println("I am a super heavy operation. I should be done only once. You should also see this line printed only once, But no...");
//        return questionRequest.getThing().concat("dummy");
//    }
//
//    private String getSomethingFromFirstStepObject(FirstStep firstStepObject) {
//        System.out.println("I am another super heavy operation. I should be done only once. You should also see this line printed only once, But no...");
//        return firstStepObject.getThingNeededInOrderToGetTheSecondStepObject().concat("anotherDummy");
//    }
//
//    private String getSomethingElseFromSecondStepObject(SecondStep secondStepObject) {
//        System.out.println("I am another other super heavy operation. I should be done only once. You should also see this line printed only once, But no...");
//        return secondStepObject.getThingNeededInOrderToGetTheThirdStepObject().concat("anotherOtherDummy");
//    }
//
//}
