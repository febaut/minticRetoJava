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

public class Informe3Controller implements Initializable {

    @FXML
    private TableView Info3Table;
    @FXML
    private TableColumn Info3ID;
    @FXML
    private TableColumn Info3Constructora;
    @FXML
    private TableColumn Info3Banco;


    ObservableList<Informe3Model> informe3List = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection con = SQLITECon.getConnection();
            Statement stmt;
            ResultSet rs;
            String consulta = "SELECT c.ID_Compra, p.Constructora, p.Banco_Vinculado \n" +
                    "FROM Compra c\n" +
                    "JOIN Proyecto p \n" +
                    "ON c.ID_Proyecto = p.ID_Proyecto \n" +
                    "WHERE c.Proveedor = \"Homecenter\" AND p.Ciudad = \"Salento\";\n";

            stmt = con.createStatement();
            rs = stmt.executeQuery(consulta);
            while(rs.next()){
                informe3List.add(new Informe3Model(rs.getInt("ID_Compra"), rs.getString("Constructora"),
                        rs.getString("Banco_Vinculado") ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        Info3ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Info3Constructora.setCellValueFactory(new PropertyValueFactory<>("constructora"));
        Info3Banco.setCellValueFactory(new PropertyValueFactory<>("banco"));

        Info3Table.setItems(informe3List);


    }

    public void closeInfo(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }


}
