package main.java.ScheduleMan;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import main.java.DataClass.Task;
import java.io.UnsupportedEncodingException;


import main.java.ScheduleMan.firebase4j.firebasesrc.model.FirebaseResponse;
import main.java.ScheduleMan.firebase4j.firebasesrc.service.Firebase;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import main.java.ScheduleMan.firebase4j.firebasesrc.error.FirebaseException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;


import java.util.ArrayList;
import java.util.Map;

public class ScheduleManage{
    // For Connect with Firebase remote DB
    public static String firebase_baseUrl = "https://cau2019se-pmt.firebaseio.com/";

    /* Current user's task list. This var will be shared with all of other modules. */
    public static ArrayList<Task> current_user_task_list = new ArrayList<>();

    public static Task searchFromTaskList(int id){
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

        if(current_user_task_list == null){
            current_user_task_list = new ArrayList<Task>();
        }
        current_user_task_list.add(t);
        Firebase firebase = new Firebase(firebase_baseUrl);
        Gson gson = new Gson();
        String jsonified_task = gson.toJson(t);
        firebase.put("/Task/" + t.getId(),jsonified_task);
    }

    static public void deleteTask(Task t) throws FirebaseException, UnsupportedEncodingException {
        /* Delete the Task from current_user_task_list and Firebase DB.
        * But, the object will not be deleted by GC? */
        Task target = searchFromTaskList(t.getId());
        if(!current_user_task_list.contains(target)){
            System.out.println("Task does not found.");
            return;
        }
        else{
            Firebase firebase = new Firebase(firebase_baseUrl);
            firebase.delete("/Task/"+target.getId());
            current_user_task_list.remove(target);
        }
    }

    static public void updateTask(int oldid, int id, String task_name, String description, int start_year, int start_month, int start_day, int end_year, int end_month, int end_day, String state, int hierarchy) throws UnsupportedEncodingException, FirebaseException {
        // Updating the Task information.
        Task target = searchFromTaskList(oldid);
        if(target == null){
            target = fetchFromDB(oldid);
            current_user_task_list.add(target);
        }
        deleteTask(target);

        Task newtask = new Task(id, task_name, description, start_year, start_month, start_day, end_year, end_month, end_day ,state, hierarchy);
        addTask(newtask);
    // Update function by GUI here.
    }

    static private Task fetchFromDB(int id) throws FirebaseException, UnsupportedEncodingException {
        /*
         Fetch specific Task from DB using task id.
         Use when cannot find task from current_user_task_list.
         Return Task or null(failed to find).
        */
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
    
    static public void fetchAllFromDB() throws FirebaseException, UnsupportedEncodingException {
        /*
         Get all Tasks from firebase DB. It should be used when the program start. 
         All tasks are saved at current_user_task_list.

         WARNING : Does not inspect when the database is empty.
        */
        current_user_task_list = new ArrayList<Task>();
        Firebase firebase = new Firebase(firebase_baseUrl);
        FirebaseResponse response = firebase.get("/Task/");
        Gson gson = new Gson();
        Map<String, Object> taskmap = response.getBody();

        // Map -> json -> Task Process
        for(String taskkey : taskmap.keySet()){
            String jsonified = gson.toJson(taskmap.get(taskkey));
            Task t = gson.fromJson(jsonified, Task.class);
            current_user_task_list.add(t);
        }

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

//        JsonObject tasks_as_json = new JsonParser().parse(taskjson).getAsJsonObject();
//        System.out.println(tasks_as_json);
//        JsonArray json_array= tasks_as_json.getAsJsonArray("Task");
//
//        for(int i=0; i<json_array.size();i++){
//            Task t = gson.fromJson(json_array.get(i), Task.class);
//            current_user_task_list.add(t);
//        }
//        System.out.println(current_user_task_list);
//    }


}




