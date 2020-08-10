package com.webflux;

import com.webflux.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Controller
@SpringBootApplication
public class QuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class);
    }

    @PostMapping(path = "/question", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QuestionResponse>> refundCustomer(@RequestBody QuestionRequest questionRequest) {
        Mono<FirstStep> firstStepMono = getFirstStepObjectFromQuestionRequest(questionRequest);

        Mono<SecondStep> secondStepMono = firstStepMono.flatMap(this::getSecondStepObjectFromFirstStepObject);

        Mono<ThirdStep> thirdStepMono = secondStepMono.flatMap(this::getThirdStepObjectFromSecondStepObject);

        Mono<QuestionResponse> questionResponseMono = Mono.zip(firstStepMono, secondStepMono, thirdStepMono).flatMap(tuple -> getQuestionResponseFromAllThreeSteps(tuple.getT1(), tuple.getT2(), tuple.getT3()));

        return questionResponseMono.map(ResponseEntity::ok);
    }

    private Mono<FirstStep> getFirstStepObjectFromQuestionRequest(QuestionRequest questionRequest) {
        String secretKey = getSecretKeyFromQuestionRequest(questionRequest);
        return WebClient.create().post().uri("http://firstWebService:8111/getFirstStep")
                .body(Mono.just(secretKey), String.class).retrieve().bodyToMono(FirstStep.class);
    }

    private Mono<SecondStep> getSecondStepObjectFromFirstStepObject(FirstStep firstStepObject) {
        String something = getSomethingFromFirstStepObject(firstStepObject);
        return WebClient.create().post().uri("http://secondWebService:8222/getSecondStep")
                .body(Mono.just(something), String.class).retrieve().bodyToMono(SecondStep.class);
    }

    private Mono<ThirdStep> getThirdStepObjectFromSecondStepObject(SecondStep secondStepObject) {
        String somethingElse = getSomethingElseFromSecondStepObject(secondStepObject);
        return WebClient.create().post().uri("http://thirdWebService:8333/getThirdStep")
                .body(Mono.just(somethingElse), String.class).retrieve().bodyToMono(ThirdStep.class);
    }

    private Mono<QuestionResponse> getQuestionResponseFromAllThreeSteps(FirstStep firstStep, SecondStep secondStep, ThirdStep thirdStep) {
        return Mono.just(new QuestionResponse(firstStep.getThingNeededInTheFinalResponse(), secondStep.getThingNeededInTheFinalResponse(), thirdStep.getThingNeededInTheFinalResponse()));
    }

    private String getSecretKeyFromQuestionRequest(QuestionRequest questionRequest) {
        System.out.println("I am a super heavy operation. I should be done only once. You should also see this line printed only once, But no...");
        return questionRequest.getThing().concat("dummy");
    }

    private String getSomethingFromFirstStepObject(FirstStep firstStepObject) {
        System.out.println("I am another super heavy operation. I should be done only once. You should also see this line printed only once, But no...");
        return firstStepObject.getThingNeededInOrderToGetTheSecondStepObject().concat("anotherDummy");
    }

    private String getSomethingElseFromSecondStepObject(SecondStep secondStepObject) {
        System.out.println("I am another other super heavy operation. I should be done only once. You should also see this line printed only once, But no...");
        return secondStepObject.getThingNeededInOrderToGetTheThirdStepObject().concat("anotherOtherDummy");
    }

}
