package com.misiontic.informes;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Informe1Controller implements Initializable {

    @FXML
    private TableView Info1Table;
    @FXML
    private TableColumn Info1ID;
    @FXML
    private TableColumn Info1Nombre;
    @FXML
    private TableColumn Info1Apellido;
    @FXML
    private TableColumn Info1Ciudad;


    ObservableList<Informe1Model> informeList = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection con = SQLITECon.getConnection();
            Statement stmt;
            ResultSet rs;
            String consulta = "SELECT ID_LIDER, Nombre, Primer_Apellido, Ciudad_Residencia " +
                              "FROM Lider " +
                              "ORDER BY Ciudad_Residencia ASC;";

            stmt = con.createStatement();
            rs = stmt.executeQuery(consulta);
            while(rs.next()){
              informeList.add(new Informe1Model(rs.getInt("ID_Lider"), rs.getString("Nombre"),
                      rs.getString("Primer_Apellido"), rs.getString("Ciudad_Residencia") ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        Info1ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Info1Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        Info1Apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        Info1Ciudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));

        Info1Table.setItems(informeList);


    }

    public void closeInfo(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }


}
