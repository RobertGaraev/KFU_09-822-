package Kursovaya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController {
    ObservableList<Type> data = FXCollections.observableArrayList();
    String user_name = FirstWindowController.FirstName();
    static Connection conection;
    static Statement stmt;
    static String tabl;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Type> table;

    @FXML
    private TableColumn<Type, String> date_id;

    @FXML
    private TableColumn<Type, Double> open_id;

    @FXML
    private TableColumn<Type, Double> hide_id;

    @FXML
    private TableColumn<Type, Double> low_id;

    @FXML
    private TableColumn<Type, Double> close_id;

    @FXML
    private TableColumn<Type, String> currency_id;

    @FXML
    void initialize() throws IOException, SQLException {
        setData();
        date_id.setCellValueFactory(new PropertyValueFactory<Type, String>("first_column"));
        open_id.setCellValueFactory(new PropertyValueFactory<Type, Double>("second_column"));
        hide_id.setCellValueFactory(new PropertyValueFactory<Type, Double>("third_column"));
        low_id.setCellValueFactory(new PropertyValueFactory<Type, Double>("fourth_column"));
        close_id.setCellValueFactory(new PropertyValueFactory<Type, Double>("fifth_column"));
        currency_id.setCellValueFactory(new PropertyValueFactory<Type, String>("sixth_column"));
        table.setItems(data);
    }

    void setData() throws IOException, SQLException {
        conection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kursach", "postgres", "flatron147");
        stmt = conection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM tablee");
        while (resultSet.next()) {
            String check_user = resultSet.getString(7);
            if (check_user.equals(user_name)) {
                String a = resultSet.getString(1);
                String f = resultSet.getString(6);
                double b = resultSet.getDouble(2);
                double c = resultSet.getDouble(3);
                double d = resultSet.getDouble(4);
                double e = resultSet.getDouble(5);
                data.add(new Type(a, b, c, d, e, f));
            }
        }
    }
}
