package dev.abhishekraha.containers.components;

import dev.abhishekraha.containers.templates.ContainerTemplate;
import dev.abhishekraha.controller.network.HttpRequestManager;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.net.http.HttpResponse;
import java.util.function.Consumer;


public class InputContainer {

    private final String HTTP = "http://";
    private final String HTTPS = "https://";

    private final Button sendButton;
    private final ComboBox<String> requestMethodDropdown;
    private final ComboBox<String> protocolDropdown;
    private final Consumer<HttpResponse<String>> httpResponseConsumer;
    private final HBox inputContainer;
    private final TextField urlInputField;


    public InputContainer(Consumer<HttpResponse<String>> httpResponseConsumer) {
        this.httpResponseConsumer = httpResponseConsumer;

        inputContainer = ContainerTemplate.newHorizontalContainer();
        protocolDropdown = new ComboBox<>();
        requestMethodDropdown = new ComboBox<>();
        sendButton = new Button("Send");
        urlInputField = new TextField();
    }

    public HBox getContainer() {
        inputContainer.getChildren().add(setupUrlLabel());
        inputContainer.getChildren().add(setupRequestMethodDropdown());
        inputContainer.getChildren().add(setupProtocolDropdown());
        inputContainer.getChildren().add(setupUrlInputTextField());
        inputContainer.getChildren().add(setupSendButton());

        return inputContainer;
    }

    private Node setupUrlLabel() {
        return new Label("Enter URL:");
    }

    private Node setupRequestMethodDropdown() {

        requestMethodDropdown.getItems().addAll("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD");
        requestMethodDropdown.setValue("GET");
        return requestMethodDropdown;
    }

    private Node setupProtocolDropdown() {

        protocolDropdown.getItems().addAll(HTTP, HTTPS);
        protocolDropdown.setValue(HTTPS);
        return protocolDropdown;
    }

    private Node setupUrlInputTextField() {
        urlInputField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(urlInputField, Priority.ALWAYS);

        urlInputField.setOnKeyReleased(keyEvent -> {

            // Don't do this check if the string doesn;t start with http.....
            if (urlInputField.getText().startsWith("http")) {
                if (urlInputField.getText().startsWith(HTTPS)) {
                    protocolDropdown.setValue(HTTPS);
                    urlInputField.setText(urlInputField.getText().substring(HTTPS.length()));
                } else if (urlInputField.getText().startsWith(HTTP)) {
                    protocolDropdown.setValue(HTTP);
                    urlInputField.setText(urlInputField.getText().substring(HTTP.length()));
                }
            }

            if (keyEvent.getCode() == KeyCode.ENTER) {
                HttpRequestManager.sendRequestAsyncAndConsumeOnFxThread(
                        urlInputField.getText(),
                        requestMethodDropdown.getValue(),
                        protocolDropdown.getValue(),
                        httpResponseConsumer
                );
            }
        });

        return urlInputField;
    }

    private Node setupSendButton() {
        sendButton.setOnAction(event -> HttpRequestManager.sendRequestAsyncAndConsumeOnFxThread(
                urlInputField.getText(),
                requestMethodDropdown.getValue(),
                protocolDropdown.getValue(),
                httpResponseConsumer
        ));
        return sendButton;
    }

    public TextField getUrlInputTextField() {
        return urlInputField;
    }
}
