package Kursovaya;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SecondWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane Winow1;

    @FXML
    private Label avtorLabel;

    @FXML
    private TextField Name;

    @FXML
    private TextField phone;

    @FXML
    private Button enterButton;

    @FXML
    private Label W2_error3;

    @FXML
    private TextField loginField;

    @FXML
    private TextField country;

    @FXML
    private TextField LastName;

    @FXML
    private PasswordField Password;

    @FXML
    private Button back;

    @FXML
    private Label W2_error1;

    @FXML
    private Label W2_error2;

    @FXML
    void Enter(ActionEvent event) throws SQLException, NullPointerException {
        W2_error1.setText("");
        W2_error2.setText("");
        W2_error3.setText("");
        if (loginField.getLength() == 0) W2_error1.setText("поле не может быть пустым");
        if (Password.getLength() == 0) W2_error2.setText("поле не может быть пустым");

        if (Password.getLength() != 0 && loginField.getLength() != 0) {
            if (DBconnection.proverka(loginField, Password,false))
                W2_error3.setText("введенный логин уже занят, пожалуйста введите другой ");
                //если же условие не выполняется то просходит добавление в БД введенной информации и открытие 3 окна
            else {
                DBconnection.Insert_new_information(Name, LastName, phone, country, loginField, Password);
                enterButton.getScene().getWindow().hide();
                openWindow("/Kursovaya/FirstWindow.fxml");
            }
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        openWindow("/Kursovaya/FirstWindow.fxml");
    }

    void openWindow(String File) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(File));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }


}




