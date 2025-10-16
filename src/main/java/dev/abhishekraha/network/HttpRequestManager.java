package dev.abhishekraha.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestManager {

    public static String sendRequest(String url, String requestMethod, String protocol) {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(protocol + url))
                    .method(requestMethod, HttpRequest.BodyPublishers.noBody())
                    .build();
            return httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString())
                    .body();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
