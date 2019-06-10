package main.java.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.DataClass.Task;
import main.java.ScheduleMan.ScheduleManage;
import main.java.ScheduleMan.firebase4j.firebasesrc.error.FirebaseException;
import sun.security.krb5.internal.crypto.Des;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static main.java.UI.taskButton.selected_task_name;

public class TaskInfoController implements Initializable {
    public Parent root;
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private AnchorPane parent;
    @FXML
    private Button taskInfoEditBtn, taskInfoCloseBtn, taskInfoDeleteBtn;
    @FXML
    private TextField taskName;
    @FXML
    private TextArea Descriptions;
    @FXML
    private DatePicker startDate, endDate;
    @FXML
    private ChoiceBox<String> stateBox;
    @FXML
    private ChoiceBox<Integer> hierarchyBox;

    private String state_data;
    private Integer hier_data;
    private Task selected_task;

    private Stage stage;
    public void initialize(URL location, ResourceBundle resources) {

        makeStageDragable();
        componentInit();

        taskInfoEditBtn.setOnAction(event -> {
            try {
                editButtonClicked();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FirebaseException e) {
                e.printStackTrace();
            }
        });
        taskInfoCloseBtn.setOnAction(event -> cancelButtonClicked());

        taskInfoDeleteBtn.setOnAction(event -> {
            try {
                deleteButtonClicked();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FirebaseException e) {
                e.printStackTrace();
            }
        });

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

    @FXML
    private void editButtonClicked() throws UnsupportedEncodingException, FirebaseException {//add Button Click
        String task_name = taskName.getText();
        String task_desc = Descriptions.getText();
        LocalDate startDate_ld = startDate.getValue();
        LocalDate endDate_ld = endDate.getValue();

        ScheduleManage.updateTask(selected_task.getId(), NewTaskController.makeId(), task_name, task_desc, startDate_ld.getYear(),startDate_ld.getMonthValue(), startDate_ld.getDayOfMonth(),
                endDate_ld.getYear(),endDate_ld.getMonthValue(),endDate_ld.getDayOfMonth(),state_data,hier_data);

        this.stage.close();

    }

    public void exitButtonClicked(){
        stage.close();
    }

    public void deleteButtonClicked() throws UnsupportedEncodingException, FirebaseException {
        ScheduleManage.deleteTask(selected_task);
        this.stage.close();
    }

    private void componentInit(){
        ObservableList statelist = FXCollections.observableArrayList();
        ObservableList hielist = FXCollections.observableArrayList();

        selected_task = getTask(selected_task_name);
        taskName.setText(selected_task.getTaskName());
        Descriptions.setText(selected_task.getDescription());


        //stateBox initialize
        statelist.removeAll();
        statelist.addAll("TODO","DOING","DONE");
        stateBox.getItems().addAll(statelist);
        stateBox.setValue(selected_task.getState());
        state_data = selected_task.getState();   // DATA HERE
        stateBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        // For Test
                        state_data = newValue;
                    }
                });

        // hierarchyBox initialize
        hielist.removeAll();
        hielist.addAll(1,2,3,4,5,6,7,8,9,10);
        hierarchyBox.getItems().addAll(hielist);
        hierarchyBox.setValue(selected_task.getHierarchy());
        hier_data = selected_task.getHierarchy();  // DATA HERE
        hierarchyBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Integer>() {
                    @Override
                    public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                        hier_data = newValue;
                    }
                });

        taskInfoEditBtn = new Button();
        taskInfoCloseBtn = new Button();
        taskInfoDeleteBtn = new Button();

    }

    private Task getTask(String name_of_task){
        for(Task t: ScheduleManage.current_user_task_list){
            if(t.getTaskName().equals(name_of_task)){
                return t;
            }
        }
        System.out.println("Fail to find Task from getTask method.");
        return null; // Exceptioon.
    }
}
