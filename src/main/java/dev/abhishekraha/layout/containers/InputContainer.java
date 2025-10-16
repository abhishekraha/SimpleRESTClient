package dev.abhishekraha.layout.containers;

import dev.abhishekraha.network.HttpRequestManager;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class InputContainer {
    private static final HBox inputContainer = new HBox();

    private final ComboBox<String> requestMethodDropdown = new ComboBox<>();
    private final ComboBox<String> protocolDropdown = new ComboBox<>();
    private final TextField urlInputField = new TextField();

    private InputContainer() {
        inputContainer.setSpacing(10);
        inputContainer.setPadding(new Insets(5));

        inputContainer.getChildren().add(addUrlLabel());
        inputContainer.getChildren().add(addRequestMethodDropdown());
        inputContainer.getChildren().add(addProtocolDropdown());
        inputContainer.getChildren().add(addUrlInputTextField());
        inputContainer.getChildren().add(addSendButton());
    }

    public static HBox getContainer() {
        new InputContainer();
        return inputContainer;
    }

    private Node addUrlLabel() {
        return new Label("Enter URL:");
    }

    private Node addRequestMethodDropdown() {

        requestMethodDropdown.getItems().addAll("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS", "HEAD");
        requestMethodDropdown.setValue("GET");
        return requestMethodDropdown;
    }

    private Node addProtocolDropdown() {

        protocolDropdown.getItems().addAll("http://", "https://");
        protocolDropdown.setValue("http://");
        return protocolDropdown;
    }

    private Node addUrlInputTextField() {
        urlInputField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(urlInputField, Priority.ALWAYS);
        return urlInputField;
    }

    private Node addSendButton() {
        Button sendButton = new Button("Send");
        sendButton.setOnAction(event -> {
            String httpResponseText = HttpRequestManager.sendRequest(urlInputField.getText(), requestMethodDropdown.getValue(), protocolDropdown.getValue());

            OutputContainer.getOutputArea().setText(httpResponseText);
        });
        return sendButton;
    }
}
