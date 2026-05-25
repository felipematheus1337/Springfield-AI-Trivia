# Springfield AI Trivia

A lightweight AI-powered trivia API focused exclusively on **The Simpsons**.  
The application uses **Spring Boot**, **Spring AI**, and the **OpenAI chat model integration** to answer trivia prompts while enforcing a strict system message that keeps responses within the Simpsons universe.

## Overview

Springfield AI Trivia is a backend proof of concept built to explore how modern Java applications can integrate with LLMs through Spring AI's `ChatClient`.

The project exposes a simple REST endpoint where users can submit a prompt and receive an AI-generated Simpsons trivia response. A custom system instruction guides the model to only answer questions related to *The Simpsons* and reject unrelated topics.

## Features

- AI-powered trivia responses about *The Simpsons*
- Spring AI `ChatClient` integration
- OpenAI model support through Spring AI
- REST endpoint for prompt-based trivia queries
- System prompt guardrails to restrict answers to Simpsons-related content
- Simple, portfolio-friendly architecture
- Unit tests for controller, service, and prompt constants

## Tech Stack

- Java 21
- Spring Boot 4
- Spring AI
- OpenAI integration
- Maven
- JUnit 5
- Mockito

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── poc_springai
│   │       └── chat_ai
│   │           ├── constants
│   │           │   └── SimpsonsConstants.java
│   │           ├── controller
│   │           │   └── SimpsonsExpert.java
│   │           └── service
│   │               └── SimpsonsTriviaService.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── poc_springai
            └── chat_ai
                ├── constants
                ├── controller
                └── service
```

## How It Works

The application receives a prompt through the `/trivia` endpoint.

The controller delegates the request to `SimpsonsTriviaService`, which builds a prompt using Spring AI's `ChatClient`.

The service adds a system message that defines the AI behavior:

- Answer only questions related to *The Simpsons*
- Provide only Simpsons-related trivia
- Reject unrelated prompts with a fixed response

The final response is returned as plain text through the REST API.

## API Endpoint

### Get Simpsons trivia

```http
GET /trivia?prompt=Who%20is%20Homer%20Simpson?
```

Example response:

```text
Homer Simpson is the father of Bart, Lisa, and Maggie. He works at the Springfield Nuclear Power Plant and is known for his love of donuts.
```

### Non-Simpsons prompt

```http
GET /trivia?prompt=Who%20is%20Cristiano%20Ronaldo?
```

Expected behavior:

```text
I can only answer questions about the Simpsons!
```

## Getting Started

### Prerequisites

Before running the project, make sure you have installed:

- Java 21+
- Maven 3.9+
- An OpenAI API key

## Environment Variables

Create an environment variable named:

```bash
OPENAI_API_KEY=your_api_key_here
```

On Windows PowerShell:

```powershell
setx OPENAI_API_KEY "your_api_key_here"
```

On Linux/macOS:

```bash
export OPENAI_API_KEY="your_api_key_here"
```

## Configuration

In `application.properties`, configure Spring AI to read the API key from the environment:

```properties
spring.ai.openai.api-key=${OPENAI_API_KEY}
```

Depending on the Spring AI version used in your project, you may also configure the model explicitly, for example:

```properties
spring.ai.openai.chat.options.model=gpt-4o-mini
```

## Running the Application

Clone the repository:

```bash
git clone https://github.com/felipematheus1337/Springfield-AI-Trivia.git
cd Springfield-AI-Trivia
```

Run the application:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The API should be available at:

```text
http://localhost:8080
```

## Testing the Endpoint

Using the browser:

```text
http://localhost:8080/trivia?prompt=Who%20is%20Bart%20Simpson?
```

Using `curl`:

```bash
curl "http://localhost:8080/trivia?prompt=Who%20is%20Bart%20Simpson?"
```

## Running Tests

```bash
./mvnw test
```

On Windows:

```bash
mvnw.cmd test
```

The test suite covers:

- Controller behavior
- Service interaction with `ChatClient`
- System prompt constant validation

## Example Prompts

```text
Who is Homer Simpson?
```

```text
Tell me a trivia about Moe's Tavern.
```

```text
What is Bart Simpson's catchphrase?
```

```text
Who is Mr. Burns?
```

## Learning Goals

This project was created as a practical study project to explore:

- How to integrate Spring Boot applications with LLMs
- How Spring AI simplifies AI client configuration
- How to use `ChatClient` in a clean service layer
- How to keep AI behavior controlled with system prompts
- How to structure a small AI-powered REST API for portfolio usage

## Possible Improvements

- Add a frontend interface for trivia prompts
- Add Docker support
- Add Swagger/OpenAPI documentation
- Add response DTOs instead of returning raw strings
- Add prompt validation
- Add integration tests with mocked AI responses
- Add conversation memory for follow-up questions
- Add a dedicated exception handling layer
- Add deployment instructions for cloud platforms

## Disclaimer

This project is a study and portfolio application.  
*The Simpsons* is a trademark and property of its respective owners. This project is not affiliated with or endorsed by the owners of *The Simpsons*.

## Author

Developed by [Felipe Matheus](https://github.com/felipematheus1337).
