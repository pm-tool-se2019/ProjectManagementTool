package main.java.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import main.java.Calendar.*;

public class CalendarController implements Initializable {
    //Singleton pattern
    private static MyCalendar calendar;

    private ObservableList yearList= FXCollections.observableArrayList();
    private ObservableList monthList= FXCollections.observableArrayList();

    @FXML//button left, right    @FXML
    private ChoiceBox<Integer> calendarYearChoice, calendarMonthChoice;

    private Button calendarLeftButton, calendarRightButton;
    @FXML//buttons of Main Calendar
    private Button calendarButton0_0, calendarButton0_1, calendarButton0_2, calendarButton0_3, calendarButton0_4, calendarButton0_5, calendarButton0_6, calendarButton1_0, calendarButton1_1, calendarButton1_2, calendarButton1_3, calendarButton1_4, calendarButton1_5, calendarButton1_6, calendarButton2_0, calendarButton2_1, calendarButton2_2, calendarButton2_3, calendarButton2_4, calendarButton2_5, calendarButton2_6, calendarButton3_0, calendarButton3_1, calendarButton3_2, calendarButton3_3, calendarButton3_4, calendarButton3_5, calendarButton3_6, calendarButton4_0, calendarButton4_1, calendarButton4_2, calendarButton4_3, calendarButton4_4, calendarButton4_5, calendarButton4_6, calendarButton5_0, calendarButton5_1, calendarButton5_2, calendarButton5_3, calendarButton5_4, calendarButton5_5, calendarButton5_6;

    @FXML
    private Text btnText0_0,btnText0_1,btnText0_2,btnText0_3,btnText0_4,btnText0_5,btnText0_6,btnText1_0,btnText1_1,btnText1_2, btnText1_3,btnText1_4,btnText1_5,btnText1_6,btnText2_0,btnText2_1, btnText2_2, btnText2_3, btnText2_4, btnText2_5, btnText2_6, btnText3_0, btnText3_1, btnText3_2, btnText3_3, btnText3_4, btnText3_5, btnText3_6, btnText4_0, btnText4_1, btnText4_2, btnText4_3, btnText4_4, btnText4_5, btnText4_6, btnText5_0, btnText5_1, btnText5_2, btnText5_3, btnText5_4, btnText5_5, btnText5_6;
    @FXML
    private HBox btnBg0_0,btnBg0_1,btnBg0_2,btnBg0_3, btnBg0_4, btnBg0_5, btnBg0_6,btnBg1_0, btnBg1_1, btnBg1_2, btnBg1_3, btnBg1_4, btnBg1_5, btnBg1_6, btnBg2_0, btnBg2_1, btnBg2_2, btnBg2_3, btnBg2_4, btnBg2_5, btnBg2_6, btnBg3_0, btnBg3_1, btnBg3_2, btnBg3_3, btnBg3_4, btnBg3_5, btnBg3_6, btnBg4_0, btnBg4_1, btnBg4_2, btnBg4_3, btnBg4_4, btnBg4_5, btnBg4_6, btnBg5_0, btnBg5_1, btnBg5_2, btnBg5_3, btnBg5_4, btnBg5_5, btnBg5_6;

    private GridPane calendarGridPane;
    private Button[][] calButton = new Button[6][7];
    private HBox[][] calButtonBg = new HBox[6][7];
    private Text[][] calButtonText = new Text[6][7];

    @Override
    public void initialize(URL location, ResourceBundle resources) {//initialize
        calendar = MyCalendar.getSingleCalendar();
        loadMonthChoice(calendar.getNowMonthValue());
        loadYearChoice(calendar.getNowYear());
        setCalendarButtonListener();
        setCalendarDate();
    }
    private void loadYearChoice(int initializeYear){//initialize method
        yearList.removeAll(yearList);
        for(int i=1901;i<=2050; i++){
            yearList.add(i);
        }
        calendarYearChoice.getItems().addAll(yearList);
        calendarYearChoice.setValue(initializeYear);
        calendarYearChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                getYearValue(newValue);
            }
        });
    }
    private void loadMonthChoice(int initializeMonth){//initialize method
        monthList.removeAll(monthList);
        monthList.addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        calendarMonthChoice.getItems().addAll(monthList);
        calendarMonthChoice.setValue(initializeMonth);
        calendarMonthChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                getMonthValue(newValue);
            }
        });
    }
    private void getYearValue(Number val){//test Method
        int i=(int)val+1901;
        System.out.println(i);
    }

    private void getMonthValue(Number val){//test Method
        int i=(int)val+1;
        System.out.println(i);
    }
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private void setCalendarButtonListener() {
        setCalendarButtonArray();
        setCalendaraButtonTextArray();
        setCalendarButtonBackgroundArray();
        for(int i=0;i<5;i++) {
            for(int j=0;j<6;j++) {
                calButton[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            calendarButtonClicked(event);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private void setCalendarButtonArray(){
        calButton[0][0] = calendarButton0_0;
        calButton[0][1] = calendarButton0_1;
        calButton[0][2] = calendarButton0_2;
        calButton[0][3] = calendarButton0_3;
        calButton[0][4] = calendarButton0_4;
        calButton[0][5] = calendarButton0_5;
        calButton[0][6] = calendarButton0_6;
        calButton[1][0] = calendarButton1_0;
        calButton[1][1] = calendarButton1_1;
        calButton[1][2] = calendarButton1_2;
        calButton[1][3] = calendarButton1_3;
        calButton[1][4] = calendarButton1_4;
        calButton[1][5] = calendarButton1_5;
        calButton[1][6] = calendarButton1_6;
        calButton[2][0] = calendarButton2_0;
        calButton[2][1] = calendarButton2_1;
        calButton[2][2] = calendarButton2_2;
        calButton[2][3] = calendarButton2_3;
        calButton[2][4] = calendarButton2_4;
        calButton[2][5] = calendarButton2_5;
        calButton[2][6] = calendarButton2_6;
        calButton[3][0] = calendarButton3_0;
        calButton[3][1] = calendarButton3_1;
        calButton[3][2] = calendarButton3_2;
        calButton[3][3] = calendarButton3_3;
        calButton[3][4] = calendarButton3_4;
        calButton[3][5] = calendarButton3_5;
        calButton[3][6] = calendarButton3_6;
        calButton[4][0] = calendarButton4_0;
        calButton[4][1] = calendarButton4_1;
        calButton[4][2] = calendarButton4_2;
        calButton[4][3] = calendarButton4_3;
        calButton[4][4] = calendarButton4_4;
        calButton[4][5] = calendarButton4_5;
        calButton[4][6] = calendarButton4_6;
        calButton[5][0] = calendarButton5_0;
        calButton[5][1] = calendarButton5_1;
        calButton[5][2] = calendarButton5_2;
        calButton[5][3] = calendarButton5_3;
        calButton[5][4] = calendarButton5_4;
        calButton[5][5] = calendarButton5_5;
        calButton[5][6] = calendarButton5_6;
    }
    private void setCalendarButtonBackgroundArray(){
        calButtonText[0][0] = btnText0_0;
        calButtonText[0][1] = btnText0_1;
        calButtonText[0][2] = btnText0_2;
        calButtonText[0][3] = btnText0_3;
        calButtonText[0][4] = btnText0_4;
        calButtonText[0][5] = btnText0_5;
        calButtonText[0][6] = btnText0_6;
        calButtonText[1][0] = btnText1_0;
        calButtonText[1][1] = btnText1_1;
        calButtonText[1][2] = btnText1_2;
        calButtonText[1][3] = btnText1_3;
        calButtonText[1][4] = btnText1_4;
        calButtonText[1][5] = btnText1_5;
        calButtonText[1][6] = btnText1_6;
        calButtonText[2][0] = btnText2_0;
        calButtonText[2][1] = btnText2_1;
        calButtonText[2][2] = btnText2_2;
        calButtonText[2][3] = btnText2_3;
        calButtonText[2][4] = btnText2_4;
        calButtonText[2][5] = btnText2_5;
        calButtonText[2][6] = btnText2_6;
        calButtonText[3][0] = btnText3_0;
        calButtonText[3][1] = btnText3_1;
        calButtonText[3][2] = btnText3_2;
        calButtonText[3][3] = btnText3_3;
        calButtonText[3][4] = btnText3_4;
        calButtonText[3][5] = btnText3_5;
        calButtonText[3][6] = btnText3_6;
        calButtonText[4][0] = btnText4_0;
        calButtonText[4][1] = btnText4_1;
        calButtonText[4][2] = btnText4_2;
        calButtonText[4][3] = btnText4_3;
        calButtonText[4][4] = btnText4_4;
        calButtonText[4][5] = btnText4_5;
        calButtonText[4][6] = btnText4_6;
        calButtonText[5][0] = btnText5_0;
        calButtonText[5][1] = btnText5_1;
        calButtonText[5][2] = btnText5_2;
        calButtonText[5][3] = btnText5_3;
        calButtonText[5][4] = btnText5_4;
        calButtonText[5][5] = btnText5_5;
        calButtonText[5][6] = btnText5_6;
    }
    private void setCalendaraButtonTextArray(){
        calButtonBg[0][0] = btnBg0_0;
        calButtonBg[0][1] = btnBg0_1;
        calButtonBg[0][2] = btnBg0_2;
        calButtonBg[0][3] = btnBg0_3;
        calButtonBg[0][4] = btnBg0_4;
        calButtonBg[0][5] = btnBg0_5;
        calButtonBg[0][6] = btnBg0_6;
        calButtonBg[1][0] = btnBg1_0;
        calButtonBg[1][1] = btnBg1_1;
        calButtonBg[1][2] = btnBg1_2;
        calButtonBg[1][3] = btnBg1_3;
        calButtonBg[1][4] = btnBg1_4;
        calButtonBg[1][5] = btnBg1_5;
        calButtonBg[1][6] = btnBg1_6;
        calButtonBg[2][0] = btnBg2_0;
        calButtonBg[2][1] = btnBg2_1;
        calButtonBg[2][2] = btnBg2_2;
        calButtonBg[2][3] = btnBg2_3;
        calButtonBg[2][4] = btnBg2_4;
        calButtonBg[2][5] = btnBg2_5;
        calButtonBg[2][6] = btnBg2_6;
        calButtonBg[3][0] = btnBg3_0;
        calButtonBg[3][1] = btnBg3_1;
        calButtonBg[3][2] = btnBg3_2;
        calButtonBg[3][3] = btnBg3_3;
        calButtonBg[3][4] = btnBg3_4;
        calButtonBg[3][5] = btnBg3_5;
        calButtonBg[3][6] = btnBg3_6;
        calButtonBg[4][0] = btnBg4_0;
        calButtonBg[4][1] = btnBg4_1;
        calButtonBg[4][2] = btnBg4_2;
        calButtonBg[4][3] = btnBg4_3;
        calButtonBg[4][4] = btnBg4_4;
        calButtonBg[4][5] = btnBg4_5;
        calButtonBg[4][6] = btnBg4_6;
        calButtonBg[5][0] = btnBg5_0;
        calButtonBg[5][1] = btnBg5_1;
        calButtonBg[5][2] = btnBg5_2;
        calButtonBg[5][3] = btnBg5_3;
        calButtonBg[5][4] = btnBg5_4;
        calButtonBg[5][5] = btnBg5_5;
        calButtonBg[5][6] = btnBg5_6;
    }
    private void setCalendarDate(){

    }
    //Adding New Task Button Function, New static field Stage Required
    private Stage dateInfo = new Stage();
    //stage's initial state cannot be initialized twice, this is state check
    private int isStageFirst=0;
    private void calendarButtonClicked(ActionEvent event) throws IOException {//button action
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CalednarDate.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Scene sceneAdd = new Scene(root);
        ((CalendarDateController) fxmlLoader.getController()).setStage(dateInfo);
        dateInfo.setScene(sceneAdd);
        if(isStageFirst==0) {//state check
            dateInfo.initStyle(StageStyle.UNDECORATED);
            dateInfo.initModality(Modality.APPLICATION_MODAL);
            isStageFirst++;
        }//if end
        dateInfo.showAndWait();//disable Main stage, Only One Popup available. because of static field stage

    }
    private Button getGridButton(int row, int cal){
        return calButton[row][cal];
    }
    @FXML
    private void calendarLeftButtonClicked(){
        int now_year, now_month,now_day=1;
        LocalDate currentDate;
        now_year = calendarYearChoice.getValue();
        now_month = calendarMonthChoice.getValue();
        
        currentDate = LocalDate.of(now_year,now_month,now_day);
        currentDate = currentDate.minusMonths((long)1);

        now_year = currentDate.getYear();
        now_month = currentDate.getMonthValue();

        calendarYearChoice.setValue(now_year);
        calendarMonthChoice.setValue(now_month);
    }
    @FXML
    private void calendarRightButtonClicked(){

    }
    private void getCalenarButtonNumber(){

    }
}
