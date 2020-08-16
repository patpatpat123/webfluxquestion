package com.webflux;

import com.webflux.model.FirstStep;
import com.webflux.model.QuestionRequest;
import com.webflux.model.QuestionResponse;
import com.webflux.model.SecondStep;
import com.webflux.model.ThirdStep;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class QuestionController {

	@PostMapping(path = "/question", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<QuestionResponse>> refundCustomer(@RequestBody QuestionRequest questionRequest) {
		return getFirstStepObjectFromQuestionRequest(questionRequest)
				.flatMap(this::getSecondStepObjectFromFirstStepObject)
				.flatMap((secondStep) -> getThirdStepObjectFromSecondStepObject(secondStep))
				.map(ResponseEntity::ok);
	}

	private Mono<Tuple2<FirstStep, QuestionResponse>> getFirstStepObjectFromQuestionRequest(QuestionRequest questionRequest) {
		String secretKey = getSecretKeyFromQuestionRequest(questionRequest);
		// webclient call to external service
		Mono<FirstStep> firstStep = Mono.just(new FirstStep("firstOne", "firstTwo"));
		return firstStep.map((step) -> {
			QuestionResponse response = new QuestionResponse();
			response.setThingFromTheFirstStep(step.getThingNeededInTheFinalResponse());
			return Tuples.of(step, response);
		});
	}

	private Mono<Tuple2<SecondStep, QuestionResponse>> getSecondStepObjectFromFirstStepObject(Tuple2<FirstStep, QuestionResponse> tuple) {
		String something = getSomethingFromFirstStepObject(tuple.getT1());
		// webclient call to external service
		Mono<SecondStep> secondStep = Mono.just(new SecondStep("secondOne", "secondTwo"));
		return secondStep.map((step) -> {
			QuestionResponse response = tuple.getT2();
			response.setThingFromTheSecondStep(step.getThingNeededInTheFinalResponse());
			return Tuples.of(step, response);
		});
	}

	private Mono<QuestionResponse> getThirdStepObjectFromSecondStepObject(Tuple2<SecondStep, QuestionResponse> tuple) {
		String somethingElse = getSomethingElseFromSecondStepObject(tuple.getT1());
		// webclient call to external service
		Mono<ThirdStep> thirdStep = Mono.just(new ThirdStep("thirdOne"));
		return thirdStep.map((step) -> {
			QuestionResponse response = tuple.getT2();
			response.setThingFromTheThirdStep(step.getThingNeededInTheFinalResponse());
			return response;
		});
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
