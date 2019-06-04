package main.java.Calendar;

import java.time.DayOfWeek;
import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import main.java.DataClass.Task;

class CalendarDataManager{
    final private int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
}

public class MyCalendar {
    static final int CAL_WIDTH = 7;
    static final int CAL_HEIGHT = 6;

    //Singleton Pattern
    private static MyCalendar singleCalendar;

    //Information of calendar
    private Date[][] calendar_dates = new Date[CAL_HEIGHT][CAL_WIDTH];

    private int howManyTask[][] = new int[CAL_HEIGHT][CAL_WIDTH];

    private LocalDate local_date_time;
    private ArrayList<Task> task_list;
    // Now Date
    private LocalDate now;
    private int now_year;
    private int now_month;
    private int now_day;
    private DayOfWeek now_date;

    // Pointing


    //Constructor Of Calendar class
    //Take task_list and make calendar
    MyCalendar(ArrayList<Task> task_list) {
        this.task_list = task_list;
        this.local_date_time = LocalDate.now();
        this.now_year = local_date_time.getYear();
        this.now_month = local_date_time.getMonthValue();
        this.now_day = local_date_time.getDayOfMonth();
        this.now_date = local_date_time.getDayOfWeek();
    }

    //Default Constructor.
    //List of taks will be empty arraylist<Task>

    MyCalendar() {
        this.task_list = new ArrayList<Task>();
        this.local_date_time = LocalDate.now();
        this.now_year = local_date_time.getYear();
        this.now_month = local_date_time.getMonthValue();
        this.now_day = local_date_time.getDayOfMonth();
        this.now_date = local_date_time.getDayOfWeek();
    }

    static public MyCalendar getSingleCalendar(){
        if(singleCalendar == null){
            singleCalendar = new MyCalendar();

        }
        return singleCalendar;
    }

    static public MyCalendar getSingleCalendar(ArrayList<Task> task_list){
        if(singleCalendar == null){
            singleCalendar = new MyCalendar(task_list);
        }
        return singleCalendar;
    }
}