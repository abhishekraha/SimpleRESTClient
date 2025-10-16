package dev.abhishekraha.layout;

import dev.abhishekraha.layout.containers.InputContainer;
import dev.abhishekraha.layout.containers.OutputContainer;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class RootContainer {

    public VBox createLayout() {
        VBox rootContainer = new VBox();

        rootContainer.getChildren().add(InputContainer.getContainer());
        rootContainer.getChildren().add(OutputContainer.getContainer());

        // Get screen dimensions
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double width = screenBounds.getWidth() * 0.6;
        double height = screenBounds.getHeight() * 0.6;

        rootContainer.setPrefSize(width, height);
        rootContainer.setStyle("-fx-padding: 10;");

        return rootContainer;
    }
}
