package poc_springai.chat_ai.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import poc_springai.chat_ai.constants.SimpsonsConstants;

@Service
public class SimpsonsTriviaService {

    private final static Logger LOG = LoggerFactory.getLogger(SimpsonsTriviaService.class);
    private final ChatClient chatClient;

    public SimpsonsTriviaService(ChatClient.Builder builder) {

        this.chatClient = builder.build();
    }

    public String getTrivia(String prompt) {

        LOG.info("Received trivia request with prompt: {}", prompt);

        var fullPrompt =  chatClient.prompt()
                .system(SimpsonsConstants.SIMPSONS_TRIVIA_SYSTEM_MESSAGE)
                .user(prompt);

        LOG.info("Constructed full prompt for chat client: {}", fullPrompt);

        return fullPrompt.call().content();

    }
}
