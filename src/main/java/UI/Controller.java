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
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private AnchorPane parent;
    @FXML
    private Pane mainScene;
    @FXML
    private Button addNew, exitButton, dashboardButton, calendarButton, teamButton ;
    //implements components, Controller of Main Scene Initial State
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDragable();
    }
    //set stage, this function SHOULD be used in parent Class
    public void setStage(Stage stage){
        this.stage = stage;
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

    //Main stage shut down
    public void exitButtonClicked(){
        stage.close();
    }

    //Adding New Task Button Function, New static field Stage Required
    private Stage addStage = new Stage();
    //stage's initial state cannot be initialized twice, this is state check
    private int isStageFirst=0;
    public void addNewClicked() throws IOException{
        //Parent rootAdd = FXMLLoader.load(getClass().getResource("NewTask.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewTask.fxml"));
        Parent rootAdd = (Parent)fxmlLoader.load();
        Scene sceneAdd = new Scene(rootAdd);
        ((NewTaskController) fxmlLoader.getController()).setStage(addStage);
        addStage.setScene(sceneAdd);
        if(isStageFirst==0) {//state check
            addStage.initStyle(StageStyle.UNDECORATED);
            addStage.initModality(Modality.APPLICATION_MODAL);
            isStageFirst++;
        }//if end
            addStage.showAndWait();//disable Main stage, Only One Popup available. because of static field stage

    }
    @FXML
    private void showDashboard() throws IOException{//Dashboard Button Clicked
        loadScene("Dashboard");
    }
    @FXML
    private void showCalendar()throws IOException{//Calendar Button Clicked
        loadScene("Calendar");
    }
    @FXML
    private void showTeam()throws IOException{//Team Button Clicked
        loadScene("Team");
    }
    private void loadScene(String UI) throws IOException {//Main Stage Main Scene Loading Function
        Parent prt;
        prt = FXMLLoader.load(getClass().getResource(UI + ".fxml"));
        mainScene.getChildren().setAll(prt);
    }


}
