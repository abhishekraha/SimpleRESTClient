package dev.abhishekraha.containers.components;

import dev.abhishekraha.containers.templates.ContainerTemplate;
import dev.abhishekraha.containers.util.AspectRatioUtil;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class RequestResponseContainer {
    private static final HBox requestResponseContainer = ContainerTemplate.newHorizontalContainer();

    // This contains the Request/Response containers vertically
    private static final VBox verticalContainer1 = ContainerTemplate.newVerticalContainer();

    // this contains the history
    private static final VBox verticalContainer2 = ContainerTemplate.newVerticalContainer();

    private static final TextArea responseHeaderBox = new TextArea();
    private static final TextArea responseBodyBox = new TextArea();
    private static final TextArea historyBox = new TextArea();

    private RequestResponseContainer() {
    }

    public static HBox getContainer() {

        verticalContainer1.getChildren().add(setupResponseHeaderBox());
        verticalContainer1.getChildren().add(setupResponseBodyBox());

        verticalContainer2.getChildren().add(setupHistoryBox());

        AspectRatioUtil.setContainerAspectRatio(verticalContainer1, 0.6);
        AspectRatioUtil.setContainerAspectRatio(verticalContainer2, 0.4);

        requestResponseContainer.getChildren().add(verticalContainer1);
        requestResponseContainer.getChildren().add(verticalContainer2);

        return requestResponseContainer;
    }

    private static Node setupResponseHeaderBox() {
        responseHeaderBox.setEditable(false);
        HBox.setHgrow(responseHeaderBox, Priority.ALWAYS);
        VBox.setVgrow(responseHeaderBox, Priority.ALWAYS);
        return responseHeaderBox;
    }

    private static Node setupResponseBodyBox() {
        responseBodyBox.setEditable(false);
        HBox.setHgrow(responseBodyBox, Priority.ALWAYS);
        VBox.setVgrow(responseBodyBox, Priority.ALWAYS);
        return responseBodyBox;
    }

    private static Node setupHistoryBox() {
        historyBox.setEditable(false);
        HBox.setHgrow(historyBox, Priority.ALWAYS);
        VBox.setVgrow(historyBox, Priority.ALWAYS);
        return historyBox;
    }

    public static TextArea getResponseHeaderBox() {
        return responseHeaderBox;
    }

    public static TextArea getResponseBodyBox() {
        return responseBodyBox;
    }

    public static TextArea getHistoryBox() {
        return historyBox;
    }

}
