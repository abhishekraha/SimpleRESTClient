package dev.abhishekraha.containers.templates;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ContainerTemplate {
    public static HBox newHorizontalContainer() {
        HBox container = new HBox();
        container.setSpacing(10);
        container.setPadding(new Insets(5));
        HBox.setHgrow(container, Priority.ALWAYS);
        VBox.setVgrow(container, Priority.ALWAYS);
        return container;
    }

    public static VBox newVerticalContainer() {
        VBox container = new VBox();
        container.setSpacing(10);
        container.setPadding(new Insets(5));
        HBox.setHgrow(container, Priority.ALWAYS);
        VBox.setVgrow(container, Priority.ALWAYS);
        return container;
    }
}
