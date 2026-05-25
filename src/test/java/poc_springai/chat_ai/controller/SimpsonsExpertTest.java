package poc_springai.chat_ai.controller;

import org.junit.jupiter.api.Test;
import poc_springai.chat_ai.service.SimpsonsTriviaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SimpsonsExpertTest {

    @Test
    void trivia_returnsServiceResponse() {
        SimpsonsTriviaService service = mock(SimpsonsTriviaService.class);
        SimpsonsExpert controller = new SimpsonsExpert(service);

        String prompt = "Who is Bart?";
        String expectedResponse = "Bart Simpson is Homer and Marge's son.";

        when(service.getTrivia(prompt)).thenReturn(expectedResponse);

        String result = controller.trivia(prompt);

        assertEquals(expectedResponse, result);
        verify(service).getTrivia(prompt);
    }
}