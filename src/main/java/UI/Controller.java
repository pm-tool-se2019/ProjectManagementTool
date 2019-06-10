package main.java.UI;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.event.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.ScheduleMan.ScheduleManage;

public class Controller implements Initializable {
    //Model


    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private AnchorPane parent;
    @FXML
    private Pane mainScene;
    @FXML
    private Button addNew, exitButton, dashboardButton, calendarButton, teamButton, demoButton ;
    @FXML
    private HBox sideBtnDashboard, sideBtnTeam, sideBtnCalendar;
    //implements components, Controller of Main Scene Initial State
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDragable();
        if(isDashboardFirst==0){
        changeBackgroundOnHoverUsingEvents(sideBtnDashboard);
        }else{
            sideBtnDashboard.setStyle("-fx-background-color: #00336a");
        }
        if(isCalendarFirst==0) {
            changeBackgroundOnHoverUsingEvents(sideBtnCalendar);
        }else{
            sideBtnCalendar.setStyle("-fx-background-color: #00336a");
        }
        if(isTeamFirst==0) {
            changeBackgroundOnHoverUsingEvents(sideBtnTeam);
        }else {
            sideBtnDashboard.setStyle("-fx-background-color: #00336a");
        }
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
    private void setSideBtnInit(){
        sideBtnDashboard.setStyle("-fx-background-color: #1385ff");
        sideBtnCalendar.setStyle("-fx-background-color: #1385ff");
        sideBtnTeam.setStyle("-fx-background-color: #1385ff");
    }

    private void setButtonStateInit(){
        isTeamFirst=0;
        isCalendarFirst=0;
        isDashboardFirst=0;
    }
    private int isDashboardFirst = 0;
    @FXML
    private void showDashboard() throws IOException {//Dashboard Button Clicked
        if(isDashboardFirst ==0) {
            setSideBtnInit();
            sideBtnDashboard.setStyle("-fx-background-color: #00336a");
            loadScene("Dashboard");
            setButtonStateInit();
            isDashboardFirst++;
            return;
        }else{
            mainScene.getChildren().clear();
            isDashboardFirst--;
        }
    }
    private int isCalendarFirst = 0;
    @FXML
    private void showCalendar() throws IOException{//Calendar Button Clicked
        if(isCalendarFirst==0) {
            setSideBtnInit();
            sideBtnCalendar.setStyle("-fx-background-color: #00336a");
            loadScene("Calendar");
            setButtonStateInit();
            isCalendarFirst++;
            return;
        }else{
                mainScene.getChildren().clear();
                isCalendarFirst--;
            }

    }

    private int isTeamFirst = 0;
    @FXML
    private void showTeam()throws IOException{//Team Button Clicked
        if(isTeamFirst==0) {
            setSideBtnInit();
            sideBtnTeam.setStyle("-fx-background-color: #00336a");
            loadScene("Team");
            setButtonStateInit();
            isTeamFirst++;
            return;
        }
        else{
            mainScene.getChildren().clear();
            isTeamFirst--;
        }
    }
    private void loadScene(String UI) throws IOException {//Main Stage Main Scene Loading Function
        Parent prt;
        prt = FXMLLoader.load(getClass().getResource(UI + ".fxml"));
        mainScene.getChildren().setAll(prt);
    }

    public void changeBackgroundOnHoverUsingEvents(final HBox node) {//Can't use .css on side buttons. So... meh another method of css :hover
        node.setStyle("-fx-background-color: #1385ff");
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                node.setStyle("-fx-background-color: #00336a");
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                node.setStyle("-fx-background-color: #1385ff");
            }
        });
    }
    @FXML
    private void demoButtonClicked(){

    }



}
