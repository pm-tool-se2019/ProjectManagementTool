package main.java.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

public class CalendarController implements Initializable {
    private ObservableList yearList= FXCollections.observableArrayList();
    private ObservableList monthList= FXCollections.observableArrayList();
    @FXML
    private ChoiceBox<Integer> calendarYearChoice, calendarMonthChoice;
    @FXML//button left, right
    private Button calendarLeftButton, calendarRightButton;
    @FXML//buttons of Main Calendar
    private Button calendarButton0_0, calendarButton0_1, calendarButton0_2, calendarButton0_3, calendarButton0_4, calendarButton0_5, calendarButton0_6, calendarButton1_0, calendarButton1_1, calendarButton1_2, calendarButton1_3, calendarButton1_4, calendarButton1_5, calendarButton1_6, calendarButton2_0, calendarButton2_1, calendarButton2_2, calendarButton2_3, calendarButton2_4, calendarButton2_5, calendarButton2_6, calendarButton3_0, calendarButton3_1, calendarButton3_2, calendarButton3_3, calendarButton3_4, calendarButton3_5, calendarButton3_6, calendarButton4_0, calendarButton4_1, calendarButton4_2, calendarButton4_3, calendarButton4_4, calendarButton4_5, calendarButton4_6, calendarButton5_0, calendarButton5_1, calendarButton5_2, calendarButton5_3, calendarButton5_4, calendarButton5_5, calendarButton5_6;
    @FXML
    private GridPane calendarGridPane;
    private Button[][] calButton = new Button[6][7];

    @Override
    public void initialize(URL location, ResourceBundle resources) {//initialize
        loadMonthChoice();
        loadYearChoice();
        setCalendarButtonListener();
        setCalendarDate();
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
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private void setCalendarButtonListener(){
        setCalendarButtonArray();
        for(int i=0;i<5;i++) {
            for(int j=0;j<6;j++) {
                calButton[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        calendarButtonClicked(event);
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
    private void setCalendarDate(){

    }
    private void calendarButtonClicked(ActionEvent event){//button action
        System.out.println("hey");
    }
    private Button getGridButton(int row, int cal){
        return calButton[row][cal];
    }
    @FXML
    private void calendarLeftButtonClicked(){

    }
    @FXML
    private void calendarRightButtonClicked(){

    }
    private void getCalenarButtonNumber(){

    }
}
