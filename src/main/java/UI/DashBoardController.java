package main.java.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.DataClass.Task;
import main.java.ScheduleMan.ScheduleManage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {


    @FXML
    VBox personalRecentTask, prjRecentTask;
    @FXML
    VBox timeline;
    @FXML
    ProgressIndicator personalProgression, projectProgression;

    Double doubleValueOfPersonalProgress= Double.valueOf(0), doubleValueOfProjectProgress=Double.valueOf(0);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.getChildren().clear();
        setTimeline();
        setPersonalRecentTask();
        setProjectRecentTask();
        setPersonalProgression();
        setProjectProgression();
    }
    //Adding New Task Button Function, New static field Stage Required
    private Stage addStage = new Stage();
    //stage's initial state cannot be initialized twice, this is state check
    private int isStageFirst =0;
    @FXML
private void testButtonClicked() throws IOException {//testMethod
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TaskInfo.fxml"));
    Parent rootAdd = (Parent)fxmlLoader.load();
    Scene sceneAdd = new Scene(rootAdd);
    ((TaskInfoController) fxmlLoader.getController()).setStage(addStage);
    addStage.setScene(sceneAdd);
    if(isStageFirst==0) {//state check
        addStage.initStyle(StageStyle.UNDECORATED);
        addStage.initModality(Modality.APPLICATION_MODAL);
        isStageFirst++;
    }//if end
    addStage.showAndWait();//disable Main stage, Only One Popup available. because of static field stage
}

    private void setTimeline() {//currently test
        //timeline.getChildren().add(new taskButton());
        for (int i = 0; i < ScheduleManage.current_user_task_list.size(); i++) {
            Task temp = ScheduleManage.current_user_task_list.get(i);
            taskButton tb = new taskButton();

            //public void setText(String Name, String startDate, String endDate, String description)
            tb.setText(temp.getTaskName(), temp.getStartYear() + "." + temp.getStartMonth() + "." + temp.getStartDay(), temp.getEndYear() + "." + temp.getEndMonth() + "." + temp.getEndDay(), temp.getDescription());
            //if(temp.getDescription().equals(tb.getDesc())){continue;}
            timeline.getChildren().add(tb);
        }
    }
    private void setProjectRecentTask(){//get recent three tasks of project
        prjRecentTask.getChildren().clear();
        for (int i = 0; i < ScheduleManage.current_user_task_list.size(); i++) {
            if(i>0) continue;
            Task temp = ScheduleManage.current_user_task_list.get(i);
            taskButton tb = new taskButton();

            //public void setText(String Name, String startDate, String endDate, String description)
            tb.setText(temp.getTaskName(), temp.getStartYear() + "." + temp.getStartMonth() + "." + temp.getStartDay(), temp.getEndYear() + "." + temp.getEndMonth() + "." + temp.getEndDay(), temp.getDescription());
            //if(temp.getDescription().equals(tb.getDesc())){continue;}
            prjRecentTask.getChildren().add(tb);
        }
        setDoubleValueOfProjectProgress(0.25);
        //prjRecentTask.getChildren().add(new taskButton());
    }
    private void setPersonalRecentTask(){//get recent three tasks of personal task
        //personalRecentTask.getChildren().add(new taskButton());
        for (int i = 0; i < ScheduleManage.current_user_task_list.size(); i++) {
            if(i>0) continue;
            Task temp = ScheduleManage.current_user_task_list.get(i);
            taskButton tb = new taskButton();

            //public void setText(String Name, String startDate, String endDate, String description)
            tb.setText(temp.getTaskName(), temp.getStartYear() + "." + temp.getStartMonth() + "." + temp.getStartDay(), temp.getEndYear() + "." + temp.getEndMonth() + "." + temp.getEndDay(), temp.getDescription());
            //if(temp.getDescription().equals(tb.getDesc())){continue;}
            personalRecentTask.getChildren().add(tb);
        }
        setDoubleValueOfPersonalProgress(0.15);
    }
    private void setPersonalProgression(){
        if(doubleValueOfPersonalProgress==0){
            personalProgression.isIndeterminate();
            return;
        }
        personalProgression.setProgress(doubleValueOfPersonalProgress);
    }
    private void setProjectProgression(){
        if(doubleValueOfProjectProgress==0){
            projectProgression.isIndeterminate();
            return;
        }
        projectProgression.setProgress(doubleValueOfProjectProgress);
    }
    public void setDoubleValueOfPersonalProgress(double val){ this.doubleValueOfPersonalProgress = val;}//this value is 0~1, double
    public void setDoubleValueOfProjectProgress(double val){this.doubleValueOfProjectProgress = val;}

}
