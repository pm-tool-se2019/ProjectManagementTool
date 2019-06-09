package main.java.Calendar;
import main.java.DataClass.Task;

import java.util.ArrayList;

class Date{
    private int year;
    private int month;
    private int day;

    private ArrayList<Task> task_list;

    Date(){
        this.year = 1900;
        this.month = 1;
        this.day = 1;
        task_list = new ArrayList<Task>();
    }

    Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
        this.task_list = new ArrayList<Task>();
    }

    Date(int year, int month, int day, ArrayList<Task> task_list){
        this.year = year;
        this.month = month;
        this.day = day;
        this.task_list = task_list;
    }
}
