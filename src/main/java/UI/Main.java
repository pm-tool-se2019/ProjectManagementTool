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
    private Stage stage =null;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent main = (Parent)fxmlLoader.load();
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        ResizeHelper.addResizeListener(stage);
        this.stage = stage;
        ((Controller) fxmlLoader.getController()).setStage(stage);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}