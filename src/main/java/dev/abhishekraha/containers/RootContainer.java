package dev.abhishekraha.containers;

import dev.abhishekraha.containers.components.InputContainer;
import dev.abhishekraha.containers.components.RequestResponseContainer;
import dev.abhishekraha.containers.util.AspectRatioUtil;
import javafx.scene.layout.VBox;

public class RootContainer {

    public VBox createLayout() {
        VBox rootContainer = new VBox();

        rootContainer.getChildren().add(InputContainer.getContainer());
        rootContainer.getChildren().add(RequestResponseContainer.getContainer());

        AspectRatioUtil.setContainerAspectRatio(rootContainer, 0.6);

        return rootContainer;
    }
}
