package main.java.TaskLists;


import java.util.ArrayList;
import main.java.DataClass.Task;
import main.java.DataClass.Team_Member;
import java.time.LocalDateTime;
import java.time.Month;
public class TaskListFuncs {

    public static void main(String args[]) { //Main func for testing
        ArrayList TaskList = new ArrayList<Task>();

        Task task1 = new Task(11, "TL1", "making TaskList1 function", 2019, 06, 03, 2019, 05, 29, "TODO", 1);
        Task task2 = new Task(12, "TL2", "making TaskList2 function", 2019, 01, 01, 2019, 05, 29, "DONE", 2);
        Task task3 = new Task(13, "TL3", "making TaskList3 function", 2019, 01, 01, 2019, 05, 28, "DOING", 1);
        Task task4 = new Task(14, "TL4", "making TaskList4 function", 2019, 01, 01, 2019, 05, 27, "TODO", 3);
        TaskList.add(task1);
        TaskList.add(task2);
        TaskList.add(task3);
        TaskList.add(task4);

        showDoneList(TaskList);
        showDoneList(TaskList);
        showTodoList(TaskList);
        alarmTodayTask(TaskList);
    }


    static public void showTodoList(ArrayList TaskList) {//The method for showing 'Todo' list, after checking out with console window, GUI is gonna be implemented
        if (TaskList == null) TaskList = new ArrayList<Task>();
        for (int i = 0; i < TaskList.size(); i++) {
            Task temp = (Task) (TaskList.get(i));
            if (temp.getState() == "DONE") {
                System.out.println(temp.getTaskName() + "의 상태는 TODO입니다.");

            }//The method for showing 'TODO' list. The GUI plan is same with the method 'showTodoList'
        }
    }

    static public void showDoingList(ArrayList TaskList) {
        if (TaskList == null) TaskList = new ArrayList<Task>();
        for (int i = 0; i < TaskList.size(); i++) {
            Task temp = (Task) (TaskList.get(i));
            if (temp.getState() == "DOING") {
                System.out.println(temp.getTaskName() + "의 상태는 DOING입니다.");

            }
        }//The method for showing 'Doing' list. The GUI plan is same with the method 'showTodoList'
    }

    static public void showDoneList(ArrayList TaskList) {
        if (TaskList == null) TaskList = new ArrayList<Task>();
        for (int i = 0; i < TaskList.size(); i++) {
            Task temp = (Task) (TaskList.get(i));
            if (temp.getState() == "DONE") {
                System.out.println(temp.getTaskName() + "의 상태는 DONE입니다.");

            }//The method for showing 'Done' list. The GUI plan is same with the method 'showTodoList'
        }
    }


    static public void alarmTodayTask(ArrayList TaskList) {
        if (TaskList == null) TaskList = new ArrayList<Task>();
        for (int i = 0; i < TaskList.size(); i++) {
            Task temp = (Task) (TaskList.get(i));
            LocalDateTime today = LocalDateTime.now();
            if (temp.getState() == "TODO"
                    && temp.getStartYear() == today.getYear()
                    && temp.getStartMonth() == today.getDayOfMonth()
                    && temp.getStartDay() == today.getDayOfMonth()) {
                System.out.println(temp.getTaskName() + "은 오늘 새로 시작해야할 일입니다.");

            }
        }
    }//The method for users to alarm their each tasks to do today
}
