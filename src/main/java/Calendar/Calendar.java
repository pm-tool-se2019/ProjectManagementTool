package Calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import DataClass.Task;

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

class CalendarDataManager{
    final private int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
}

class MyCalendar {
    static final int CAL_WIDTH = 7;
    static final int CAL_HEIGHT = 6;

    private Date[][] calendar_dates = new Date[CAL_HEIGHT][CAL_WIDTH];
    private Calendar calendar;
    private ArrayList<Task> task_list;


    //Constructor Of Calendar class
    //Take task_list and make calendar
    MyCalendar(ArrayList<Task> task_list){
        this.task_list = task_list;
    }

    //Default Constructor.
    //List of taks will be empty arraylist<Task>
    MyCalendar(){
        this.task_list = new ArrayList<Task>();
    }




}