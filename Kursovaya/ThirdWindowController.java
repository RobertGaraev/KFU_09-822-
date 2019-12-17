package Kursovaya;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ThirdWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button open_table;

    @FXML
    private Button open_graph;

    @FXML
    private Button go_back;

    @FXML
    private Button Choose_File;

    @FXML
    private Button Add_File;

    @FXML
    private Label choose_file_comentariy;

    @FXML
    private TextField url_file;

    @FXML
    private Label add_file_comentariy;

    @FXML
    void Open_Graph(ActionEvent event) {
        openWindow("/Kursovaya/Graph.fxml");
    }

    @FXML
    void Open_Table(ActionEvent event) throws IOException, SQLException {
        openWindow("/Kursovaya/Table.fxml");
    }

    @FXML
    void user_change(ActionEvent event) {
        go_back.getScene().getWindow().hide();
        openWindow("/Kursovaya/FirstWindow.fxml");
    }

    @FXML
    void add_file(ActionEvent event) throws IOException,ParseException,SQLException {
        if(!url_file.getText().equals("")){
            String urlStr = url_file.getText();
            try {
                URL url = new URL(urlStr);
                String fileName = urlStr.substring(urlStr.lastIndexOf('/')+1);
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                FileOutputStream fos = new FileOutputStream("C:\\Users\\Админ\\Downloads\\"+fileName);
                fos.getChannel().transferFrom(rbc,0,Long.MAX_VALUE);
                fos.close();
                rbc.close();
                add_file_comentariy.setText("Загурзка завершена");
                DBconnection.addtotableBD("C:\\Users\\Админ\\Downloads\\"+fileName);
            } catch (MalformedURLException e) {
                add_file_comentariy.setText("Некорректная ссылка");
            } catch (IOException e) {
                add_file_comentariy.setText("Не удалось загрузить файл");
            }
        }
        else add_file_comentariy.setText("ссылка не вставлена");
    }

    @FXML
    void choose_file(ActionEvent event) throws IOException, SQLException {
        Stage stage = (Stage) Choose_File.getScene().getWindow();
        FileChooser chooser = new FileChooser();
        List<File> list = chooser.showOpenMultipleDialog(stage);
        if(list==null) choose_file_comentariy.setText("файл не выбран");
        else {
            choose_file_comentariy.setText("файл выбран");
            if(!list.isEmpty()){
                for (File file: list) {
                    DBconnection.addtotableBD(file.getAbsolutePath());
                }
            }
        }
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