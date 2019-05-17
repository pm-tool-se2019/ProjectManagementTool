package ScheduleMan;

import DataClass.Task;
import DataClass.Team_Member;

import java.util.ArrayList;

public class ScheduleManage{

    /* Tasklist에서 받아온 task 목록을 저장하는 변수값. 현재 유저의 task list */
    public static ArrayList<Task> current_user_task_list;

    private static Task searchFromTaskList(int id){
        for(Task t : current_user_task_list){
            if(t.getId()==id){
                return t;
            }
        }
        return null;    // 존재하지 않을시 null return
    }

    static public void addTask(Task t){
        /* t에 관련된 인자들을 input으로 입력받아 각 멤버 변수에 할당하는 함수 */
        current_user_task_list.add(t);
        syncDB();
    }

    static public void deleteTask(int id){
        Task target = searchFromTaskList(id);
        if(!current_user_task_list.contains(target)){
            System.out.println("해당 Task가 존재하지 않습니다.");
        }
        else{
            current_user_task_list.remove(target);
        }
        syncDB();
    }

    static public void updateTask(int id){
        Task target = searchFromTaskList(id);
        /* id를 통해 firebase의 DB 내 검색해서 가져오는 함수 */
        // syncDB();
    }

    static private Task fetchDB(int id){
        /* firebase DB에서 id로 검색하여 해당 Task를 가져오는 함수 */
        return null; // 임시값
    }

    static private void syncDB(){
        /* firebase DB와 동기화하는 함수. user id가 자신인 값만 가져온다. */
    }

}



