package Kursovaya;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

//    @Override
//    public void start(final Stage primaryStage) {
//
//        Button button = new Button();
//        button.setText("Open a New Window");
//
//        button.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//
//                Label secondLabel = new Label("I'm a Label on new Window");
//
//                StackPane secondaryLayout = new StackPane();
//                secondaryLayout.getChildren().add(secondLabel);
//
//                Scene secondScene = new Scene(secondaryLayout, 450, 250);
//
//                // New window (Stage)
//                Stage newWindow = new Stage();
//                newWindow.setTitle("Second Stage");
//                newWindow.setScene(secondScene);
//
//                // Specifies the modality for new window.
//                newWindow.initModality(Modality.WINDOW_MODAL);
//
//                // Specifies the owner Window (parent) for new window
//                newWindow.initOwner(primaryStage);
//
//                // Set position of second window, related to primary window.
//                newWindow.setX(primaryStage.getX());
//                newWindow.setY(primaryStage.getY());
//
//                newWindow.show();
//            }
//        });
//
//        StackPane root = new StackPane();
//        root.getChildren().add(button);
//
//        Scene scene = new Scene(root, 450, 250);
//
//        primaryStage.setTitle("JavaFX Open a new Window (o7planning.org)");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }

    static Parent root;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        root = FXMLLoader.load(getClass().getResource("FirstWindow.fxml"));

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

}