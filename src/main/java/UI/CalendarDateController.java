package main.java.UI;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CalendarDateController implements Initializable{
    public Parent root;
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private AnchorPane parent, scrollAnchor;
    @FXML
    private ScrollPane list;
    @FXML
    private Text calYear, calMonth, calDate;

    private Stage stage;
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDragable();
        setTaskList();;
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

    private void setTaskList(){//initialize
        scrollAnchor.getChildren().add(new taskButton());//testMethod
    }
    public void setDate(String Year, String Month, String Date){//set title Date
        calYear.setText(Year);
        calMonth.setText(Month);
        calDate.setText("10");
    }

    private void getDate(){

    }




}
