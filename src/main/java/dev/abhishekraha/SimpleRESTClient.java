package dev.abhishekraha;


import dev.abhishekraha.containers.RootContainer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleRESTClient extends Application {
    @Override
    public void start(Stage stage) {
        RootContainer rootContainer = new RootContainer();

        VBox root = rootContainer.createLayout();

        // Scene and stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("SimpleRESTClient");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
