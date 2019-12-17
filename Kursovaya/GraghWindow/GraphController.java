package Kursovaya;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

public class GraphController {
    String user_name = FirstWindowController.FirstName();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private ColorPicker trend_color;

    @FXML
    private DatePicker first_day;

    @FXML
    private DatePicker last_day;

    @FXML
    private Button graphik;

    @FXML
    private Button trend;

    @FXML
    private Label error_intervala, error_graph_type;

    @FXML
    private ComboBox<String> trend_type;
    ObservableList<String> list_trend = FXCollections.observableArrayList("Линейная", "Квадратичная", "Экспоненциальная", "Логарифмическая");

    @FXML
    private ColorPicker graph_color;

    @FXML
    private ComboBox<String> graph_type;
    ObservableList<String> list_graph = FXCollections.observableArrayList("Открытие", "Максимум", "Минимум", "Закрытие");

    @FXML
    void create_graphik(ActionEvent event) throws ParseException {
        int p=0;
        String gt = graph_type.getValue();
        switch (gt) {
            case ("Открытие"):
                p = 2;
                break;
            case ("Максимум"):
                p = 3;
                break;
            case ("Минимум"):
                p = 4;
                break;
            case ("Закрытие"):
                p = 5;
                break;
        }
        String year=first_day.getValue().toString();
        System.out.println(year);

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd").;
//        if(first_day.getChronology())


    }

    @FXML
    void create_trend(ActionEvent event) {

    }

    @FXML
    void initialize() throws SQLException {
        graph_type.setItems(list_graph);
        trend_type.setItems(list_trend);
    }
}
