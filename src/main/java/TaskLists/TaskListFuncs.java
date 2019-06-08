package TaskLists;


import java.util.ArrayList;
import DataClass.Task;
import DataClass.Team_Member;
import java.time.LocalDateTime;
import java.time.Month;
public class TaskListFuncs {
    static public void TaskListFuncs() {

    }

    public static void main(String args[]) { //Main func for testing
        ArrayList memberList = new ArrayList<Team_Member>();
        Team_Member member1 = new Team_Member();
        Team_Member member2 = new Team_Member();
        memberList.add(0, member1);
        memberList.add(1, member2);
        member1.setId(1);
        member2.setId(2);

        Task task1 = new Task(11, "TL1", "making TaskList1 function", 2019, 06, 03, 2019, 05, 29, "TODO", 1);
        Task task2 = new Task(12, "TL2", "making TaskList2 function", 2019, 01, 01, 2019, 05, 29, "TODO", 2);
        Task task3 = new Task(13, "TL3", "making TaskList3 function", 2019, 01, 01, 2019, 05, 28, "DOING", 1);
        Task task4 = new Task(14, "TL4", "making TaskList4 function", 2019, 01, 01, 2019, 05, 27, "TODO", 3);

        member1.addTask(task1);
        member1.addTask(task2);
        member2.addTask(task3);
        member2.addTask(task4);

        showTodoList(1, memberList);
        showTodoList(2, memberList);
        showDoingList(1,memberList);
        showDoingList(2,memberList);
        showDoneList(1,memberList);
        showDoneList(2,memberList);
        alarmTodayTask(1,memberList);
        alarmTodayTask(2,memberList);
    }


    static public void showTodoList(int member_id, ArrayList memberList) {//The method for showing 'Todo' list, after checking out with console window, GUI is gonna be implemented 
        int member_index = 0;
        for (; member_index < memberList.size(); member_index++) {//The first, checking each member in the order.
            Team_Member member = (Team_Member) memberList.get(member_index);
            if (member_id == member.getId()) {//If it is the member who is matched with the condition
                ArrayList<Task> task_lists = member.getAssignedTask();
                for (Task temp_task : task_lists) {
                    //  getstate 함수로 TODO, DOING, DONE을 얻어서 switch 문으로 분기하는게 코드가 줄지 않을까?
                    if (temp_task.getState() == "TODO") {
                        System.out.println(temp_task.getTaskName() + "의 상태는 TODO입니다.");
                    }
                }
            }
        }
    }

    static public void showDoingList(int member_id, ArrayList memberList) {
        int member_index = 0;
        for (; member_index < memberList.size(); member_index++) {//The first, checking each member in the order.
            Team_Member member = (Team_Member) memberList.get(member_index);
            if (member_id == member.getId()) {//If it is the member who is matched with the condition
                ArrayList<Task> task_lists = member.getAssignedTask();
                for (Task temp_task : task_lists) {

                    if (temp_task.getState() == "DOING") {
                        System.out.println(temp_task.getTaskName() + "의 상태는 DOING입니다.");
                    }
                }
            }

        }//The method for showing 'Doing' list. The GUI plan is same with the method 'showTodoList'
    }

    static public void showDoneList(int member_id, ArrayList memberList) {
        int member_index = 0;
        for (; member_index < memberList.size(); member_index++) {//The first, checking each member in the order.
            Team_Member member = (Team_Member) memberList.get(member_index);
            if (member_id == member.getId()) {//If it is the member who is matched with the condition
                ArrayList<Task> task_lists = member.getAssignedTask();
                for (Task temp_task : task_lists) {

                    if (temp_task.getState() == "DONE") {
                        System.out.println(temp_task.getTaskName() + "의 상태는 DONE입니다.");
                    }
                }
            }

        }//The method for showing 'Done' list. The GUI plan is same with the method 'showTodoList'
    }
    static public void alarmTodayTask(int member_id, ArrayList memberList) {
        int member_index = 0;
        for (; member_index < memberList.size(); member_index++) {//The first, checking each member in the order.
            Team_Member member = (Team_Member) memberList.get(member_index);
            if (member_id == member.getId()) {//If it is the member who is matched with the condition
                ArrayList<Task> task_lists = member.getAssignedTask();
                LocalDateTime today = LocalDateTime.now();
                for (Task temp_task : task_lists) {

                    if (temp_task.getState() == "TODO" && temp_task.getStartYear() == today.getYear() && temp_task.getStartMonth() == today.getMonthValue() && temp_task.getStartDay() == today.getDayOfMonth()) {
                        System.out.println(temp_task.getTaskName() + "는 오늘부터 시작해야하는 일입니다.");
                    }
                }
            }

        }
    }//The method for users to alarm their each tasks to do today

}