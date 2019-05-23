package ScheduleMan;

import DataClass.Task;

import java.util.ArrayList;

public class ScheduleManage{

    /* Current user's task list. This var will be shared with all of other modules. */
    public static ArrayList<Task> current_user_task_list;

    private static Task searchFromTaskList(int id){
        for(Task t : current_user_task_list){
            if(t.getId()==id){
                return t;
            }
        }
        return null;    // Not found case
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

        // syncDB();
    }

    static private Task fetchDB(int id){

        return null; // temp
    }

    static private void syncDB(){

    }

    static private void broadcastTask(Task task){

    }


}



