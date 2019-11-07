package Lab7;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Zad3 extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        ObservableList<String> who = FXCollections.observableArrayList("Кузнечик","Вася","Крокодил","Орел","Трактор","Боинг 747","Слоник");
        ComboBox<String> CBox1 = new ComboBox<String>(who);
        CBox1.setValue("Кузнечик"); // устанавливаем выбранный элемент по умолчанию

        ObservableList<String> what = FXCollections.observableArrayList(" ушел"," полетел"," побежал"," залез"," уполз"," упрыгал"," умчался");
        ComboBox<String> CBox2 = new ComboBox<String>(what);
        CBox2.setValue(" ушел");

        ObservableList<String> where = FXCollections.observableArrayList(" в кусты"," на дискотеку"," домой"," за пивом"," на Чукотку"," по грибы"," на охоту");
        ComboBox<String> CBox3 = new ComboBox<String>(where);
        CBox3.setValue(" в кусты");

        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(25);
        textArea.setPrefRowCount(10);

        HBox HBox1=new HBox(10,CBox1,CBox2,CBox3);

        Button add_frazu=new Button("добавит фразу");
        add_frazu.setOnAction(new EventHandler<ActionEvent>() {
                                     @Override
                                     public void handle(ActionEvent actionEvent) {
                                         String Who=CBox1.getValue();
                                         String What=CBox2.getValue();
                                         String Where=CBox3.getValue();
                                         textArea.appendText(Who+What+Where+"\n");
                                     }
                                 }
        );

        Button close=new Button("закрыть");
        close.setOnAction(event -> stage.close());

        VBox for_knopok=new VBox(10,add_frazu,close);
        for_knopok.setFillWidth(true);
        add_frazu.setMinWidth(100);
        close.setMinWidth(100);
        for_knopok.setAlignment(Pos.BOTTOM_LEFT);

        HBox HBox2=new HBox(5,textArea,for_knopok);
        HBox2.setAlignment(Pos.BOTTOM_LEFT);

        VBox VBox= new VBox(10,HBox1,HBox2);

        Scene scene = new Scene(VBox ,420,220);
        stage.setScene(scene);
        stage.setTitle("электронный писатель");
        stage.show();
    }
}

