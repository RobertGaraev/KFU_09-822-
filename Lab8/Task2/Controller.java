package Lab8.Task2;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    TabPane MainPane;

    //работа с треугольником

    @FXML
    AnchorPane Pane1;

    @FXML
    TextField x1,x2,x3,y1,y2,y3;

    @FXML
    CheckBox b1;

    int k1=0;
    @FXML
    void click1() {
        double X1=Double.valueOf(x1.getText());
        double X2=Double.valueOf(x2.getText());
        double X3=Double.valueOf(x3.getText());
        double Y1=Double.valueOf(y1.getText());
        double Y2=Double.valueOf(y2.getText());
        double Y3=Double.valueOf(y3.getText());
        Canvas canvas = new Canvas(400,400);
        GraphicsContext context = canvas.getGraphicsContext2D();
                context.setFill(Color.BLACK);
                if (b1.isSelected()) context.fillPolygon(new double[]{X1,X2,X3},new double[]{Y1,Y2,Y3},3);
                else context.strokePolygon(new double[]{X1,X2,X3},new double[]{Y1,Y2,Y3},3);
                if(k1!=0)Pane1.getChildren().remove(Pane1.getChildren().size()-1);
                Pane1.getChildren().add(canvas);
                k1++;

    }

    // работа с прямоугольником
    @FXML
    TextField x4,y4,w1,h1;

    @FXML
    CheckBox b2;

    @FXML
    AnchorPane Pane2;

    int k2=0;
    @FXML
    void click2(){
        double x=Double.valueOf(x4.getText());
        double y=Double.valueOf(y4.getText());
        double w=Double.valueOf(w1.getText());
        double h=Double.valueOf(h1.getText());
        Canvas canvas = new Canvas(400,400);
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(Color.BLACK);
        if (b2.isSelected())context.fillRect(x-w/2, y-h/2, w, h);
        else context.strokeRect(x-w/2, y-h/2, w, h);
        if(k2!=0)Pane2.getChildren().remove(Pane2.getChildren().size()-1);
        Pane2.getChildren().add(canvas);
        k2++;
    }

    //работа с эллипсом
    @FXML
    TextField x5,y5,w2,h2;

    @FXML
    CheckBox b3;

    @FXML
    AnchorPane Pane3;

    int k3=0;
    @FXML
    void click3(){
        double x=Double.valueOf(x5.getText());
        double y=Double.valueOf(y5.getText());
        double w=Double.valueOf(w2.getText());
        double h=Double.valueOf(h2.getText());
        Canvas canvas = new Canvas(400,400);
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(Color.BLACK);
        if (b3.isSelected())context.fillOval(x-w/2, y-h/2, w, h);
        else context.strokeOval(x-w/2, y-h/2, w, h);
        if(k3!=0)Pane3.getChildren().remove(Pane3.getChildren().size()-1);
        Pane3.getChildren().add(canvas);
        k3++;
    }

    //работа с линией
    @FXML
    TextField x6,x7,y6,y7;

    @FXML
    AnchorPane Pane4;

    int k4=0;
    @FXML
    void click4(){
        double x1=Double.valueOf(x6.getText());
        double y1=Double.valueOf(y6.getText());
        double x2=Double.valueOf(x7.getText());
        double y2=Double.valueOf(y7.getText());
        Canvas canvas = new Canvas(400,400);
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(Color.BLACK);
        context.strokeLine(x1,y1,x2,y2);
        if(k4!=0)Pane4.getChildren().remove(Pane4.getChildren().size()-1);
        Pane4.getChildren().add(canvas);
        k4++;
    }
}
