package com.github.tawalisa.ai.ai;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
class AiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test(){
		var ollamaApi = new OllamaApi();

		var chatModel = new OllamaChatModel(ollamaApi,
				OllamaOptions.create()
						.withModel("phi3")
						.withTemperature(0.9f));

		ChatResponse response = chatModel.call(
				new Prompt("Generate the names of 5 famous pirates."));

		System.out.println(response);
// Or with streaming responses
//		Flux<ChatResponse> response = chatModel.stream(
//				new Prompt("Generate the names of 5 famous pirates."));
	}
}
