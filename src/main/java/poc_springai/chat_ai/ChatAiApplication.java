package poc_springai.chat_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatAiApplication implements CommandLineRunner {

	@Autowired
	ChatClient.Builder builder;

	public static void main(String[] args) {
		SpringApplication.run(ChatAiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var chatClient = builder.build();
		var prompt = chatClient.prompt("Hey, tell me a funny Dad joke!");
		var response = prompt.call().content();

		System.out.println(response);
	}
}
