package dev.abhishekraha.containers.components;

import dev.abhishekraha.containers.templates.ContainerTemplate;
import dev.abhishekraha.controller.ui.UiController;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ResetFieldsContainer {
    private final Button resetButton;
    private final HBox resetFieldsContainer;
    private final UiController uiController;

    public ResetFieldsContainer(UiController uiController) {
        this.uiController = uiController;

        resetFieldsContainer = ContainerTemplate.newHorizontalContainer();
        resetButton = new Button("Reset");
    }

    public HBox getContainer() {
        resetFieldsContainer.setAlignment(Pos.BOTTOM_RIGHT);
        resetFieldsContainer.getChildren().add(setupResetButton());
        return resetFieldsContainer;
    }

    private Node setupResetButton() {
        resetButton.setOnAction(event -> uiController.resetAllFields());
        return resetButton;
    }

}
