package DataClass;

import java.util.ArrayList;

public class Team_Member {
    private int id;
    private String name;
    private String phone;
    private String email;
    private ArrayList<Task> assigned_task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        /* 정규식을 통해 번호 양식 검증하는 routine 추가 예정 */
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        /* 정규식을 통해 이메일 양식 검증하는 routine 추가 예정 */
        this.email = email;
    }

    public ArrayList getAssignedTask() {
        return assigned_task;
    }

    public void addTask(Task newtask) {
        this.assigned_task.add(newtask);
    }

    /* deleteTask 등 나중에 추가 */
}
