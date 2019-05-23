package Calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
*/
import DataClass.Task;

class CalendarDataManager{
    final private int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
}

class MyCalendar {
    static final int CAL_WIDTH = 7;
    static final int CAL_HEIGHT = 6;

    private Date[][] calendar_dates = new Date[CAL_HEIGHT][CAL_WIDTH];
    private Calendar calendar;
    private ArrayList<Task> task_list;

    // Now Date
    private int now_year;
    private int now_month;
    private int now_day;
    // Pointing(

    //Constructor Of Calendar class
    //Take task_list and make calendar
    MyCalendar(ArrayList<Task> task_list) {
        this.task_list = task_list;
        this.calendar = Calendar.getInstance();
        this.now_year = calendar.set(Calendar.);
    }

    //Default Constructor.
    //List of taks will be empty arraylist<Task>
    MyCalendar() {
        this.task_list = new ArrayList<Task>();
        this.calendar = Calendar.getInstance();
    }
}




