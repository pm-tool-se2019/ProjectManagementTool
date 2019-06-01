package main.java.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;

//application main
public class Main extends Application {
    //main stage call
    public static Stage stage = null;

    //public static Stage newStage =null;
    @Override
    public void start(Stage stage) throws Exception {
        Parent main = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        this.stage = stage;
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}