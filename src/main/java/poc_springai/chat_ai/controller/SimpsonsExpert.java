package poc_springai.chat_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import poc_springai.chat_ai.service.SimpsonsTriviaService;

@RestController
public class SimpsonsExpert {

    private final SimpsonsTriviaService service;

    public SimpsonsExpert(SimpsonsTriviaService service) {
        this.service = service;
    }

    @GetMapping("/trivia")
    public String trivia(@RequestParam String prompt) {

        return service.getTrivia(prompt);
    }


}
