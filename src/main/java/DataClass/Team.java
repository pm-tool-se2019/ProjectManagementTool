package DataClass;

import java.util.ArrayList;

public class Team {
    private int id;
    private String team_name;
    private ArrayList<Team_Member> team_members;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return team_name;
    }

    public void setTeamName(String team_name) {
        this.team_name = team_name;
    }

    public ArrayList<Team_Member> getTeamMembers() {
        return team_members;
    }

    public void addTeamMembers(Team_Member team_member) {
        this.team_members.add(team_member);
    }
}
