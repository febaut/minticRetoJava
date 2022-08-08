package com.misiontic.informes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class InformesApp extends Application {
    AtomicReference<Double> yOffset = new AtomicReference<>((double) 0); AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InformesApp.class.getResource("InformesView.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 190, 409);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("R5 Informes App");
        root.setOnMousePressed(event -> {
            yOffset.set(stage.getY() - event.getScreenY());
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset.get());
            stage.setY(event.getScreenY() + yOffset.get());
        });

        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}