package poc_springai.chat_ai.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poc_springai.chat_ai.service.SimpsonsTriviaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SimpsonsExpertTest {

    private SimpsonsTriviaService service;
    private SimpsonsExpert controller;

    @BeforeEach
    void setUp() {
        service = mock(SimpsonsTriviaService.class);
        controller = new SimpsonsExpert(service);
    }

    @Test
    void trivia_shouldReturnServiceResponse() {
        String prompt = "Who is Bart Simpson?";
        String expectedResponse = "Bart Simpson is Homer and Marge's son.";

        when(service.getTrivia(prompt)).thenReturn(expectedResponse);

        String result = controller.trivia(prompt);

        assertEquals(expectedResponse, result);
        verify(service).getTrivia(prompt);
    }

    @Test
    void trivia_whenPromptIsAboutHomer_shouldReturnTrivia() {
        String prompt = "Tell me a trivia about Homer";
        String expectedResponse = "Homer works at the Springfield Nuclear Power Plant.";

        when(service.getTrivia(prompt)).thenReturn(expectedResponse);

        String result = controller.trivia(prompt);

        assertEquals(expectedResponse, result);
        verify(service).getTrivia(prompt);
    }

    @Test
    void trivia_whenPromptIsNotAboutSimpsons_shouldReturnRestrictionMessage() {
        String prompt = "Tell me about Dragon Ball";
        String expectedResponse = "I can only answer questions about the Simpsons!";

        when(service.getTrivia(prompt)).thenReturn(expectedResponse);

        String result = controller.trivia(prompt);

        assertEquals(expectedResponse, result);
        verify(service).getTrivia(prompt);
    }
}