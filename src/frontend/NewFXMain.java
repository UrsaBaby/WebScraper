package frontend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Peter
 */
public class NewFXMain extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) {

        Button button = new Button();
        button.setText("Klicka för INSTANT personlighetstest");
        button.setOnAction(this);

   
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        scene1 = new Scene(layout, 700, 500);
       
        window = primaryStage;
         primaryStage.setFullScreen(true);
        primaryStage.setTitle("PERSONLIGHETSTEST 2000");
        window.setScene(scene1);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(new Label("Du är världens bästa och finaste!!! /SLARFF"));
        window.getScene().setRoot(layout2);
       
     
        
    }

}
