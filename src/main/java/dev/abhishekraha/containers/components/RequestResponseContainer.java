package dev.abhishekraha.containers.components;

import dev.abhishekraha.containers.templates.ContainerTemplate;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class RequestResponseContainer {
    private final HBox requestResponseContainer;

    private final TextArea historyBox;
    private final TextArea responseHeaderBox;
    private final TextArea responseBodyBox;

    private final VBox verticalContainer1;
    private final VBox verticalContainer2;


    public RequestResponseContainer() {

        historyBox = new TextArea();
        responseHeaderBox = new TextArea();
        responseBodyBox = new TextArea();
        requestResponseContainer = ContainerTemplate.newHorizontalContainer();
        verticalContainer1 = ContainerTemplate.newVerticalContainer();
        verticalContainer2 = ContainerTemplate.newVerticalContainer();

    }

    public HBox getContainer() {

        verticalContainer1.getChildren().add(setupResponseHeaderBox());
        verticalContainer1.getChildren().add(setupResponseBodyBox());

        verticalContainer2.getChildren().add(setupHistoryBox());

//        AspectRatioUtil.setContainerAspectRatio(verticalContainer1, 0.6);
//        AspectRatioUtil.setContainerAspectRatio(verticalContainer2, 0.4);

        requestResponseContainer.getChildren().add(verticalContainer1);
//        requestResponseContainer.getChildren().add(verticalContainer2);

        return requestResponseContainer;
    }

    private Node setupResponseHeaderBox() {
        responseHeaderBox.setEditable(false);
        HBox.setHgrow(responseHeaderBox, Priority.ALWAYS);
        VBox.setVgrow(responseHeaderBox, Priority.ALWAYS);
        return responseHeaderBox;
    }

    private Node setupResponseBodyBox() {
        responseBodyBox.setEditable(false);
        HBox.setHgrow(responseBodyBox, Priority.ALWAYS);
        VBox.setVgrow(responseBodyBox, Priority.ALWAYS);
        return responseBodyBox;
    }

    private Node setupHistoryBox() {
        historyBox.setEditable(false);
        HBox.setHgrow(historyBox, Priority.ALWAYS);
        VBox.setVgrow(historyBox, Priority.ALWAYS);
        return historyBox;
    }

    public TextArea getResponseHeaderBox() {
        return responseHeaderBox;
    }

    public TextArea getResponseBodyBox() {
        return responseBodyBox;
    }

    public TextArea getHistoryBox() {
        return historyBox;
    }

}
