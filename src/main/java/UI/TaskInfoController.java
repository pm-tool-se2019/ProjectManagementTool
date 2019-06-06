package main.java.UI;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskInfoController implements Initializable {
    public Parent root;
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private AnchorPane parent;
    private Stage stage;
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDragable();
    }

    //set stage, this function SHOULD be used in parent Class
    public void setStage(Stage stage){
        this.stage = stage;
    }
    //set components Draggable
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
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
                stage.setOpacity(0.7f);
            }
        });
        parent.setOnDragDone((e) -> {
            stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((e) -> {
            stage.setOpacity(1.0f);
        });

    }
    //stage shutdown
    public void cancelButtonClicked(){
        this.stage.close();
        this.stage=null;
    }
    public void exitButtonClicked(){
        stage.close();
    }


}
