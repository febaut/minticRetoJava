package com.misiontic.informes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.concurrent.atomic.AtomicReference;

public class InformesController {

    @FXML
    protected void closeFunction() {
    System.exit(0);
    }

    public void informe1button() {
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0); AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Informe1.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            root1.setOnMousePressed(event -> {
                yOffset.set(stage.getY() - event.getScreenY());
            });
            root1.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() + xOffset.get());
                stage.setY(event.getScreenY() + yOffset.get());
            });
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void informe2button() {
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0); AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Informe2.fxml"));
            Parent root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            root2.setOnMousePressed(event -> {
                yOffset.set(stage.getY() - event.getScreenY());
            });
            root2.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() + xOffset.get());
                stage.setY(event.getScreenY() + yOffset.get());
            });
            stage.setScene(new Scene(root2));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void informe3button() {
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0); AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Informe3.fxml"));
            Parent root3 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            root3.setOnMousePressed(event -> {
                yOffset.set(stage.getY() - event.getScreenY());
            });
            root3.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() + xOffset.get());
                stage.setY(event.getScreenY() + yOffset.get());
            });
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




}

