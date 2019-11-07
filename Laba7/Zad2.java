package Lab7;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Zad2 extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {


        Image image = new Image(new FileInputStream("C:\\Users\\Админ\\IdeaProjects\\Laba7\\src\\Lab7\\Zad2.png"));

        ImageView imageView = new ImageView(image);



        Label label1= new Label("координаты точки на плоскости");
        Label label2 = new Label("X= ");
        Label label3 = new Label("Y= ");
        Label label4 = new Label();
        label4.setFont(Font.font("Calibri", 20));
        TextField X= new TextField();
        X.setMaxWidth(40);
        X.getPrefColumnCount();
        TextField Y= new TextField();
        Y.setMaxWidth(40);


        HBox HBox1=new HBox(label1);
        HBox1.setAlignment(Pos.TOP_CENTER);

        HBox HBox2=new HBox(label2,X);
        HBox2.setAlignment(Pos.TOP_CENTER);

        HBox HBox3= new HBox(label3,Y);
        HBox3.setAlignment(Pos.TOP_CENTER);


        VBox VBox=new VBox(20,HBox1,HBox2,HBox3);


        Button vichislitBtn=new Button("вычислить");
        vichislitBtn.setMinHeight(50);
        vichislitBtn.setMinWidth(100);
        vichislitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double x=Double.valueOf(X.getText());
                double y=Double.valueOf(Y.getText());
                if (x>=-3 && x<0 && y>=0 && y<=(2*x+6)){
                    label4.setText("Точка (" + x + "; " + y + ") лежит в этой области");
                    label4.setTextFill(Color.BLUE);
                }
                else if (x>=0 && x<=2 && y<=Math.sqrt(36-x*x) && y>=-Math.sqrt(36-x*x)){
                    label4.setText("Точка (" + x + "; " + y + ") лежит в этой области");
                    label4.setTextFill(Color.BLUE);
                }
                else {
                    label4.setText("Точка (" + x + "; " + y + ") не попала в эту область");
                    label4.setTextFill(Color.RED);
                }
            }
            }
        );

        HBox Knopka=new HBox();
        Knopka.setAlignment(Pos.TOP_CENTER);
        Knopka.getChildren().add(vichislitBtn);
        VBox.getChildren().add(Knopka);

        HBox j=new HBox(20,imageView,VBox);

        VBox k=new VBox(20,j,label4);
        k.setAlignment(Pos.TOP_CENTER);


        Scene scene = new Scene(k,400,250);
        stage.setScene(scene);
        stage.setTitle("Попадание в область");
        stage.show();
    }
}

