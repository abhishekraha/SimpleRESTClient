package dev.abhishekraha.containers.components;

import dev.abhishekraha.containers.templates.ContainerTemplate;
import dev.abhishekraha.controller.ui.UiController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ResetFieldsContainer {
    private static final HBox resetFieldsContainer = ContainerTemplate.newHorizontalContainer();
    private static final Button resetButton = new Button("Reset");

    private ResetFieldsContainer() {
    }

    public static HBox getContainer() {
        resetFieldsContainer.setAlignment(Pos.BOTTOM_RIGHT);
        resetFieldsContainer.getChildren().add(setupResetButton());
        return resetFieldsContainer;
    }

    private static Node setupResetButton() {
        resetButton.setOnAction(event -> {
            UiController.resetAllTextFields();
        });
        return resetButton;
    }

}
