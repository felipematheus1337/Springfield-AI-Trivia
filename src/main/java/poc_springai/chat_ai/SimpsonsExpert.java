package poc_springai.chat_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpsonsExpert {

    ChatClient chatClient;

    public SimpsonsExpert(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    @GetMapping("/trivia")
    public String trivia(@RequestParam String prompt) {

        var systemMessage = """
                You are a trivia expert specialized in only the TV show The Simpsons
                
                Rules:
                - Only answer questions related to The simpsons.
                - Only provide Simpsons related trivia.
                - If the question is not about The Simpsons, respond with:
                  "I can only answer questions about the Simpsons!"
                - Do not answer non-Simpsons related questions;
                """;
        var fullPrompt = chatClient.prompt().system(systemMessage)
                .user(prompt);

        return fullPrompt.call().content();
    }


}
