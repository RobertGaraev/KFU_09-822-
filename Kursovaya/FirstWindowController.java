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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FirstWindowController {
    //имя вошедшего пользователя
    private static String Name_loading_users;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane Winow1;

    @FXML
    private Label avtorLabel;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button enterButton;

    @FXML
    private Button regButton;

    @FXML
    private Label error1, error2, error3;


//    //пробелы игнорируются
//    String loginText=loginField.getText().trim();
//    String passwordText=passwordField.getText().trim();
//    // проверка на пустоту
//    loginText.equals("")

    @FXML
    void Enter(ActionEvent event) throws SQLException {
        //открывает 3 окно
        error1.setText("");
        error2.setText("");
        error3.setText("");
        if (loginField.getLength() == 0) error1.setText("поле пустое");
        if (passwordField.getLength() == 0) error2.setText("поле пустое");

        if (passwordField.getLength() != 0 && loginField.getLength() != 0) {
            //проверка на совпадение пароля и логина с базой данных
            if (DBconnection.proverka(loginField, passwordField,true)) {
                Name_loading_users=loginField.getText();
                enterButton.getScene().getWindow().hide();
                openWindow("/Kursovaya/ThirdWindow.fxml");
            } else error3.setText("данные введены неверно");
        }
    }

    @FXML
    void registration(ActionEvent event) {
        regButton.getScene().getWindow().hide();
        openWindow("/Kursovaya/SecondWindow.fxml");
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

    //метод для запоминания логина вошедшего пользователя
    static String FirstName(){
       return Name_loading_users;
    }
}