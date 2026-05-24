package poc_springai.chat_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpsonsExpert {

    ChatClient client;

    public SimpsonsExpert(ChatClient.Builder builder) {
        client = builder.build();
    }

    public String trivia(@RequestParam String prompt) {

        return "Here is your prompt "  +prompt;
    }


}
