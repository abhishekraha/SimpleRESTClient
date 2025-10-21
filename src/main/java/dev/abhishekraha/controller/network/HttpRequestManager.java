package dev.abhishekraha.controller.network;

import javafx.application.Platform;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class HttpRequestManager {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static CompletableFuture<HttpResponse<String>> sendRequestAsync(String url, String requestMethod, String protocol) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(protocol + url))
                .method(requestMethod, HttpRequest.BodyPublishers.noBody())
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    }


    public static void sendRequestAsyncAndConsumeOnFxThread(String url, String requestMethod, String protocol, Consumer<HttpResponse<String>> onSuccess) {
        sendRequestAsyncAndConsumeOnFxThread(url, requestMethod, protocol, onSuccess, null);
    }

    public static void sendRequestAsyncAndConsumeOnFxThread(String url, String requestMethod, String protocol, Consumer<HttpResponse<String>> onSuccess, Consumer<Throwable> onError) {
        sendRequestAsync(url, requestMethod, protocol)
                .whenComplete((response, throwable) -> {
                    if (throwable != null) {
                        if (onError != null) {
                            Platform.runLater(() -> onError.accept(throwable));
                        } else {
                            throwable.printStackTrace();
                        }
                        return;
                    }
                    Platform.runLater(() -> onSuccess.accept(response));
                });
    }
}
