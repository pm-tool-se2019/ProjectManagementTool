package main.java.Calendar;

/**
 * Created by ATEZ on 2019-06-10.
 */
public class LastModified {

    private static LastModified lastModified;

    private int _year;
    private int _month;
    private int _day;

    LastModified(){
        _year = 1901;
        _month = 1;
        _day = 1;
    }

    LastModified(int year, int month, int day){
        _year = year;
        _month = month;
        _day = day;
    }

    static public LastModified getInstance(int year, int month, int day){
        if(lastModified == null){
            lastModified = new LastModified(year,month,day);
        }
        return lastModified;
    }

    public void setLastModifiedDay(int year, int month, int day){
        if(lastModified == null){
            lastModified = new LastModified(year,month,day);
        }
        _year = year;
        _month = month;
        _day = day;
    }

    public int getYear(){return _year;}
    public int getMonth(){return _month;}
    public int getDay(){return _day;}

    public int[] getLastModifiedDay(){
        int[] ret = {_year,_month,_day};
        return ret;
    }
}