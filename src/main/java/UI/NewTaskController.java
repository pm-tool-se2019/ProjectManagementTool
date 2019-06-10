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

import java.io.UnsupportedEncodingException;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
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
    private ChoiceBox<String> stateBox;
    @FXML
    private ChoiceBox<Integer> hierarchyBox;
    @FXML
    private TextField taskName;
    @FXML
    private TextArea Descriptions;
    @FXML
    private DatePicker startDate, endDate;

    // For temporary variable of state, hierarchy
    private String state_data;
    private Integer hier_data;

    private Stage stage;
    //implements components, Controller of Main Scene Initial State
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStageDragable();
        componentInit();

        addButton.setOnAction(event -> {
            try {
                addButtonClicked();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FirebaseException e) {
                e.printStackTrace();
            }
        });
        cancelButton.setOnAction(event -> cancelButtonClicked());
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

    // initiation
    private void componentInit(){
        ObservableList statelist = FXCollections.observableArrayList();
        ObservableList hielist = FXCollections.observableArrayList();

        //stateBox initialize
        statelist.removeAll();
        statelist.addAll("TODO","DOING","DONE");
        stateBox.getItems().addAll(statelist);
        stateBox.setValue("TODO");
        state_data = "TODO";
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
        hierarchyBox.setValue(5);
        hier_data = 5;
        hierarchyBox.getSelectionModel()
                    .selectedItemProperty()
                    .addListener(new ChangeListener<Integer>() {
                        @Override
                        public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                            hier_data = newValue;
                        }
                    });

        addButton = new Button();
        cancelButton = new Button();

    }

    // Used in NewTaskController and TaskInfoController.
    public static int makeId(){
        Random generator = new Random();
        int tempid;
        while(true){
            tempid = generator.nextInt(1000000)+1;
            if(ScheduleManage.searchFromTaskList(tempid) != null){
                continue;
            }
            break;
        }
        return tempid;
    }


    public void addButtonClicked() throws UnsupportedEncodingException, FirebaseException {
        String task_name = taskName.getText();
        String task_desc = Descriptions.getText();
        LocalDate startDate_ld = startDate.getValue();
        LocalDate endDate_ld = endDate.getValue();


        Integer id = makeId();

        Task t = new Task(id, task_name, task_desc, startDate_ld.getYear(),startDate_ld.getMonthValue(), startDate_ld.getDayOfMonth(),
                endDate_ld.getYear(),endDate_ld.getMonthValue(),endDate_ld.getDayOfMonth(),state_data,hier_data);
        ScheduleManage.addTask(t);

        this.stage.close();
    }

}