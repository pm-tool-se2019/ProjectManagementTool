package main.java.UI;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.DataClass.Task;
import main.java.ScheduleMan.ScheduleManage;
import main.java.ScheduleMan.firebase4j.firebasesrc.error.FirebaseException;

import java.io.UnsupportedEncodingException;
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
    @FXML
    private TextField taskName;
    @FXML
    private TextArea Descriptions;
    @FXML
    private DatePicker startDate, endDate;
    private Stage stage;
    //implements components, Controller of Main Scene Initial State
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDragable();
    }

    //set stage, this function SHOULD be used in parent Class
    public void setStage(Stage stage){
        this.stage = stage;
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
    //addNew stage shutdown
    public void cancelButtonClicked(){
        this.stage.close();
        this.stage=null;
    }
    public void exitButtonClicked(){
        stage.close();
    }
    @FXML
    private void addButtonClicked(){//add Button Clicked
        //Task(int id, String task_name, String description, int start_year, int start_month, int start_day, int end_year, int end_month, int end_day, String state, int hierarchy)
        Task tt = new Task((int)Math.random()*1000, getTaskName().toString(),"TEST",2019,06,10,2019,06,11,"TODO",12);
        try {
            //ScheduleManage.addTask(ttt);
            ScheduleManage.addTask(tt);
        } catch(FirebaseException e){
            //
        } catch(UnsupportedEncodingException e){
            //
        }
        stage.close();
    }
    public CharSequence getTaskName(){//you can use .toString() if you want to get String format
        return taskName.getCharacters();
    }
    public String getStartDate(){
        return startDate.getValue().toString();
    }
    public String getEndDate(){
        return endDate.getValue().toString();
    }
    public ObservableList<CharSequence> getDescription(){//you can use .toString() if you want to get String format
        return Descriptions.getParagraphs();
    }
}
