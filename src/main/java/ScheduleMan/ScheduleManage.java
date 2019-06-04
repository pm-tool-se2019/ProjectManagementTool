package ScheduleMan;

import DataClass.Task;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;


import ScheduleMan.firebase4j.firebasesrc.model.FirebaseResponse;
import ScheduleMan.firebase4j.firebasesrc.service.Firebase;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import ScheduleMan.firebase4j.firebasesrc.error.FirebaseException;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ScheduleManage{
    // For Connect with Firebase remote DB
    public static String firebase_baseUrl = "https://cau2019se-pmt.firebaseio.com/";
    public static String firebase_apiKey = "";

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

    // For testing

//    public static void main(String[] args) throws FirebaseException, UnsupportedEncodingException {
//        Firebase firebase = new Firebase(firebase_baseUrl);
//        ArrayList<Task> tasks = new ArrayList<>();
//        Task task= new Task(11, "TL1", "making TaskList1 function", 2019, 01, 01, 2019, 05, 29, "DOING", 1);
//        Task task2 = new Task(12, "TL2", "making TaskList2 function", 2019, 01, 01, 2019, 05, 29, "TODO", 2);
//        Task task3 = new Task(13, "TL3", "making TaskList3 function", 2019, 01, 01, 2019, 05, 28, "TODO", 1);
//        Task task4 = new Task(14, "TL4", "making TaskList4 function", 2019, 01, 01, 2019, 05, 27, "TODO", 3);
//
//        tasks.add(task);
//        tasks.add(task2);
//        tasks.add(task3);
//        tasks.add(task4);

        // DATA INSERT TEST

//        for (Task instance : tasks){
//            Gson gson = new Gson();
//            String jsonified_task = gson.toJson(instance);
//            firebase.put("/Task/" + instance.getId(),jsonified_task);
//
//        }

        // DATA PULL TEST
        // Data not found check -> equals("null").
        // Because RawBody returns string "null" when failed to found data.

//        int pull_id = 19;
//        FirebaseResponse response = firebase.get("/Task/"+(pull_id));
//        System.out.println(response);
//        Gson gson = new Gson();
//        String taskjson = response.getRawBody();
//        System.out.println(taskjson);
//        if(taskjson.equals("null")){
//            System.out.println("Null");
//            return;
//        }
//        Task receivedtask = gson.fromJson(taskjson, Task.class);
//        System.out.println(receivedtask.getDescription()+ '\n' + receivedtask.getId() + '\n' + receivedtask.getState());

//    }


}



