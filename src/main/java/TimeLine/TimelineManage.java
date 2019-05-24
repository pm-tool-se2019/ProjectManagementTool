package Timeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import DataClass.Task;



public class TimelineManage {
	
	
	public ArrayList<Task> task_list;
    static public void TimelineManage(){this.task_list = new ArrayList<Task>();}//default empty
    
    static public void TimelinManage(ArrayList<Task> list){
    	this.task_list = list;
    	ByStartDate start = new ByStartDate();//to draw timeline, sort the tasklist by start date
        Collections.sort(task_list, start);
    }
    
    static public void search(int Date){//passing Date input 
    	Search search = new Search();
    	ArrayList<Integer> resulthArr = search.searchByDate(this.task_list, Date);
    }
    
    private void sortByEndDate() {//provide users - different way to draw the timeline
    	ByEndDate end = new ByEndDate();
        Collections.sort(task_list, end);
    }
    
}


class ByStartDate implements Comparator<Task> {//using comparator - date sort by start date
    @Override
    public int compare(Task s1, Task s2) {
		if (s1.getStartYear() < s2.getStartYear()) {
			return -1;
		} else if (s1.getStartYear() > s2.getStartYear()) {
			return 1;
		} else {
			if(s1.getStartMonth() < s2.getStartMonth()) {
				return -1;
			}else if(s1.getStartMonth() > s2.getStartMonth()) {
				return 1;
			}else {
				if(s1.getStartDay() < s2.getStartDay()) {
					return -1;
				}else if(s1.getStartDay() > s2.getStartDay()) {
					return 1;
				}
			}
		}     	
		return 0;
	}
 
}
 

class ByEndDate implements Comparator<Task> {//using comparator - date sort by end date point
    @Override
    public int compare(Task s1, Task s2) {
		if (s1.getEndYear() < s2.getEndYear()) {
			return -1;
		} else if (s1.getEndYear() > s2.getEndYear()) {
			return 1;
		} else {
			if(s1.getEndMonth() < s2.getEndMonth()) {
				return -1;
			}else if(s1.getEndMonth() > s2.getEndMonth()) {
				return 1;
			}else {
				if(s1.getEndDay() < s2.getEndDay()) {
					return -1;
				}else if(s1.getEndDay() > s2.getEndDay()) {
					return 1;
				}
			}
		}     	
		return 0;
	}
 
 
}

public class Search{

	public ArrayList<Integer> searchByDate(ArrayList<Task> task_list, int day){//search tasklist by day
		int index = 0;
		ArrayList<Integer> indexNumbers = new ArrayList();
    	for(Task task:task_list) {
    		index++;
    		if(task.getEndDay()== date || task.getEndDay()==date){
    			indexNumbers.add(index);
    		}
    	}
    	return indexNumbers;
	}
	public ArrayList<Integer> searchByDate(ArrayList<Task> task_list, int month, int day){
		// get any of data(year,month,date)
		int index = 0;
    	ArrayList indexNumbers = new ArrayList();
    	return indexNumbers;
	}
	
    public ArrayList<Integer> searchByDate(ArrayList<Task> task_list, int year, int month, int day){
    	// get any of data(year,month,date)
    }
}



