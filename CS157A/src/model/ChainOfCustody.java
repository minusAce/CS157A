package src.model;

import java.time.LocalDateTime;

public class ChainOfCustody {
    private int personnelID;
    private int evidenceID;
    private LocalDateTime dateLogged;

    public ChainOfCustody(int personnelID, int evidenceID, LocalDateTime dateLogged) {
        this.personnelID = personnelID;
        this.evidenceID = evidenceID;
        this.dateLogged = dateLogged;
    }

    public int getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(int personnelID) {
        this.personnelID = personnelID;
    }

    public int getEvidenceID() {
        return evidenceID;
    }

    public void setEvidenceID(int evidenceID) {
        this.evidenceID = evidenceID;
    }

    public LocalDateTime getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(LocalDateTime dateLogged) {
        this.dateLogged = dateLogged;
    }
}
