package poc_springai.chat_ai.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpsonsConstantsTest {

    @Test
    void simpsonsTriviaSystemMessage_shouldContainMainRoleInstruction() {
        String message = SimpsonsConstants.SIMPSONS_TRIVIA_SYSTEM_MESSAGE;

        assertTrue(message.contains("trivia expert"));
        assertTrue(message.contains("The Simpsons"));
    }

    @Test
    void simpsonsTriviaSystemMessage_shouldRestrictAnswersToTheSimpsons() {
        String message = SimpsonsConstants.SIMPSONS_TRIVIA_SYSTEM_MESSAGE;

        assertTrue(message.contains("Only answer questions related to The simpsons"));
        assertTrue(message.contains("Only provide Simpsons related trivia"));
    }

    @Test
    void simpsonsTriviaSystemMessage_shouldContainFallbackResponse() {
        String message = SimpsonsConstants.SIMPSONS_TRIVIA_SYSTEM_MESSAGE;

        assertTrue(message.contains("I can only answer questions about the Simpsons!"));
    }
}