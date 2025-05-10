package src.model;

import java.time.LocalDate;

public class CaseInfo {
    private int caseID;
    private String title;
    private String description;
    private LocalDate dateOpened;
    private LocalDate dateClosed;

    public CaseInfo(int caseID, String title, String description, LocalDate dateOpened, LocalDate dateClosed) {
        this.caseID = caseID;
        this.title = title;
        this.description = description;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;
    }

    public CaseInfo(String title, String description, LocalDate dateOpened, LocalDate dateClosed) {
        this.title = title;
        this.description = description;
        this.dateOpened = dateOpened;
        this.dateClosed = dateClosed;
    }

    public CaseInfo() {

    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
    }

    public LocalDate getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDate dateClosed) {
        this.dateClosed = dateClosed;
    }
}