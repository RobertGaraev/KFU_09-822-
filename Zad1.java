package Lab7;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class Zad1 extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Label label1= new Label("Введите коэффициенты");
        Label label2 = new Label("X^2 + ");
        Label label3=new Label("X + ");
        Label label4=new Label("= 0");
        TextField a= new TextField();
        a.setMaxWidth(40);
        a.getPrefColumnCount();
        TextField b= new TextField();
        b.setMaxWidth(40);
        TextField c= new TextField();
        c.setMaxWidth(40);


        HBox HBox1=new HBox(label1);
        HBox1.setAlignment(Pos.CENTER);

        HBox HBox2=new HBox(a,label2,b,label3,c,label4);

        Label discreminant=new Label();
        Label koren=new Label();
        VBox VBox=new VBox(20,HBox1,HBox2,discreminant,koren);


        Button vichislitBtn=new Button("вычислить");
        vichislitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double A=Double.valueOf(a.getText());
                double B=Double.valueOf(b.getText());
                double C=Double.valueOf(c.getText());
                if (A==0){
                 discreminant.setText("Решается не квадратное а линейное уравнение");
                    String x = String.format("%.5f", -C/B);
                 koren.setText("корень уравнения: x="+x);
                }
                else{
                    double D=B*B-4*A*C;
                    discreminant.setText("D="+ D);
                    if (D>=0){
                        String x1= String.format("%.2f", (-B-Math.sqrt(D))/(2*A));
                        String x2 = String.format("%.2f", (-B+Math.sqrt(D))/(2*A));
                    koren.setText("корни уравнения: х1="+x1+"и х2="+x2);
                }
                    else {
                        D=D*(-1);
                        String deystvitelnoe=String.format("%.2f", (-B/(2*A)));
                        String mnimoe=String.format("%.2f", (Math.sqrt(D)/(2*A)));
                        koren.setText("корни уравнения: x1="+deystvitelnoe+"+"+mnimoe+"i и х2="+deystvitelnoe+"-"+mnimoe+"i");
                    }
                }
            }
        });

        HBox Knopka=new HBox();
        Knopka.setAlignment(Pos.TOP_CENTER);
        Knopka.getChildren().add(vichislitBtn);
        VBox.getChildren().add(Knopka);

        Scene scene = new Scene(VBox,400,200);
        stage.setScene(scene);
        stage.setTitle("Решение квадратного уравнения");
        stage.show();
    }
}
