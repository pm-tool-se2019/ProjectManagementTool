package main.java.UI;

import main.java.DataClass.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.ScheduleMan.ScheduleManage;
import main.java.ScheduleMan.firebase4j.firebasesrc.error.FirebaseException;

import java.awt.*;
import java.io.UnsupportedEncodingException;
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
        try {
            ScheduleManage.fetchAllFromDB();
        } catch (FirebaseException e){
            //
        }
        catch (UnsupportedEncodingException e){
            //
        }
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
        //scrollAnchor.getChildren().add(new taskButton());//testMethod
        System.out.print(ScheduleManage.current_user_task_list.size());
        for(int i =0;i< ScheduleManage.current_user_task_list.size();i++){
            Task temp = ScheduleManage.current_user_task_list.get(i);
            System.out.println(calDate.getText() + calMonth.getText()+ calYear.getText());
            //if(temp.getStartDay()==Integer.parseInt(calDate.getText())&& temp.getStartMonth()==Integer.parseInt(calMonth.getText())&&temp.getStartYear() == Integer.parseInt(calYear.getText())){
            if(temp.getStartDay()==10 && temp.getStartYear()==2019 && temp.getStartMonth() == 6){
                taskButton tb = new taskButton();
                //public void setText(String Name, String startDate, String endDate, String description)
                tb.setText(temp.getTaskName(),temp.getStartYear()+"."+temp.getStartMonth()+"."+temp.getStartDay(),temp.getEndYear()+"."+temp.getEndMonth()+"."+temp.getEndDay(),temp.getDescription());
                scrollAnchor.getChildren().add(tb);
            }
        }
    }
    public void setDate(String Year, String Month, String Date){//set title Date
        calYear.setText(Year);
        calMonth.setText(Month);
        calDate.setText("10");
    }

    private void getDate(){

    }




}
