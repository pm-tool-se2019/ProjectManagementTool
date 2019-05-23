package TaskLists;
import java.util.ArrayList;
import DataClass.Task;
import DataClass.Team_Member;



public class TaskListFuncs {
    static public void TaskListFuncs(){

    }
    public static void main (String args[]){ // 혼자 재대로 작동하는지 돌려보기 위한 시험용 메인함수
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


    static public void showTodoList(int member_id, ArrayList memberList) {//해야할 일 (Todo)를 보여주는 기능-먼저 콘솔로 테스트 후 GUI로 구현 예정

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

    static public void showDoingList(int member_id, ArrayList memberList) {}//하는 중의 일(Doing)를 보여주는 기능-먼저 콘솔로 테스트 후 GUI로 구현 예정
    static public void showDoneList(int member_id, ArrayList memberList) {}//끝난 일(Done)를 보여주는 기능-먼저 콘솔로 테스트 후 GUI로 구현 예정
    static public void AlarmTodayTask(int member_id, ArrayList memberList) {}//오늘 할 업무를 따로 알람으로 알려주는 기능