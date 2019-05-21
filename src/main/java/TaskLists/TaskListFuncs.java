package TaskLists;
import java.util.ArrayList;
import DataClass.Task;
import DataClass.Team_Member;



public class TaskListFuncs {
    static public void TaskListFuncs(){

    }
    public static void main (String args[]){
        ArrayList memberList = new ArrayList<Team_Member>();
        Team_Member member1 = new Team_Member();
        Team_Member member2 = new Team_Member();
        member1.setId(1);
        member2.setId(1);
        Task task1 = new Task(11, "TL1", "making TaskList1 function", 2019, 01, 01, 2019, 05, 29, "DOING", 1);
        Task task2 = new Task(12, "TL2", "making TaskList2 function", 2019, 01, 01, 2019, 05, 29, "TODO", 2);
        Task task3 = new Task(13, "TL3", "making TaskList3 function", 2019, 01, 01, 2019, 05, 28, "TODO", 1);
        Task task4 = new Task(14, "TL4", "making TaskList4 function", 2019, 01, 01, 2019, 05, 27, "TODO", 3);
        member1.addTask(task1);
        member1.addTask(task2);
        member2.addTask(task3);
        member2.addTask(task4);
        memberList.add(0,member1);
        memberList.add(1,member2);


        showTodoList( 1, memberList);

    }


    static public void showTodoList(int member_id, ArrayList memberList) {

        int member_index = 0;
        for(; member_index < memberList.size(); member_index ++){//먼저 맴버리스트 훓음

            if( member_id == memberList.) {//찾고 있는 맴버일 경우
                for(int task_index = 0; task_index < getAssignedTask().size(); task_index ++){
                    //그 맴버의 assgined_task훓음
                    Task tempTask = (Task)(memberList[member_index].getAssignedTask().get(task_index));
                    if( tempTask.getState() == "TODO" ){
                        for(int i = 0; i< memberList[member_index].getAssignedTask().size();i++)
                        System.out.println(memberList[member_index].getAssignedTask().get(i)+ "\n");
                        //해당 task 출력
                    }
                }
            }
        }
    }
}
