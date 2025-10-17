package dev.abhishekraha.containers.util;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class AspectRatioUtil {
    public static void setContainerAspectRatio(Pane container, double percent) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double width = screenBounds.getWidth() * percent;
        double height = screenBounds.getHeight() * percent;

        container.setPrefSize(width, height);
        container.setStyle("-fx-padding: 10;");
    }
}
