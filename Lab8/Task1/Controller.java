package Lab8.Task1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    AnchorPane Pane;

    @FXML
    void click() {
        Canvas canvas = new Canvas(350,350); // создаем новый объект Canvas с шириной 300px, и высотой 275px

        GraphicsContext context = canvas.getGraphicsContext2D(); // и получаем GraphicContext
        byte k=(byte)(Math.random()*6+1);
        int x= (int) (Math.random() * 350);
        int y= (int) (Math.random() * 350);
        int wh=0;
        if (x>y) wh= (int) (Math.random() * (350 - x));
        else wh= (int) (Math.random() * (350 - y));
        switch (k){
            case (1):{
                context.setFill(Color.BLUE); // устанавливаем цвет
                context.fillOval(x, y, wh, wh); // рисуем овал с левым верхним углом в точке (x;y) и высотой = ширине = wh px
                break;
            }
            case (2):{
                context.setFill(Color.BLUE);
                context.strokeOval(x, y, wh, wh);
                break;
            }
            case (3):{
                context.setFill(Color.RED);
                context.fillRect(x, y, wh, wh);// рисуем прямоугльник wh x wh px с левым верним углом в точке (x;y)
                break;
            }
            case (4):{
                context.setFill(Color.RED);
                context.strokeRect(x, y, wh, wh);// рисуем полый прямоугльник wh x wh px с левым верним углом в точке (x;y)
                break;
            }
            case (5):{
                int x2= (int) (Math.random() * 350);int x3= (int) (Math.random() * 350);
                int y2= (int) (Math.random() * 350);int y3= (int) (Math.random() * 350);
                context.setFill(Color.GREEN);
                context.fillPolygon(new double[]{x,x2,x3}, new double[]{y,y2,y3}, 3);// рисуем треугольник с вершинами X:(x,x2,x3) Y:(y,y2,y3)
                break;
            }
            case (6):{
                int x2= (int) (Math.random() * 350);int x3= (int) (Math.random() * 350);
                int y2= (int) (Math.random() * 350);int y3= (int) (Math.random() * 350);
                context.setFill(Color.GREEN);
                context.strokePolygon(new double[]{x,x2,x3}, new double[]{y,y2,y3}, 3);
                break;
            }
            case (7):{
                int x2= (int) (Math.random() * 350);int y2= (int) (Math.random() * 350);
                context.setFill(Color.BLACK);
                context.fillRect(x, y, x2, y2);
                break;
            }
        }
        Pane.getChildren().add(canvas);
    }

}
