package dev.abhishekraha.containers.components;

import dev.abhishekraha.containers.templates.ContainerTemplate;
import dev.abhishekraha.controller.network.HttpRequestManager;
import dev.abhishekraha.controller.ui.UiController;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.net.http.HttpResponse;

public class InputContainer {
    private static final HBox inputContainer = ContainerTemplate.newHorizontalContainer();

    private static final ComboBox<String> requestMethodDropdown = new ComboBox<>();
    private static final ComboBox<String> protocolDropdown = new ComboBox<>();
    private static final TextField urlInputField = new TextField();

    private InputContainer() {
    }

    public static HBox getContainer() {
        inputContainer.getChildren().add(setupUrlLabel());
        inputContainer.getChildren().add(setupRequestMethodDropdown());
        inputContainer.getChildren().add(setupProtocolDropdown());
        inputContainer.getChildren().add(setupUrlInputTextField());
        inputContainer.getChildren().add(setupSendButton());

        return inputContainer;
    }

    private static Node setupUrlLabel() {
        return new Label("Enter URL:");
    }

    private static Node setupRequestMethodDropdown() {

        requestMethodDropdown.getItems().addAll("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD");
        requestMethodDropdown.setValue("GET");
        return requestMethodDropdown;
    }

    private static Node setupProtocolDropdown() {

        protocolDropdown.getItems().addAll("http://", "https://");
        protocolDropdown.setValue("http://");
        return protocolDropdown;
    }

    private static Node setupUrlInputTextField() {
        urlInputField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(urlInputField, Priority.ALWAYS);
        return urlInputField;
    }

    private static Node setupSendButton() {
        Button sendButton = new Button("Send");
        sendButton.setOnAction(event -> {
            HttpResponse<String> httpResponse = HttpRequestManager.sendRequest(urlInputField.getText(), requestMethodDropdown.getValue(), protocolDropdown.getValue());

            UiController.getHttpResponseConsumer().accept(httpResponse);

        });
        return sendButton;
    }
}
