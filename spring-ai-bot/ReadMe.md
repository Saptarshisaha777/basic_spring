
**Spring AI Bot**
================

**Overview**
------------

Spring AI Bot is a conversational AI bot built using Spring Boot, designed to provide a user-friendly interface for interacting with Ollama and DeepSeek R1 LLM models. The bot accepts user input, processes it, and responds with relevant information.

**Functionality**
----------------

The bot provides the following functionality:

* **Text-based conversation**: Users can interact with the bot using text-based input.
* **Ollama model integration**: The bot uses the Ollama model to process user input and generate responses for help-related queries.
* **DeepSeek R1 LLM model integration**: The bot uses the DeepSeek R1 LLM model to process user input and generate responses for summarization-related queries.
* **Multiple response types**: The bot can respond with different types of responses, including text.
* **File upload**: Users can upload a file (e.g. a resume) for processing.

**Backend**
------------

The backend of the bot is built using Spring Boot, with the following components:

* **ChatAIController**: Handles incoming requests from the frontend and interacts with the Ollama and DeepSeek R1 LLM models to generate responses.
* **IChatAIService**: Provides an interface for interacting with the Ollama and DeepSeek R1 LLM models.
* **ChatRequest**: Represents a user's input, including the text and type of request.
* **ChatResponse**: Represents the bot's response, including the text and type of response.

**Request and Response Formats**
-------------------------------

The bot accepts requests in the following format:

* **POST /ask**: Accepts a `ChatRequest` object with the user's input.
* **POST /askStream**: Accepts a `ChatRequest` object with the user's input and returns a stream of responses.
* **POST /upload**: Accepts a file upload and a job description, and returns the processed result.

The bot responds with a `ChatResponse` object, which includes the following fields:

* **response**: The text of the response.
* **type**: The type of response (e.g. text).

**Supported Request Types**
---------------------------

The bot supports the following request types:

* **Summarize**: Summarize the input text using the DeepSeek R1 LLM model.
* **helpme**: Provide help with the input text using the Ollama model.

**Example Requests and Responses**
---------------------------------

### Example Request for Summarize

```json
POST /ask HTTP/1.1
Content-Type: application/json

{
  "message": "This is a long piece of text that needs to be summarized.",
  "type": "Summarize"
}
```

### Example Response for Summarize

```json
HTTP/1.1 200 OK
Content-Type: application/json

{
  "response": "This is a summarized version of the text.",
  "type": "text"
}
```

### Example Request for helpme

```json
POST /ask HTTP/1.1
Content-Type: application/json

{
  "message": "I need help with this piece of text.",
  "type": "helpme"
}
```

### Example Response for helpme

```json
HTTP/1.1 200 OK
Content-Type: application/json

{
  "response": "Here is some help with the text.",
  "type": "text"
}
```

### Example Request for File Upload

```json
POST /upload HTTP/1.1
Content-Type: multipart/form-data

file: resume.pdf
jobDescription: Software Engineer
```

### Example Response for File Upload

```json
HTTP/1.1 200 OK
Content-Type: application/json

{
  "response": "Your resume has been processed and the ATS score is 80%",
  "type": "text"
}
```

