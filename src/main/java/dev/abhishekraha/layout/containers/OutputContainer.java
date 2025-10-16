package dev.abhishekraha.layout.containers;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class OutputContainer {
    private static final HBox outputContainer = new HBox();
    private static final TextArea outputArea = new TextArea();

    private OutputContainer() {
        outputContainer.setSpacing(10);
        outputContainer.setPadding(new Insets(5));

        outputContainer.getChildren().add(addOutputArea());
    }

    public static HBox getContainer() {
        new OutputContainer();
        VBox.setVgrow(outputContainer, Priority.ALWAYS);
        return outputContainer;
    }

    private Node addOutputArea() {
        HBox.setHgrow(outputArea, Priority.ALWAYS);
        VBox.setVgrow(outputArea, Priority.ALWAYS);
        return outputArea;
    }

    public static TextArea getOutputArea() {
        return outputArea;
    }
}
