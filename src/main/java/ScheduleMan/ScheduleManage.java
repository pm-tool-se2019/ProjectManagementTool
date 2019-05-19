package ScheduleMan;

import DataClass.Task;

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
        /* firebase DB와 동기화하는 함수. id가 자신인 값만 가져온다. */
    }

    static private void broadcastTask(Task task){
        /* 생성된 Task 객체를 타 모듈들로 전달해주는 함수 */
    }


}



