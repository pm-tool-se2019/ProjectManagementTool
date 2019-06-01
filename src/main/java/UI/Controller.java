package main.java.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.event.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private AnchorPane parent;
    @FXML
    private Button addNew, exitButton;

    //implements components, Controller of Main Scene Initial State
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDragable();
    }
    //set Main Components Draggable
    private void makeStageDragable() {
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Main.stage.setX(event.getScreenX() - xOffset);
                Main.stage.setY(event.getScreenY() - yOffset);
                Main.stage.setOpacity(0.7f);
            }
        });
        parent.setOnDragDone((e) -> {
            Main.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((e) -> {
            Main.stage.setOpacity(1.0f);
        });

    }

    //Main stage shut down
    public void exitButtonClicked(){
        Main.stage.close();
    }

    //Adding New Task Button Function, New static field Stage Required
    public static Stage addStage = new Stage();
    public void addNewClicked() throws IOException{
        Parent rootAdd = FXMLLoader.load(getClass().getResource("NewTask.fxml"));
        Scene sceneAdd = new Scene(rootAdd);
        addStage.setScene(sceneAdd);
        addStage.initStyle(StageStyle.UNDECORATED);
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.showAndWait();//disable Main stage, Only One Popup available. because of static field stage
    }
}
