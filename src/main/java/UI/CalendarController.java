package main.java.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.Calendar;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import main.java.Calendar.*;

public class CalendarController implements Initializable {
    //Singleton pattern 자바 ㅣㅅㅇ글톤
    private static MyCalendar calendar = MyCalendar.getSingleCalendar();

    private ObservableList yearList= FXCollections.observableArrayList();
    private ObservableList monthList= FXCollections.observableArrayList();
    @FXML//button left, right    @FXML
    private ChoiceBox<Integer> calendarYearChoice, calendarMonthChoice;

    private Button calendarLeftButton, calendarRightButton;
    @FXML//buttons of Main Calendar
    private Button calendarButton0_0, calendarButton0_1, calendarButton0_2, calendarButton0_3, calendarButton0_4, calendarButton0_5, calendarButton0_6, calendarButton1_0, calendarButton1_1, calendarButton1_2, calendarButton1_3, calendarButton1_4, calendarButton1_5, calendarButton1_6, calendarButton2_0, calendarButton2_1, calendarButton2_2, calendarButton2_3, calendarButton2_4, calendarButton2_5, calendarButton2_6, calendarButton3_0, calendarButton3_1, calendarButton3_2, calendarButton3_3, calendarButton3_4, calendarButton3_5, calendarButton3_6, calendarButton4_0, calendarButton4_1, calendarButton4_2, calendarButton4_3, calendarButton4_4, calendarButton4_5, calendarButton4_6, calendarButton5_0, calendarButton5_1, calendarButton5_2, calendarButton5_3, calendarButton5_4, calendarButton5_5, calendarButton5_6;
    private Button[][] calendarButtonArr = new Button[6][7];
    private void buttonAssign(){
        calendarButtonArr[0][0]= calendarButton0_0;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {//initialize
        loadMonthChoice();
        loadYearChoice();
    }
    private void loadYearChoice(){//initialize method
        yearList.removeAll(yearList);
        for(int i=1901;i<=2050; i++){
            yearList.add(i);
        }
        calendarYearChoice.getItems().addAll(yearList);
        calendarYearChoice.setValue(2019);
        calendarYearChoice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                getYearValue(newValue);
            }
        });
    }
    private void loadMonthChoice(){//initialize method
        monthList.removeAll(monthList);
        monthList.addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        calendarMonthChoice.getItems().addAll(monthList);
        calendarMonthChoice.setValue(6);
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

    @FXML
    private void calendarLeftButtonClicked(){

    }
    @FXML
    private void calendarRightButtonClicked(){

    }
    private void calendarButtonClicked(){

    }
    private void getCalenarButtonNumber(){

    }
}
