package dev.abhishekraha.controller.ui;

import dev.abhishekraha.containers.components.InputContainer;
import dev.abhishekraha.containers.components.RequestResponseContainer;

import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class UiController {

    private InputContainer inputContainer;
    private RequestResponseContainer requestResponseContainer;

    private final Consumer<HttpResponse<String>> httpResponseConsumer = this::handleHttpResponse;
    private final Consumer<InputContainer> inputContainerConsumer = ic -> this.inputContainer = ic;
    private final Consumer<RequestResponseContainer> requestResponseContainerConsumer = ic -> this.requestResponseContainer = ic;

    private void handleHttpResponse(HttpResponse<String> response) {

        resetAllOutputFields();
        response.headers().map().forEach((key, values) -> {
            String headerValue = String.join(", ", values);
            requestResponseContainer.getResponseHeaderBox().appendText(key + ": " + headerValue + '\n');
        });
        requestResponseContainer.getResponseBodyBox().setText(response.body());

    }

    public void resetAllOutputFields() {
        requestResponseContainer.getResponseHeaderBox().clear();
        requestResponseContainer.getResponseBodyBox().clear();
        requestResponseContainer.getHistoryBox().clear();
    }

    public void resetAllFields() {
        inputContainer.getUrlInputTextField().clear();
        requestResponseContainer.getResponseHeaderBox().clear();
        requestResponseContainer.getResponseBodyBox().clear();
        requestResponseContainer.getHistoryBox().clear();
    }

    public Consumer<HttpResponse<String>> getHttpResponseConsumer() {
        return httpResponseConsumer;
    }

    public Consumer<InputContainer> getInputContainerConsumer() {
        return inputContainerConsumer;
    }

    public Consumer<RequestResponseContainer> getRequestResponseContainerConsumer() {
        return requestResponseContainerConsumer;
    }
}
