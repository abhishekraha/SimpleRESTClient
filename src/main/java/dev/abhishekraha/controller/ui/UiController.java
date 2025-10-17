package dev.abhishekraha.controller.ui;

import dev.abhishekraha.containers.components.RequestResponseContainer;

import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class UiController {

    private static final Consumer<HttpResponse<String>> httpResponseConsumer = UiController::handleHttpResponse;

    private UiController() {
    }

    private static void handleHttpResponse(HttpResponse<String> response) {

        resetAllTextFields();
        response.headers().map().forEach((key, values) -> {
            String headerValue = String.join(", ", values);
            RequestResponseContainer.getResponseHeaderBox().appendText(key + ": " + headerValue + '\n');
        });
        RequestResponseContainer.getResponseBodyBox().setText(response.body());

    }

    public static Consumer<HttpResponse<String>> getHttpResponseConsumer() {
        return httpResponseConsumer;
    }

    public static void resetAllTextFields() {
        RequestResponseContainer.getResponseHeaderBox().clear();
        RequestResponseContainer.getResponseBodyBox().clear();
        RequestResponseContainer.getHistoryBox().clear();
    }

}
