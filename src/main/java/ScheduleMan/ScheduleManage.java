package main.java.ScheduleMan;

import main.java.DataClass.Task;
import java.io.UnsupportedEncodingException;


import main.java.ScheduleMan.firebase4j.firebasesrc.model.FirebaseResponse;
import main.java.ScheduleMan.firebase4j.firebasesrc.service.Firebase;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import main.java.ScheduleMan.firebase4j.firebasesrc.error.FirebaseException;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ScheduleManage{
    // For Connect with Firebase remote DB
    public static String firebase_baseUrl = "https://cau2019se-pmt.firebaseio.com/";

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

    static public void addTask(Task t) throws FirebaseException, UnsupportedEncodingException {
        /*
         Add task to current_user_task_list and Firebase DB.
         @param : Task is you want to add. It should pre-defined from other interface.
         This method does not give a function of setting property of task object.
        */
        current_user_task_list.add(t);
        Firebase firebase = new Firebase(firebase_baseUrl);
        Gson gson = new Gson();
        String jsonified_task = gson.toJson(t);
        firebase.put("/Task/" + t.getId(),jsonified_task);
    }

    static public void deleteTask(int id) throws FirebaseException, UnsupportedEncodingException {
        /* Delete the Task from current_user_task_list and Firebase DB.
        * But, the object will not be deleted by GC? */
        Task target = searchFromTaskList(id);
        if(!current_user_task_list.contains(target)){
            System.out.println("해당 Task가 존재하지 않습니다.");
            return;
        }
        else{
            Firebase firebase = new Firebase(firebase_baseUrl);
            firebase.delete("/Task/"+target.getId());
            current_user_task_list.remove(target);
        }
    }

    static public void updateTask(int id) throws UnsupportedEncodingException, FirebaseException {
        Task target = searchFromTaskList(id);
        if(target == null){
            target = fetchFromDB(id);
            current_user_task_list.add(target);
        }
    // Update function by GUI here.

    }

    static private Task fetchFromDB(int id) throws FirebaseException, UnsupportedEncodingException {
        Firebase firebase = new Firebase(firebase_baseUrl);
        FirebaseResponse response = firebase.get("/Task/"+(id));
        Gson gson = new Gson();
        String task_json = response.getRawBody();
        System.out.println(task_json);
        if(task_json.equals("null")){
            System.out.println("Null");
            return null;
        }
        Task receivedtask = gson.fromJson(task_json, Task.class);
        return receivedtask;
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



