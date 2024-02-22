package com.example.javatest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TodoApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button closeButton = new Button("Fechar");
        closeButton.setOnAction(event -> stage.close());

        FXMLLoader fxmlLoader = new FXMLLoader(TodoApp.class.getResource("todo-list-view.fxml"));
        VBox root = fxmlLoader.load();

        root.getChildren().add(closeButton);

        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root, 400, 600);

        URL cssResource = getClass().getResource("styles.css");
        if (cssResource != null) {
            scene.getStylesheets().add(cssResource.toExternalForm());
        } else {
            System.err.println("Arquivo CSS não encontrado!");
        }

        stage.setScene(scene);
        stage.setTitle("Todo List App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
