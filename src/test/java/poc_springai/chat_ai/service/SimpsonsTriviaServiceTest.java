package poc_springai.chat_ai.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.chat.client.ChatClient;
import poc_springai.chat_ai.constants.SimpsonsConstants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpsonsTriviaServiceTest {

    @Mock
    private ChatClient.Builder builder;

    @Mock
    private ChatClient chatClient;

    @Mock
    private ChatClient.ChatClientRequestSpec requestSpec;

    @Mock
    private ChatClient.CallResponseSpec callResponseSpec;

    private SimpsonsTriviaService service;

    @BeforeEach
    void setUp() {
        when(builder.build()).thenReturn(chatClient);
        service = new SimpsonsTriviaService(builder);
    }

    @Test
    void constructor_shouldBuildChatClientFromBuilder() {
        assertNotNull(service);

        verify(builder).build();
    }

    @Test
    void getTrivia_shouldReturnContentFromChatClient() {
        String prompt = "Who is Homer Simpson?";
        String expectedResponse = "Homer Simpson is the father of Bart, Lisa and Maggie.";

        when(chatClient.prompt()).thenReturn(requestSpec);
        when(requestSpec.system(SimpsonsConstants.SIMPSONS_TRIVIA_SYSTEM_MESSAGE)).thenReturn(requestSpec);
        when(requestSpec.user(prompt)).thenReturn(requestSpec);
        when(requestSpec.call()).thenReturn(callResponseSpec);
        when(callResponseSpec.content()).thenReturn(expectedResponse);

        String result = service.getTrivia(prompt);

        assertEquals(expectedResponse, result);

        verify(chatClient).prompt();
        verify(requestSpec).system(SimpsonsConstants.SIMPSONS_TRIVIA_SYSTEM_MESSAGE);
        verify(requestSpec).user(prompt);
        verify(requestSpec).call();
        verify(callResponseSpec).content();
    }

    @Test
    void getTrivia_whenPromptIsNotAboutSimpsons_shouldStillDelegateToChatClient() {
        String prompt = "Who is Cristiano Ronaldo?";
        String expectedResponse = "I can only answer questions about the Simpsons!";

        when(chatClient.prompt()).thenReturn(requestSpec);
        when(requestSpec.system(SimpsonsConstants.SIMPSONS_TRIVIA_SYSTEM_MESSAGE)).thenReturn(requestSpec);
        when(requestSpec.user(prompt)).thenReturn(requestSpec);
        when(requestSpec.call()).thenReturn(callResponseSpec);
        when(callResponseSpec.content()).thenReturn(expectedResponse);

        String result = service.getTrivia(prompt);

        assertEquals(expectedResponse, result);

        verify(chatClient).prompt();
        verify(requestSpec).system(SimpsonsConstants.SIMPSONS_TRIVIA_SYSTEM_MESSAGE);
        verify(requestSpec).user(prompt);
        verify(requestSpec).call();
        verify(callResponseSpec).content();
    }
}