package DataClass;// src.main.java.DataClass.Task 객체를 정의하는 Class
// Written by Song Jun ho(RE-A).

public class Task {
    private int id;
    private String task_name;
    private String description;
    private int start_year;
    private int start_month;
    private int start_day;
    private int end_year;
    private int end_month;
    private int end_day;
    private states state;
    private int hierarchy;

    public Task(int id, String task_name, String description, int start_year, int start_month, int start_day, int end_year, int end_month, int end_day, String state, int hierarchy) {
        this.id = id;
        this.task_name = task_name;
        this.description = description;
        this.start_year = start_year;
        this.start_month = start_month;
        this.start_day = start_day;
        this.end_year = end_year;
        this.end_month = end_month;
        this.end_day = end_day;
        this.state = states.valueOf(state);
        this.hierarchy = hierarchy;
    }

    public String getTaskName() {
        return task_name;
    }

    public void setTaskName(String task_name) {
        this.task_name = task_name;
    }

    private enum states {TODO, DOING, DONE}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartYear() {
        return start_year;
    }

    public void setStartYear(int start_year) {      // // 이론상 모든 정수값 가능하므로 검증 불필요
        this.start_year = start_year;
    }

    public int getStartMonth() {
        return start_month;
    }

    public void setStartMonth(int start_month) {
        if(0<start_month && start_month<=12){
            this.start_month = start_month;
        }
        else{
            System.out.println("입력값 오류. 다시 한번 확인해주세요");
        }
    }

    public int getStartDay() {
        return start_day;
    }

    public void setStartDay(int start_day) {
        if(0<start_day && start_day<=12){
            this.start_day = start_day;
        }
        else{
            System.out.println("입력값 오류. 다시 한번 확인해주세요");
        }
    }

    public int getEndYear() {
        return end_year;
    }

    public void setEndYear(int end_year) {
        this.end_year = end_year;
    }

    public int getEndMonth() {
        return end_month;
    }

    public void setEndMonth(int end_month) {
        if(0<end_month && end_month<=31){
            this.end_month = end_month;
        }
        else{
            System.out.println("입력값 오류. 다시 한번 확인해주세요");
        }
    }

    public int getEndDay() {
        return end_day;
    }

    public void setEndDay(int end_day) {
        if(0<end_day && end_day<=31){
            this.end_day = end_day;
        }
        else{
            System.out.println("입력값 오류. 다시 한번 확인해주세요");
        }
    }

    public int getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(int hierarchy) {
        if(0<= hierarchy && hierarchy <=100){
            this.hierarchy = hierarchy;
        }
        else{
            System.out.println("입력값 오류. 다시 한번 확인해주세요");
        }
    }


    public void setState(String input) {
        states input_state = null;
        try {
            input_state = states.valueOf(input);
        } catch (java.lang.IllegalArgumentException e) {
            System.out.println("입력값 오류. 다시 한번 확인해주세요");
        }
        this.state = input_state;
    }

    public String getState(){
        return this.state.name();
    }



// 디버깅용 main 코드. 필요할 시 주석 제거하고 사용하면 됨.
/*
    public static void main(String args[]) {
        src.main.java.DataClass.Task a = new src.main.java.DataClass.Task(1, "task1", "sample", 2008, 5, 12, 2008, 5, 20, "TODO", 1);
        System.out.println(a.getState().getClass());
        System.out.println(a.getState());
    }
*/

/*        if(a.setState("sds")){           // 이 곳에 값을 넣어서 확인해 봅시다.
            System.out.println(a.getState());
        }
        else{
            System.out.println("입력 오류");
        }*/

}



