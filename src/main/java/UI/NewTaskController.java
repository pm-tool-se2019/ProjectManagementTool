package main.java.UI;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewTaskController implements Initializable {

    public Parent rootAdd;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private AnchorPane parent;
    @FXML
    private Button addButton, cancelButton;

    //implements components, Controller of Main Scene Initial State
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDragable();
    }
    //set AddNew components Draggable
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
                Controller.addStage.setX(event.getScreenX() - xOffset);
                Controller.addStage.setY(event.getScreenY() - yOffset);
                Controller.addStage.setOpacity(0.7f);
            }
        });
        parent.setOnDragDone((e) -> {
            Controller.addStage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((e) -> {
            Controller.addStage.setOpacity(1.0f);
        });

    }
    //addNew stage shutdown
    public void cancelButtonClicked(){
        Controller.addStage.close();
        Controller.addStage = new Stage();
    }
}
