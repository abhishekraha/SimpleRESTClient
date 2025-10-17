package dev.abhishekraha.containers;

import dev.abhishekraha.containers.components.InputContainer;
import dev.abhishekraha.containers.components.RequestResponseContainer;
import dev.abhishekraha.containers.components.ResetFieldsContainer;
import dev.abhishekraha.containers.util.AspectRatioUtil;
import dev.abhishekraha.controller.ui.UiController;
import javafx.scene.layout.VBox;

public class RootContainer {

    private final InputContainer inputContainer;
    private final RequestResponseContainer requestResponseContainer;
    private final ResetFieldsContainer resetFieldsContainer;
    private final VBox rootContainer;

    public RootContainer(UiController uiController) {
        inputContainer = new InputContainer(uiController.getHttpResponseConsumer());
        requestResponseContainer = new RequestResponseContainer();
        resetFieldsContainer = new ResetFieldsContainer(uiController);
        rootContainer = new VBox();

        uiController.getInputContainerConsumer().accept(inputContainer);
        uiController.getRequestResponseContainerConsumer().accept(requestResponseContainer);
    }

    public VBox createLayout() {

        rootContainer.getChildren().add(inputContainer.getContainer());
        rootContainer.getChildren().add(requestResponseContainer.getContainer());
        rootContainer.getChildren().add(resetFieldsContainer.getContainer());

        AspectRatioUtil.setContainerAspectRatio(rootContainer, 0.6);

        return rootContainer;
    }
}
