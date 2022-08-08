package com.misiontic.informes;

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

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Informe2Controller implements Initializable {

    @FXML
    private TableView Info2Table;
    @FXML
    private TableColumn Info2ID;
    @FXML
    private TableColumn Info2Constructora;
    @FXML
    private TableColumn Info2NoHabitaciones;
    @FXML
    private TableColumn Info2Ciudad;


    ObservableList<Informe2Model> informe2List = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection con = SQLITECon.getConnection();
            Statement stmt;
            ResultSet rs;
            String consulta = "SELECT ID_Proyecto, Constructora, CAST(Numero_Habitaciones AS int) AS Numero_Habitaciones, Ciudad " +
                    "FROM Proyecto WHERE Clasificacion = \"Casa Campestre\" " +
                    "AND Ciudad = \"Santa Marta\" " +
                    "OR Ciudad = \"Cartagena\" " +
                    "OR Ciudad = \"Barranquilla\";";

            stmt = con.createStatement();
            rs = stmt.executeQuery(consulta);
            while(rs.next()){
                informe2List.add(new Informe2Model(rs.getInt("ID_Proyecto"), rs.getString("Constructora"),
                        rs.getInt("Numero_Habitaciones"), rs.getString("Ciudad") ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        Info2ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Info2Constructora.setCellValueFactory(new PropertyValueFactory<>("constructora"));
        Info2NoHabitaciones.setCellValueFactory(new PropertyValueFactory<>("noHabitaciones"));
        Info2Ciudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));

        Info2Table.setItems(informe2List);


    }

    public void closeInfo(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }


}
