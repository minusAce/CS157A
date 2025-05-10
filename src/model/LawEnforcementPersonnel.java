package src.model;

public class LawEnforcementPersonnel {
    private int personnelID;
    private String name;
    private String role;

    public LawEnforcementPersonnel(int personnelID, String name, String role) {
        this.personnelID = personnelID;
        this.name = name;
        this.role = role;
    }

    public LawEnforcementPersonnel(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public LawEnforcementPersonnel() {

    }

    public int getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}